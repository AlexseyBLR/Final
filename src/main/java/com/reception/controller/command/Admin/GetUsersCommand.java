package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.entity.User;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.reception.controller.constant.Constant.WebProperty.PAGE_ADMIN_SHOW_USERS;
import static com.reception.controller.constant.Constant.WebProperty.SESSION_ATTRIBUTE_USERlIST;

public class GetUsersCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final UserService userService = factory.getUserService();
    private final static Logger logger = Logger.getLogger(GetUsersCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {


        try {
            List<User> list = userService.getAllUsers();
            request.getSession().setAttribute(SESSION_ATTRIBUTE_USERlIST, list);

            response.sendRedirect(PAGE_ADMIN_SHOW_USERS);
        } catch (ServiceException e) {
            logger.error("exception in \"Get User Command\"", e);
        }


    }
}
