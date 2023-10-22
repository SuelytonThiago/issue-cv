package io.github.suelytonthiago.Issuecv.domain.repositories;

import io.github.suelytonthiago.Issuecv.domain.entites.Curriculum;
import io.github.suelytonthiago.Issuecv.domain.entites.Issued;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IssuedRepository extends JpaRepository<Issued,Long> {
    Optional<Issued> findByCurriculum(Curriculum curriculum);
}
