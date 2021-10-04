package com.example.ui.controller;

import java.net.ConnectException;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

@Controller
public class RootController {

    @GetMapping("/")
    public String getUI() {
        System.out.println("hello.........");
        return "index.html";
    }

    @PostMapping(value = "/")
    public ResponseEntity postContactInfo() {
        System.out.println("hello post.........");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/linkedin")
    public ResponseEntity<String> getLinkedInLink() {
        RestTemplate template = new RestTemplate();
        Optional<String> linkedInUrl;
        try {
            linkedInUrl =
                Optional.ofNullable(template.getForObject("http://host.docker.internal:6060/linkedin", String.class)); // localhost wont work when both apps are running on docker
            // find a way that works on both (may be different app props for both)
        }
        // Later follow this for globally handling rest template errors https://www.baeldung.com/spring-rest-template-error-handling
        catch (HttpClientErrorException | HttpServerErrorException
                        | UnknownHttpStatusCodeException | ResourceAccessException ce) {
            System.out.println("error.....");
            ce.printStackTrace(); // use logger instead
            linkedInUrl = Optional.empty();
        }

        return new ResponseEntity<>(linkedInUrl.orElse("Sorry for inconvenience! Backend did not send the url!!!"),
            HttpStatus.OK);

    }
}
