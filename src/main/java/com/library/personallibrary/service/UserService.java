package com.library.personallibrary.service;

import com.library.personallibrary.api.UserResource;
import com.library.personallibrary.dao.UserDAO;
import com.library.personallibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.findByEmail(email);
        if(user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserResource(user);
    }
}
