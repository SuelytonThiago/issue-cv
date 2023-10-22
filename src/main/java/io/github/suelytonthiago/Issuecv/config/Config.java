package io.github.suelytonthiago.Issuecv.config;

import io.github.suelytonthiago.Issuecv.domain.entites.Address;
import io.github.suelytonthiago.Issuecv.domain.entites.Users;
import io.github.suelytonthiago.Issuecv.domain.repositories.AddressRepository;
import io.github.suelytonthiago.Issuecv.domain.repositories.UsersRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config implements CommandLineRunner   {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        Address address =new Address(null, "rua a", "bairro a", "cidade a", "estado a", "00000000");
        addressRepository.save(address);

        Users user = new Users(null,"joe","joe@example.com",encoder.encode("senha123"),"40028922",address);
        usersRepository.save(user);
    }
}
