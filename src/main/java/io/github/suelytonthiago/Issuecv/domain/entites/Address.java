package io.github.suelytonthiago.Issuecv.domain.entites;

import io.github.suelytonthiago.Issuecv.rest.dto.AddressRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zone;
    private String city;
    private String state;
    private String cep;


    public static Address of(AddressRequestDto request){
        return Address.builder()
                .street(request.getStreet())
                .zone(request.getZone())
                .city(request.getCity())
                .state(request.getState())
                .cep(request.getCep())
                .build();
    }
}
