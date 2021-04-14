package com.library.personallibrary.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @RequestMapping(value = "/home")
    public String atHome() {
        return "at Home!";
    }
}
