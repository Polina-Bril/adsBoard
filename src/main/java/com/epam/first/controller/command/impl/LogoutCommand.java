package com.epam.first.controller.command.impl;

import com.epam.first.controller.command.ActionCommand;
import com.epam.first.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    private final UserService userService;


    public LogoutCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
