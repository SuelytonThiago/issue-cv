package io.github.suelytonthiago.Issuecv.domain.entites;

import io.github.suelytonthiago.Issuecv.rest.dto.ProfessionalExperienceRequestDto;
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
public class ProfessionalExperience {

    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String function;
    private String description;



    public static ProfessionalExperience of(ProfessionalExperienceRequestDto request){
        return ProfessionalExperience.builder()
                .companyName(request.getCompanyName())
                .startDate(LocalDate.parse(request.getStartDate(),format))
                .finishDate(LocalDate.parse(request.getFinishDate(),format))
                .function(request.getFunction())
                .description(request.getDescription())
                .build();
    }
}
