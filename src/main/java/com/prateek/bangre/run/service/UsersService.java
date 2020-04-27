package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.UsersRepository;
import com.prateek.bangre.model.Addresses;
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
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAllUsers() {
        List<Users> list = new ArrayList<>();
        usersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public Users updateUsers(Users product) {
        return usersRepository.save(product);
    }

    public Users findUsersById(int id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public void deleteUsersById(int id) {
        usersRepository.deleteById(id);
    }
}
