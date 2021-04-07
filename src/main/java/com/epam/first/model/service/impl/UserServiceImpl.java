package com.epam.first.model.service.impl;

import com.epam.first.comparator.UserIdComparator;
import com.epam.first.model.entity.User;
import com.epam.first.exception.DaoException;
import com.epam.first.exception.ServiceException;
import com.epam.first.model.dao.UserDao;
import com.epam.first.model.service.UserService;
import com.epam.first.util.PasswordEncryptor;
import com.epam.first.validator.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;
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
            if (UserValidator.isLoginCorrect(name)) {
                user = userDao.findByName(name);
            }
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
            if (UserValidator.isLoginCorrect(login) && UserValidator.isPasswordCorrect(password)){
                String userPassword = userDao.checkByLogin(login);
                String encPassword = PasswordEncryptor.encryptPassword(password);
                if (encPassword.equals(userPassword)) {
                    userDao.authorize(login, password);
                }
            }
        } catch (DaoException | NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean createUser(String email, String login, String password) throws ServiceException {
        try {
            boolean isUserCreated = false;
            if (UserValidator.isLoginCorrect(login) && UserValidator.isPasswordCorrect(password)
                    && UserValidator.isEmailCorrect(email)) {
                Optional<User> existingLoginOrEmail = userDao.findByNameOrEmail(login, email);
                if (existingLoginOrEmail.isPresent()) {
                    return isUserCreated;
                }
                String encPassword = PasswordEncryptor.encryptPassword(password);
                isUserCreated = userDao.save(email, login, encPassword);
            }
            return isUserCreated;
        } catch (DaoException | NoSuchAlgorithmException e) {
            throw new ServiceException(e);
        }
    }
}
