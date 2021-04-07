package com.epam.first.controller.command;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ActionFactory {
    static final Logger logger = LogManager.getLogger();
    private static final String PARAMETR = "command";
    private static final String ATTRIBUTE_NAME = "wrongAction";


    public static Optional<ActionCommand> defineCommand(HttpServletRequest request) {
        ActionCommand current = null;
        String action = request.getParameter(PARAMETR);
        if (action.isBlank()) {
            return Optional.empty();
        }
        try {
            CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
            current = currentEnum.getCommand();
            logger.log(Level.INFO, "Command class: " + current.getClass());
        } catch (IllegalArgumentException e) {
            request.setAttribute(ATTRIBUTE_NAME, action
                    + "No such action possible"
//                        + MessageManager.getProperty("message.wrongaction")
            );
        }
        return Optional.of(current);
    }
}
