package io.github.suelytonthiago.Issuecv.rest.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {

    @NotBlank(message = "The name cannot be empty or null")
    private String name;
    @NotBlank(message = "The email cannot be empty or null")
    private String email;
    @NotBlank(message = "The password cannot be empty or null")
    private String password;
    @NotBlank(message = "The contactNumber cannot be empty or null")
    private String contactNumber;

    @Valid
    private AddressRequestDto address;
}
