package io.github.suelytonthiago.Issuecv.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProfessionalExperienceRequestDto {

    @NotBlank(message = "the company name cannot be empty or null")
    private String companyName;
    @NotBlank(message = "the start data cannot be empty or null")
    private String startDate;
    @NotBlank(message = "the finish data cannot be empty or null")
    private String finishDate;
    @NotBlank(message = "the function cannot be empty or null")
    private String function;
    @NotBlank(message = "the description cannot be empty or null")
    private String description;
}
