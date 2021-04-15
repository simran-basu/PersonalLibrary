package com.library.personallibrary.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Home {
    @GetMapping
    public String atHome() {
        return "Application is working!! "+new Date();
    }
}
