package com.library.personallibrary.dao;

import com.library.personallibrary.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends CrudRepository<User,Integer> {
    @Override
    List<User> findAll();
}
