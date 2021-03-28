package com.epam.first.controller;

import com.epam.first.command.ActionCommand;
import com.epam.first.command.ActionFactory;
import com.epam.first.command.PagePath;
import com.epam.first.exception.ServiceException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "MainController", urlPatterns = "/main-controller")
public class MainController extends HttpServlet {
    public static Logger logger = LogManager.getLogger();
    private static final String ATTRIBUTE_NAME = "errorMessage";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.log(Level.INFO, "from doGet method in controller");
        try {
            processRequest(request, response);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.log(Level.INFO, "from doPost method in controller");
        try {
            processRequest(request, response);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        String page = null;
        Optional<ActionCommand> optionalCommand = ActionFactory.defineCommand(request);
        if (optionalCommand.isPresent()) {
            ActionCommand command = optionalCommand.get();
            page = command.execute(request);
            request.getRequestDispatcher(page).forward(request, response);
        } else {
            page = PagePath.ERROR;
            request.getSession().setAttribute(ATTRIBUTE_NAME,
//                    MessageManager.getProperty("message.error")
                    "no such command");
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}