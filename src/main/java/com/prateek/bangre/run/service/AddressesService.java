package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.AddressesRepository;
import com.prateek.bangre.model.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Service
@Transactional
public class AddressesService {

    @Autowired
    private AddressesRepository repo;

    public List<Addresses> listAll() {
        return repo.findAll();
    }

    public void save(Addresses product) {
        repo.save(product);
    }

    public Addresses get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
