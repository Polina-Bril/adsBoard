package com.epam.first.command.impl;

import com.epam.first.command.ActionCommand;
import com.epam.first.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegisterUserCommand implements ActionCommand {
    private final UserService userService;

    public RegisterUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}