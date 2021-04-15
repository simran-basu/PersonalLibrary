package com.library.personallibrary.service;

import com.library.personallibrary.dao.UserDAO;
import com.library.personallibrary.exception.UserNotFoundException;
import com.library.personallibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class UserService {
    @Autowired
    private UserDAO userDAO;

    private int useridcount = 1;
    private List<User> userList = new CopyOnWriteArrayList<>();
    public User addUser(User user){
        //user.setUserid(useridcount);
        //userList.add(user);
        //useridcount++;
        return userDAO.save(user);
        //return user;
    }
    public List<User> getUsers(){
        return userDAO.findAll();
        //return userList;
    }
    public User getUser(int userid){
        Optional<User> optionalUser = userDAO.findById(userid);
        if(!optionalUser.isPresent())
        {
            throw new UserNotFoundException("User record is not available!");
        }
        return optionalUser.get();
        //return userList.stream().filter(u -> u.getUserid() == userid).findFirst().get();
    }
    public User updateUserId(int userid, User user){
        user.setUserid(userid);
        /*userList.stream().forEach(u -> {
            if(u.getUserid() == userid)
            {
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setEmail(user.getEmail());
                u.setPassword(user.getPassword());
            }});
        return userList.stream().filter(u -> u.getUserid() == userid).findFirst().get();*/
        return userDAO.save(user);
    }
    public void deleteUser(int userid){
        userDAO.deleteById(userid);
        /*userList.stream().forEach(u -> {
            if(u.getUserid() == userid){
                userList.remove(u);
            }
        });*/
    }
}
