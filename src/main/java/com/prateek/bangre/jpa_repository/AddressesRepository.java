package com.prateek.bangre.jpa_repository;

import com.prateek.bangre.model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
public interface AddressesRepository extends CrudRepository<Addresses, Integer> {
}
