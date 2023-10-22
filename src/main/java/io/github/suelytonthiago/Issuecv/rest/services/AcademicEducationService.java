package io.github.suelytonthiago.Issuecv.rest.services;

import io.github.suelytonthiago.Issuecv.domain.entites.AcademicEducation;
import io.github.suelytonthiago.Issuecv.domain.repositories.AcademicEducationRepository;
import io.github.suelytonthiago.Issuecv.rest.dto.AcademyEducationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcademicEducationService {

    @Autowired
    private AcademicEducationRepository educationRepository;

    public List<AcademicEducation> saveAll(List<AcademyEducationRequestDto> educations){
        return educationRepository.saveAll(educations.stream().map(education ->{
                    return AcademicEducation.of(education);
        }).collect(Collectors.toList()));
    }
}
