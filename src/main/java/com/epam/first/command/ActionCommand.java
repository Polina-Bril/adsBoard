package com.epam.first.command;

import com.epam.first.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface ActionCommand {
    String execute(HttpServletRequest request);
}
