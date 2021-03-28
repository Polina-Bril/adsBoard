package com.epam.first.repository.impl;

import com.epam.first.connection.ConnectionCreator;
import com.epam.first.entity.User;
import com.epam.first.exception.DaoException;
import com.epam.first.repository.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    static final Logger logger = LogManager.getLogger();
    private static final String FIND_USER_BY_EMAIL = "SELECT userId, username, password, email, phone, averageRating FROM users WHERE email = ?";
    private static final String FIND_USER_BY_USERNAME = "SELECT userId, username, password, email, phone, averageRating FROM users WHERE username = ?";
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT userId, username, password, email, phone, averageRating FROM users WHERE email = ? AND password = ?";
    private static final String FIND_USER_BY_ID = "SELECT userId, username, password, email, phone, averageRating FROM users WHERE userId = ?";
    private static final String ADD_USER = "INSERT INTO `users` (`userId`, `username`, `password`, `email`, `phone`, `averageRating`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_USER_PASSWORD = "UPDATE users SET password = ? WHERE userId = ?";
    private static final String FIND_ALL_USERS = "SELECT userId, username, password, email, phone, averageRating FROM users WHERE userId>? and userId<?";
    private static final String FIND_USERS_BY_IDS = "SELECT userId, username, password, email, phone, averageRating FROM users WHERE user_id = ?";
    private static final String AUTHORIZE = "SELECT userId, username, password, email, phone, averageRating FROM users WHERE username = ? AND password = ?";
//    private static final String BLOCK_USER = "UPDATE users SET enabled = false WHERE user_id = ?";
//    private static final String UNBLOCK_USER = "UPDATE users SET enabled = true WHERE user_id = ?";

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(2));
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAverageRating(resultSet.getDouble(6));
//                user.setRole(Role.valueOf(resultSet.getString(5).toUpperCase()));
//                user.setEnabled(resultSet.getBoolean(6));
                userOptional = Optional.ofNullable(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return userOptional;
    }

    @Override
    public Optional<User> findByEmail(String email) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(2));
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAverageRating(resultSet.getDouble(6));
//                user.setRole(Role.valueOf(resultSet.getString(5).toUpperCase()));
//                user.setEnabled(resultSet.getBoolean(6));
                userOptional = Optional.ofNullable(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return userOptional;
    }

    @Override
    public Optional<User> findByName(String name) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(2));
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAverageRating(resultSet.getDouble(6));
//                user.setRole(Role.valueOf(resultSet.getString(5).toUpperCase()));
//                user.setEnabled(resultSet.getBoolean(6));
                userOptional = Optional.ofNullable(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return userOptional;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(2));
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAverageRating(resultSet.getDouble(6));
//                user.setRole(Role.valueOf(resultSet.getString(5).toUpperCase()));
//                user.setEnabled(resultSet.getBoolean(6));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public Optional<User> findEntityById(Long id) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(2));
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAverageRating(resultSet.getDouble(6));
//                user.setRole(Role.valueOf(resultSet.getString(5).toUpperCase()));
                userOptional = Optional.ofNullable(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return userOptional;
    }

    @Override
    public List<User> findEntitiesByIds(Long id1, Long id2) throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS_BY_IDS)) {
            preparedStatement.setLong(1, id1);
            preparedStatement.setLong(2, id2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(2));
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAverageRating(resultSet.getDouble(6));
//                user.setRole(Role.valueOf(resultSet.getString(5).toUpperCase()));
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public boolean addUser(User user, String password) throws DaoException {
        boolean isAdd;
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(3, password);
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setLong(2, user.getUserId());
            preparedStatement.setDouble(6, user.getAverageRating());
//            preparedStatement.setString(5, user.getRole().toString());
//            preparedStatement.setBoolean(6, user.isEnabled());
            isAdd = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return isAdd;
    }

    @Override
    public boolean updateUserPassword(String password, Long userId) throws DaoException {
        boolean isUpdate;
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PASSWORD)) {
            preparedStatement.setString(1, password);
            preparedStatement.setLong(2, userId);
            isUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException(e);
        }
        return isUpdate;
    }

//    @Override
//    public boolean blockUser(List<Long> usersId) throws DaoException {
//        boolean isUpdate;
//        try (Connection connection = ConnectionCreator.createConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(BLOCK_USER)){
//            connection.setAutoCommit(false);
//            for (Long userId : usersId) {
//                preparedStatement.setLong(1, userId);
//                preparedStatement.executeUpdate();
//            }
//            connection.commit();
//            isUpdate = true;
//        } catch (SQLException e) {
//            rollback(connection);
//            logger.error(e);
//            throw new DaoException(e);
//        }
//        return isUpdate;
//    }
//
//    @Override
//    public boolean unblockUser(List<Long> usersId) throws DaoException {
//        boolean isUpdate;
//        try (Connection connection = ConnectionCreator.createConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(UNBLOCK_USER)){
//            connection.setAutoCommit(false);
//            for (Long userId : usersId) {
//                preparedStatement.setLong(1, userId);
//                preparedStatement.executeUpdate();
//            }
//            connection.commit();
//            isUpdate = true;
//        } catch (SQLException e) {
//            rollback(connection);
//            connection.setAutoCommit(true);
//            logger.error(e);
//            throw new DaoException(e);
//        }
//        return isUpdate;
//    }

    @Override
    public boolean add(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteById(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<User> authorize(String login, String password) throws DaoException {
        Optional<User> userOptional = Optional.empty();
        try (Connection connection = ConnectionCreator.createConnection();
             PreparedStatement statement = connection.prepareStatement(AUTHORIZE)) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong(2));
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));
                user.setAverageRating(resultSet.getDouble(6));
//                user.setRole(Role.valueOf(resultSet.getString(5).toUpperCase()));
//                user.setEnabled(resultSet.getBoolean(6));
                userOptional = Optional.ofNullable(user);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new DaoException("Error while authorize user", e);
        }
        return userOptional;
    }
}