package io.github.suelytonthiago.Issuecv.domain.repositories;

import io.github.suelytonthiago.Issuecv.domain.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address,Long> {
}
