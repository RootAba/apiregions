package com.example.SecuCom.security.services;

import com.example.SecuCom.models.User;
import com.example.SecuCom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usercrudImpl implements usercrud {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> GetAll() {
        return  userRepository.findAll();
    }
}
