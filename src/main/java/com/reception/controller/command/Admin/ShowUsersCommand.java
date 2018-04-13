package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.controller.constant.Constant;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.NewUser;
import com.reception.entity.ResultForRequest;
import com.reception.service.CustomerService;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowUsersCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final CustomerService userService = factory.getCustomerService();
    private final static Logger logger = Logger.getLogger(ShowUsersCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException {


        try {
            List<NewUser> list = userService.getAllUsers();
            request.getSession().setAttribute("userList", list);

            response.sendRedirect("/showUsers");
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
