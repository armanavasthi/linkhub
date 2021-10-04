package com.linkhub.linkstorageservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @RequestMapping("/")
    public String isWorking() {
       return "Welcome to armanavasthi.me.... Hare Krishna!!!";
    }

    @RequestMapping("/linkedin")
    public String getLinkedInUrl() {
        return "https://www.linkedin.com/in/armanavasthi/";
    }
}
