package com.library.personallibrary.api;

import com.library.personallibrary.model.User;
import com.library.personallibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService userService;
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{userid}")
    public User getUser(@PathVariable("userid") int userid){
        return userService.getUser(userid);
    }
    @PutMapping(value = "/userid")
    public User updateUser(@PathVariable("userid") int userid,@RequestBody User user){
        return userService.updateUserId(userid,user);
    }
    @DeleteMapping(value = "/{userid}")
    public void deleteUser(@PathVariable("userid") int userid){
        userService.deleteUser(userid);
    }
}
