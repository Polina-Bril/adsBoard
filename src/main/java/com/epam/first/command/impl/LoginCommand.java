package com.epam.first.command.impl;

import com.epam.first.command.ActionCommand;
import com.epam.first.entity.User;
import com.epam.first.exception.ServiceException;
import com.epam.first.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final Logger logger = LogManager.getLogger();
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private final UserService userService;
    private User user = new User();

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        try {
            userService.authorizeUser(login, password);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Error occurred while sign in user", e);
        }
        page = "/pages/main.jsp";
        return page;
    }
}
