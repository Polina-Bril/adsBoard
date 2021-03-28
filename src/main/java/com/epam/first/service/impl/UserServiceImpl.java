package com.epam.first.service.impl;

import com.epam.first.comparator.UserIdComparator;
import com.epam.first.entity.User;
import com.epam.first.exception.DaoException;
import com.epam.first.exception.ServiceException;
import com.epam.first.repository.UserDao;
import com.epam.first.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {
    static final Logger logger = LogManager.getLogger();
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> sortUsersById() throws ServiceException {
        UserIdComparator comparator = new UserIdComparator();
        List<User> users = null;
        try {
            users = userDao.findAll();
            users.sort(comparator);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            throw new ServiceException(e);
        }
        return users;
    }

    @Override
    public List<User> findUsersInIdRange(long lowerValue, long higherValue) throws ServiceException {
        List<User> users = null;
        try {
            users = userDao.findEntitiesByIds(lowerValue, higherValue);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            throw new ServiceException(e);
        }
        return users;
    }

    @Override
    public List<User> findAll() throws ServiceException {
        List<User> users = null;
        try {
            users = userDao.findAll();
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            throw new ServiceException(e);
        }
        return users;
    }

    @Override
    public Optional<User> findUserByName(String name) throws ServiceException {
        Optional<User> user = null;
        try {
            user = userDao.findByName(name);
        } catch (DaoException e) {
            logger.log(Level.ERROR, e);
            throw new ServiceException(e);
        }
        return user;
    }

    @Override
    public void authorizeUser(String login, String password) throws ServiceException {
        Optional<User> user = null;
        try {
            user = userDao.authorize(login,password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
