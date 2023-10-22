package io.github.suelytonthiago.Issuecv.rest.services;

import io.github.suelytonthiago.Issuecv.domain.entites.Users;
import io.github.suelytonthiago.Issuecv.domain.repositories.UsersRepository;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.CustomException;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.ObjectNotFoundException;
import io.github.suelytonthiago.Issuecv.rest.dto.UserRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class
UserService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AddressService addressService;

    public Users findById(Long id){
        return usersRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("The user is not found"));
    }



    @Transactional
    public void createNewUser(UserRequestDto request){
        usersRepository.findByEmail(request.getEmail()).ifPresent(er ->{
            throw new CustomException("The email already use");
        });
        var address = addressService.createNewAddress(request.getAddress());
        var user = Users.of(request,address);
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    @Transactional
    public void updateUserData(HttpServletRequest request,UserRequestDto userDataUpdate){
        var user = findById(jwtService.getClaimId(request));
        var addressId = user.getAddress().getId();
        addressService.updateAddressData(addressId, userDataUpdate.getAddress());
        updateData(user,userDataUpdate);
        user.setPassword(encoder.encode(user.getPassword()));
        usersRepository.save(user);
    }

    private void updateData(Users user, UserRequestDto userDataUpdate) {
        user.setName(userDataUpdate.getName());
        user.setEmail(userDataUpdate.getEmail());
        user.setPassword(userDataUpdate.getPassword());
        user.setContactNumber(userDataUpdate.getContactNumber());
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = usersRepository.findByEmail(username)
                .orElseThrow(() -> new ObjectNotFoundException("The user is not found"));
        return user;
    }
}
