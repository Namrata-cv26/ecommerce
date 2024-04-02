package com.example.projectback.service;

import com.example.projectback.model.User;
import com.example.projectback.service.UserException;
public interface UserService {
    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;

}
