package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.AcademicEducation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CurriculumRequestDto {

    @NotBlank(message = "The professional goal cannot be empty or null")
    private String professionalGoal;

    @Valid
    private List<AcademyEducationRequestDto> educations = new ArrayList<>();

    @Valid
    private List<ProfessionalExperienceRequestDto> experiences = new ArrayList<>();

}
