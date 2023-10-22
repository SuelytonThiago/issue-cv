package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.AcademicEducation;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class AcademyEducationResponseDto {

    private String institutionName;
    private String startDate;
    private String finishDate;

    public static AcademyEducationResponseDto of(AcademicEducation education){
        return AcademyEducationResponseDto.builder()
                .institutionName(education.getInstitutionName())
                .startDate(education.getStartDate().toString())
                .finishDate(education.getFinishDate().toString())
                .build();
    }

    public static List<AcademyEducationResponseDto> convertEducationList(List<AcademicEducation>educations){
        return educations.stream().map(education -> {
            return AcademyEducationResponseDto.of(education);
        }).collect(Collectors.toList());
    }
}
