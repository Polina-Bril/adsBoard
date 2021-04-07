package com.epam.first.model.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionTimerTask extends TimerTask {
    private static final Logger logger = LogManager.getLogger(ConnectionTimerTask.class);
    private static final Lock lock = new ReentrantLock();
    public static final int AFTER_HOUR = 3600000;
    public static final int EVERY_HOUR = 3600000;

    @Override
    public void run() {
        try {
            lock.lock();
            ConnectionPool.timeTaskIsWork.set(true);
            ConnectionPool instance = ConnectionPool.getInstance();
            while (instance.getSize() < ConnectionPool.DEFAULT_POOL_SIZE) {
                Connection connection = ConnectionCreator.createConnection();
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                instance.freeConnection.offer(proxyConnection);
            }
        } catch (SQLException e) {
            logger.error(e);
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.timeTaskIsWork.set(false);
            lock.unlock();
        }
    }
}