package com.epam.first.command;

import com.epam.first.command.impl.*;
import com.epam.first.dao.impl.UserDaoImpl;
import com.epam.first.service.impl.UserServiceImpl;

public enum CommandType {
    FIND_ALL_USERS {
        {
            this.command = new FindAllCommand(new UserServiceImpl(new UserDaoImpl()));
        }
    },
    SORT_USERS {
        {
            this.command = new SortCommand(new UserServiceImpl(new UserDaoImpl()));
        }
    },
    FIND_USERS_BY_IDS {
        {
            this.command = new FindByIdsCommand(new UserServiceImpl(new UserDaoImpl()));
        }
    },
    LOGIN {
        {
            this.command = new LoginCommand(new UserServiceImpl((new UserDaoImpl())));
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand(new UserServiceImpl((new UserDaoImpl())));
        }
    },
    REGISTRY {
        {
            this.command = new RegisterUserCommand(new UserServiceImpl((new UserDaoImpl())));
        }
    };
    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}