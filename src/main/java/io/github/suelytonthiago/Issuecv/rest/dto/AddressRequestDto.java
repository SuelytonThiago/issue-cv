package io.github.suelytonthiago.Issuecv.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressRequestDto {

    @NotBlank(message = "the street cannot be empty or null")
    private String street;
    @NotBlank(message = "the zone cannot be empty or null")
    private String zone;
    @NotBlank(message = "the city cannot be empty or null")
    private String city;
    @NotBlank(message = "the state cannot be empty or null")
    private String state;
    @NotBlank(message = "the cep cannot be empty or null")
    private String cep;

}
