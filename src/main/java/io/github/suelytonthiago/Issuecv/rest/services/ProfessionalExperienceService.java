package io.github.suelytonthiago.Issuecv.rest.services;

import io.github.suelytonthiago.Issuecv.domain.entites.ProfessionalExperience;
import io.github.suelytonthiago.Issuecv.domain.repositories.ProfessionalExperienceRepository;
import io.github.suelytonthiago.Issuecv.rest.dto.ProfessionalExperienceRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessionalExperienceService {

    @Autowired
    private ProfessionalExperienceRepository experienceRepository;

    public List<ProfessionalExperience> saveAll(List<ProfessionalExperienceRequestDto> experiences){
        return experienceRepository.saveAll(experiences.stream().map(experience ->{
            return ProfessionalExperience.of(experience);
        }).collect(Collectors.toList()));
    }
}
