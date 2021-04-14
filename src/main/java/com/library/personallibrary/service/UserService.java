package com.library.personallibrary.service;

import com.library.personallibrary.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class UserService {
    private int useridcount = 1;
    private List<User> userList = new CopyOnWriteArrayList<>();
    public User addUser(User user){
        user.setUserid(useridcount);
        userList.add(user);
        userList.add(user);
        useridcount++;
        return user;
    }
    public List<User> getUsers(){
        return userList;
    }
    public User getUser(int userid){
        return userList.stream().filter(u -> u.getUserid() == userid).findFirst().get();
    }
    public User updateUserId(int userid, User user){
        userList.stream().forEach(u -> {
            if(u.getUserid() == userid)
            {
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setEmail(user.getEmail());
            }});
        return userList.stream().filter(u -> u.getUserid() == userid).findFirst().get();
    }
    public void deleteUser(int userid){
        userList.stream().forEach(u -> {
            if(u.getUserid() == userid){
                userList.remove(u);
            }
        });
    }
}
