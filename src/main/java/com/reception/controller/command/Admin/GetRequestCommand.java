package com.reception.controller.command.Admin;

import com.reception.controller.command.user.Command;
import com.reception.dao.exception.DAOException;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetRequestCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(GetRequestCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException {


        try {
            List<UserRequest> list = resultService.getAllUsers();
            request.getSession().setAttribute("requests", list);

            response.sendRedirect("/adminRequests");
        } catch (ServiceException e) {
            logger.error("Exception on \"GetRequestComand\"", e);
        }


    }
}

