package com.example.demoassignment.Service.Impl;

import com.example.demoassignment.Domain.UserModel;
import com.example.demoassignment.Entity.UserEntity;
import com.example.demoassignment.Responsitory.UserResponsitory;
import com.example.demoassignment.Service.UserService;
import com.example.demoassignment.converter.UserConverter;
import com.example.demoassignment.exception.FieldMissMatchException;
import com.example.demoassignment.validator.UserRegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserResponsitory userResponsitory;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRegisterValidator userRegisterValidator;
    @Override
    public UserEntity save(UserModel userModel) throws FieldMissMatchException {
        userRegisterValidator.validateRegisterUser(userModel);
        UserEntity userEntity = UserConverter.toEntity(userModel);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userResponsitory.save(userEntity);
    }
}
