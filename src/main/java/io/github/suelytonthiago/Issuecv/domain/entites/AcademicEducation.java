package io.github.suelytonthiago.Issuecv.domain.entites;


import io.github.suelytonthiago.Issuecv.rest.dto.AcademyEducationRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class AcademicEducation {

    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String institutionName;
    private LocalDate startDate;
    private LocalDate finishDate;


    public static AcademicEducation of (AcademyEducationRequestDto request){
        return AcademicEducation.builder()
                .institutionName(request.getInstitutionName())
                .startDate(LocalDate.parse(request.getStartDate(),format))
                .finishDate(LocalDate.parse(request.getFinishDate(),format))
                .build();
    }
}
