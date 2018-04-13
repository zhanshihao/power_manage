package com.shihao.power.service;

import com.shihao.power.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerService {

    @Autowired
    private UserRepository userRepository;
}
