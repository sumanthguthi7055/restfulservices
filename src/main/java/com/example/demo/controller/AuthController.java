package com.example.demo.controller;

import com.example.demo.repo.Auth;
import com.example.demo.repo.AuthImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AuthController
{

    @Autowired
    Auth a;
    @PostMapping ("/login")
    public String getAuth(@RequestBody AuthImpl aa)
    {
        System.out.println("inside login"+aa.toString());
        String uname = String.valueOf(a.findById(aa.mail));


        return null;
    }
}
