package io.github.suelytonthiago.Issuecv.rest.services;

import io.github.suelytonthiago.Issuecv.domain.entites.Address;
import io.github.suelytonthiago.Issuecv.domain.repositories.AddressRepository;
import io.github.suelytonthiago.Issuecv.rest.services.exceptions.ObjectNotFoundException;
import io.github.suelytonthiago.Issuecv.rest.dto.AddressRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address findById(Long id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Your address is not found or is not registered"));
    }


    @Transactional
    public Address createNewAddress(AddressRequestDto addressDto){
        return addressRepository.save(Address.of(addressDto));
    }

    @Transactional
    public void updateAddressData(Long id, AddressRequestDto addressDto){
        var address = findById(id) ;
        updateData(address,addressDto);
        addressRepository.save(address);
    }

    private void updateData(Address address, AddressRequestDto addressDto) {
        address.setStreet(addressDto.getStreet());
        address.setZone(addressDto.getZone());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCep(addressDto.getCep());
    }
}
