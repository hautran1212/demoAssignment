package com.example.demoassignment.validator;

import com.example.demoassignment.Domain.UserModel;
import com.example.demoassignment.exception.FieldMissMatchException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserRegisterValidator {
    public void validateRegisterUser(UserModel userModel)
            throws FieldMissMatchException {

        if (!Objects.equals(userModel.getPassword(),userModel.getRePassword())) {
            throw new FieldMissMatchException("Password miss match");
        }
    }
}
