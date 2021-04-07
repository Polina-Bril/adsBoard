package com.epam.first.controller.command.impl;

import com.epam.first.controller.command.ActionCommand;
import com.epam.first.controller.command.PagePath;
import com.epam.first.model.entity.User;
import com.epam.first.exception.ServiceException;
import com.epam.first.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SortCommand implements ActionCommand {
    private final UserService userService;
    private static final String ATTRIBUTE_NAME = "list";

    public SortCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<User> users = null;
        try {
            users = userService.sortUsersById();
            request.setAttribute(ATTRIBUTE_NAME, users);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return PagePath.SORTED_LIST;
    }
}
