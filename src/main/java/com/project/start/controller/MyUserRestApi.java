package com.project.start.controller;

import com.project.start.entities.Users.MyUser;
import com.project.start.services.MyUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class MyUserRestApi {

    private final MyUserService myUserService;

    public MyUserRestApi(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @GetMapping("/admin/users")
    public List<MyUser> getMyUser() {
        return this.myUserService.getAllMyUsers();
    }

    @GetMapping("/")
    public String getAnswer() {
        return "user!!!";
    }

}
