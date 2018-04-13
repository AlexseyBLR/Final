package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.ResultForRequest;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ApprovedRequestsCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(UsersRequestCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, DAOException {

        try {
            List<ResultForRequest> list = resultService.getAllUsers();
            for (int i = 0; i < resultService.getAllUsers().size(); i++) {
                resultService.updateUsers(list.get(i));
            }
            request.getSession().setAttribute("request", list);


            response.sendRedirect("/adminRequests");

        } catch (
                ServiceException e)

        {
            e.printStackTrace();
        }
    }
}
