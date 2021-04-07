package com.epam.first.controller.command.impl;

import com.epam.first.controller.command.ActionCommand;
import com.epam.first.controller.command.PagePath;
import com.epam.first.model.entity.User;
import com.epam.first.exception.ServiceException;
import com.epam.first.model.service.UserService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindAllCommand implements ActionCommand {
    Logger logger = LogManager.getLogger();
    private final UserService userService;

    public FindAllCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users = null;
        try {
            users = userService.findAll();
            request.setAttribute("list", users);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
        return PagePath.LIST;
    }
}
