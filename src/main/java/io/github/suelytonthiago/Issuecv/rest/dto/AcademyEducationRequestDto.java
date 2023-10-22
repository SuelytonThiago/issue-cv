package io.github.suelytonthiago.Issuecv.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AcademyEducationRequestDto {

    @NotBlank(message = "the institution name cannot be empty or null")
    private String institutionName;
    @NotBlank(message = "the startDate cannot be empty or null")
    private String startDate;
    @NotBlank(message = "the finishDate cannot be empty or null")
    private String finishDate;
}
