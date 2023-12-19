package com.example.demoassignment.Service;

import com.example.demoassignment.Domain.UserModel;
import com.example.demoassignment.Entity.UserEntity;
import com.example.demoassignment.exception.FieldMissMatchException;

public interface UserService {
    UserEntity save(UserModel userModel) throws FieldMissMatchException;

}
