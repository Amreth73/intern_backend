package com.example.intern_1.Service;


import com.example.intern_1.Model.EpollUsers;
import com.example.intern_1.Repository.EpollUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private EpollUserRepository userRepository;

    public List<EpollUsers> getAllUsers() {
        return userRepository.findAll();
    }

    public EpollUsers getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}

