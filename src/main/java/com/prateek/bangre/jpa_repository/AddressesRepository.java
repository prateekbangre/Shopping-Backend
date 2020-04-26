package com.prateek.bangre.jpa_repository;

import com.prateek.bangre.model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
public interface AddressesRepository extends JpaRepository<Addresses, Integer> {
}
