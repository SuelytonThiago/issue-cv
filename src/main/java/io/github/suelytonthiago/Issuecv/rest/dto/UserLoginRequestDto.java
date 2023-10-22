package io.github.suelytonthiago.Issuecv.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginRequestDto {

    @NotBlank(message = "The email cannot be empty or null")
    private String email;
    @NotBlank(message = "The password cannot be empty or null")
    private String password;
}
