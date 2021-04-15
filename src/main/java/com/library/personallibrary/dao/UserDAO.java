package com.library.personallibrary.dao;

import com.library.personallibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {

    @Query("SELECT u from User u WHERE u.email=?1")
    User findByEmail(String email);
}
