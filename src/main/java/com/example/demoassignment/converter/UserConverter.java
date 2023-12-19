package com.example.demoassignment.converter;

import com.example.demoassignment.Domain.UserModel;
import com.example.demoassignment.Entity.UserEntity;

public class UserConverter {
    public static UserEntity toEntity(UserModel userModel){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userModel.getFirstName());
        userEntity.setLastName(userModel.getLastName());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setBirthday(userModel.getBirthday());
        userEntity.setAddress(userModel.getAddress());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setStatus("active");
        userEntity.setRole("ROLE_USER");
        return userEntity;
    }
}
