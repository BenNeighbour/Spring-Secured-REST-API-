package com.benneighbour.OAuth20.Practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PublicController {

    /*  New mapping which is a test for a public url that does not require authentication
        to be able to access it. All of the other mappings are meant to be private,
        and require authentication. The mapping just returns a simple string.
     */
    @GetMapping("/public/")
    public String pub() {
        return "this is a public page";
    }

}
