package com.prateek.bangre.jpa_repository;


import com.prateek.bangre.model.Users;
import com.prateek.bangre.model.UsersRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author prateek.bangre on 26/04/20.
 * @Project Shoping-Backend
 */
public interface UsersRepository extends CrudRepository<Users, Integer> {

    @Modifying
    @Query(value="update users set username=?1, password=?2, email=?3, fname=?4, lname=?5, age=?6 where id=?7", nativeQuery = true)
    int updateUserDetails(String username, String password, String email, String fname, String lname, int age, int id);

    Users findByEmail(String email);
}
