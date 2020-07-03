package com.project.start.services;

import com.project.start.entities.Users.MyUser;
import com.project.start.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserService {

    @Autowired
    private MyUserRepository myUserRepository;

    public List<MyUser> getAllMyUsers() {
        return myUserRepository.findAll();

    }

}
