package com.epam.first.model.dao;

import com.epam.first.model.entity.User;
import com.epam.first.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    Optional<User> findByEmailAndPassword(String email, String password) throws DaoException;

    Optional<User> findByEmail(String email) throws DaoException;

    Optional<User> findByName(String name) throws DaoException;

    List<User> findAll() throws DaoException;

    Optional<User> findEntityById(Long id) throws DaoException;

    List<User> findEntitiesByIds(Long id1, Long id2) throws DaoException;

    boolean addUser(User user, String password) throws DaoException;

    boolean updateUserPassword(String password, Long userId) throws DaoException;

//    boolean blockUser(List<Long> usersId) throws DaoException;

//    boolean unblockUser(List<Long> usersId) throws DaoException;

    boolean save(User user) throws DaoException;

    boolean deleteById(Long id) throws DaoException;

    Optional<User> authorize(String login, String password) throws DaoException;

    boolean save(String email, String login, String encPassword) throws DaoException;

    Optional<User> findByNameOrEmail(String login, String email) throws DaoException;

    String checkByLogin(String login) throws DaoException;
}
