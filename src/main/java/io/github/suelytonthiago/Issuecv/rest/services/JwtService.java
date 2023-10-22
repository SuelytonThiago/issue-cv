package io.github.suelytonthiago.Issuecv.rest.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.suelytonthiago.Issuecv.domain.entites.Users;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.AuthenticationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt_secret_password}")
    private String secret;
    @Value("${jwt_data_expiration_access_token}")
    private int expirationAccessToken;
    @Value("${jwt_data_expiration_refresh_token}")
    private int expirationRefreshToken;

    public String createAccessToken(Users users){
        return JWT.create().withSubject(users.getUsername())
                .withClaim("id",users.getId())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationAccessToken))
                .sign(Algorithm.HMAC512(secret));
    }

    public String createRefreshToken(Users users){
        return JWT.create().withSubject(users.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationRefreshToken))
                .sign(Algorithm.HMAC512(secret));
    }

    public String getSubject(HttpServletRequest request){
        var token = getToken(request);
        return JWT.require(Algorithm.HMAC512(secret))
                .build()
                .verify(token)
                .getSubject();
    }

    public Long getClaimId(HttpServletRequest request){
        var token = getToken(request);
        return JWT.require(Algorithm.HMAC512(secret))
                .build()
                .verify(token)
                .getClaim("id")
                .asLong();
    }

    public Date getExpirationDate(HttpServletRequest request){
        var token = getToken(request);
        return JWT.require(Algorithm.HMAC512(secret))
                .build()
                .verify(token)
                .getExpiresAt();
    }

    public boolean isTokenValid(HttpServletRequest request, Users users){
        var token = getToken(request);
        String username = getSubject(request);
        return username.equals(users.getUsername()) && !isTokenExpired(request);
    }

    private boolean isTokenExpired(HttpServletRequest request){
        Date expirationDate = getExpirationDate(request);
        return expirationDate.before(new Date());
    }

    public String getToken(HttpServletRequest request){
        var auth = request.getHeader("Authorization");
        if(auth == null){
            throw new AuthenticationException("User is not authorized");
        }
        var token = auth.replace("Bearer ", "");
        return token;
    }
}
