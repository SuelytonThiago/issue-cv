package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {

    private String name;
    private String email;
    private String password;
    private String contactNumber;

    private AddressResponseDto address;

    public static UserResponseDto of(Users user){
        return UserResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .contactNumber(user.getContactNumber())
                .address(AddressResponseDto.of(user.getAddress()))
                .build();
    }
}
