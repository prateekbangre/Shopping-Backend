package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.AddressesRepository;
import com.prateek.bangre.model.Addresses;
import com.prateek.bangre.model.Products;
import com.prateek.bangre.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Service
@Transactional
public class AddressesService {

    @Autowired
    private AddressesRepository addressesRepository;

    public List<Addresses> findAllAddresses() {
        List<Addresses> list = new ArrayList<>();
        addressesRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void updateAddresses(Addresses product) {
        addressesRepository.save(product);
    }

    public Addresses getAddressesById(int id) {
        Optional<Addresses> optionalUser = addressesRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public void deleteAddressesByID(int id) {
        addressesRepository.deleteById(id);
    }
}
