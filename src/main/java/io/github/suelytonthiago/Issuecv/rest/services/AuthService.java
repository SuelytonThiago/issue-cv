package io.github.suelytonthiago.Issuecv.rest.services;

import io.github.suelytonthiago.Issuecv.domain.entites.Users;
import io.github.suelytonthiago.Issuecv.domain.repositories.UsersRepository;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.CustomException;
import io.github.suelytonthiago.Issuecv.rest.dto.UserLoginRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Map<String,String> generateTokens(UserLoginRequestDto request){
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
        );
        var user = (Users) authentication.getPrincipal();

        String access_token = jwtService.createAccessToken(user);
        String refresh_token = jwtService.createRefreshToken(user);
        Map<String,String> tokens = new HashMap<>();
        tokens.put("access_token",access_token);
        tokens.put("refresh_token",refresh_token);
        return tokens;
    }

    public String attAccessToken(HttpServletRequest request){
        var email = jwtService.getSubject(request);
        var user = usersRepository.findByEmail(email).get();

        if(jwtService.isTokenValid(request,user)){
            return jwtService.createAccessToken(user);
        }
        throw new CustomException("invalid token");
    }
}
