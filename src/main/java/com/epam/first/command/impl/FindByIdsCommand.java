package com.epam.first.command.impl;

import com.epam.first.command.ActionCommand;
import com.epam.first.command.PagePath;
import com.epam.first.entity.User;
import com.epam.first.exception.ServiceException;
import com.epam.first.service.UserService;
import com.epam.first.validator.DataValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindByIdsCommand implements ActionCommand {
    private static final String LOWER_RANGE_VALUE = "lowerValue";
    private static final String HIGHER_RANGE_VALUE = "higherValue";
    private static final String ATTRIBUTE_NAME = "list";
    private static final String ATTRIBUTE_ERROR = "errorMessage";
    private final UserService userService;

    public FindByIdsCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String lowerStringValue = request.getParameter(LOWER_RANGE_VALUE);
        String higherStringValue = request.getParameter(HIGHER_RANGE_VALUE);
        boolean lowerValid = DataValidator.isValidLong(lowerStringValue);
        boolean higherValid = DataValidator.isValidLong(higherStringValue);
        if (!lowerValid || !higherValid){
            request.setAttribute(ATTRIBUTE_ERROR, "Invalid values entered! Please, try again");
            return PagePath.ERROR;
        }
        long lowerValue = Long.parseLong(lowerStringValue);
        long higherValue = Long.parseLong(higherStringValue);
        List<User> users = null;
        try {
            users = userService.findUsersInIdRange(lowerValue, higherValue);
            request.setAttribute(ATTRIBUTE_NAME, users);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        request.setAttribute(ATTRIBUTE_NAME, users);
        return PagePath.RANGE_LIST;
    }
}
