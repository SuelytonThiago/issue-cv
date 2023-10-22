package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.Curriculum;
import io.github.suelytonthiago.Issuecv.domain.entites.ProfessionalExperience;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CurriculumResponseDto {

    private String professionalGoal;

    private UserResponseDto user;

    private List<AcademyEducationResponseDto> educations = new ArrayList<>();
    private List<ProfessionalExperienceResponseDto> experiences = new ArrayList<>();

    public static CurriculumResponseDto of(Curriculum curriculum){
        return CurriculumResponseDto.builder()
                .professionalGoal(curriculum.getProfessionalGoal())
                .user(UserResponseDto.of(curriculum.getUser()))
                .educations(AcademyEducationResponseDto.convertEducationList(curriculum.getEducations()))
                .experiences(ProfessionalExperienceResponseDto.convertExperienceList(curriculum.getExperiences()))
                .build();
    }


}
