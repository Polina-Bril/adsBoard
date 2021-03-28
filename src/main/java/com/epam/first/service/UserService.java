package com.epam.first.service;

import com.epam.first.entity.User;
import com.epam.first.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> sortUsersById() throws ServiceException;

    List<User> findUsersInIdRange(long lowerValue, long higherValue) throws ServiceException;

    List<User> findAll() throws ServiceException;

    Optional<User> findUserByName(String name) throws ServiceException;

    void authorizeUser(String login, String password) throws ServiceException;
}