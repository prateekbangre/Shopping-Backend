package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.UsersRepository;
import com.prateek.bangre.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
@Service
@Transactional
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users update(Users product) {
        return usersRepository.save(product);
    }

    public Users findById(int id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public void delete(int id) {
        usersRepository.deleteById(id);
    }
}
