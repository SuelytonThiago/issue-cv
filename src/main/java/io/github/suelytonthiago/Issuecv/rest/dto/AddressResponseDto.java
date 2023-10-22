package io.github.suelytonthiago.Issuecv.rest.dto;

import io.github.suelytonthiago.Issuecv.domain.entites.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponseDto {

    private String street;
    private String zone;
    private String city;
    private String state;
    private String cep;

    public static AddressResponseDto of(Address address){
        return AddressResponseDto.builder()
                .street(address.getStreet())
                .zone(address.getZone())
                .city(address.getCity())
                .state(address.getState())
                .cep(address.getCep())
                .build();
    }
}
