package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.controller.exception.ControllerException;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.reception.controller.constant.Constant.WebProperty.HIDDEN_PARAMETER_FOR_DELETE;
import static com.reception.controller.constant.Constant.WebProperty.PAGE_ADMIN_SHOW_USERS;

public class DeleteUserCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final UserService service = factory.getUserService();
    private final static Logger logger = Logger.getLogger(DeleteUserCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, ServiceException {
        String email = (String) request.getParameter(HIDDEN_PARAMETER_FOR_DELETE);
        service.deleteCustomer(email);
        response.sendRedirect(PAGE_ADMIN_SHOW_USERS);
    }
}
