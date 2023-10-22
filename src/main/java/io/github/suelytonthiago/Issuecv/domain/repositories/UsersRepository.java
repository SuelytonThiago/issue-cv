package io.github.suelytonthiago.Issuecv.domain.repositories;

import io.github.suelytonthiago.Issuecv.domain.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByEmail(String email);
}
