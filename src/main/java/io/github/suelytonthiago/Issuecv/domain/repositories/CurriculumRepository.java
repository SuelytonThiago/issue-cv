package io.github.suelytonthiago.Issuecv.domain.repositories;

import io.github.suelytonthiago.Issuecv.domain.entites.Curriculum;
import io.github.suelytonthiago.Issuecv.domain.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CurriculumRepository extends JpaRepository<Curriculum,Long> {

    Optional<Curriculum> findByUser(Users user);
}
