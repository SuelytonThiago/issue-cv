package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.ProfessionalExperience;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ProfessionalExperienceResponseDto {

    private String companyName;
    private String startDate;
    private String finishDate;
    private String function;
    private String description;

    public static ProfessionalExperienceResponseDto of(ProfessionalExperience experience){
        return ProfessionalExperienceResponseDto.builder()
                .companyName(experience.getCompanyName())
                .startDate(experience.getStartDate().toString())
                .finishDate(experience.getFinishDate().toString())
                .function(experience.getFunction())
                .description(experience.getDescription())
                .build();
    }

    public static List<ProfessionalExperienceResponseDto> convertExperienceList(List<ProfessionalExperience> experiences){
        return experiences.stream().map(experience -> {
            return ProfessionalExperienceResponseDto.of(experience);
        }).collect(Collectors.toList());
    }
}
