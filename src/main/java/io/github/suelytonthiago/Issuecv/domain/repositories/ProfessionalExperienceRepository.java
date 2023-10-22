package io.github.suelytonthiago.Issuecv.domain.repositories;

import io.github.suelytonthiago.Issuecv.domain.entites.Curriculum;
import io.github.suelytonthiago.Issuecv.domain.entites.ProfessionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessionalExperienceRepository extends JpaRepository<ProfessionalExperience, Long> {
}
