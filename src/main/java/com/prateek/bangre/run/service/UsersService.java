package com.prateek.bangre.run.service;

import com.prateek.bangre.jpa_repository.UsersRepository;
import com.prateek.bangre.model.Addresses;
import com.prateek.bangre.model.Users;
import com.prateek.bangre.model.UsersRequest;
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

    public Users updateUsers(Users user) {
        Users user1 = findUsersById(user.getId());
        if (user1 != null) {
            user.setPassword(user1.getPassword());
            user.setPassword(user1.getType());
        }
        return usersRepository.save(user);
    }

    public Users findUsersById(int id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public void deleteUsersById(int id) {
        usersRepository.deleteById(id);
    }

    public int updateUsersWithUsersRequest(UsersRequest usersRequest, int userId) {
        Users user = findUsersById(userId);
        if (usersRequest.getPassword() == null) {
            usersRequest.setPassword(user.getPassword());
        }
        return usersRepository.updateUserDetails(usersRequest.getUsername(), usersRequest.getPassword(),usersRequest.getEmail(), usersRequest.getFname(), usersRequest.getLname(), usersRequest.getAge(), userId);
    }

    public Users findUsersByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
