package com.epam.first.model.service;

import com.epam.first.model.entity.User;
import com.epam.first.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> sortUsersById() throws ServiceException;

    List<User> findUsersInIdRange(long lowerValue, long higherValue) throws ServiceException;

    List<User> findAll() throws ServiceException;

    Optional<User> findUserByName(String name) throws ServiceException;

    void authorizeUser(String login, String password) throws ServiceException;

    boolean createUser(String email, String login, String password) throws ServiceException;
}