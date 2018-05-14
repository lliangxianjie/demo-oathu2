package com.maxnerva.controller;

import com.maxnerva.user.User1;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping("/user/me")

    public Principal user(Principal principal) {
        return principal;
    }

    @PostMapping(value = "/log")
    public String  saveCuringEvidence(@RequestBody User1 user){
        System.out.println("---------------------user:"+user.getUsername());
        return user.getUsername();
    }


}
