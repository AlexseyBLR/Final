package com.reception.controller.command.adminCommand;

import com.reception.controller.command.Command;
<<<<<<< HEAD:src/main/java/com/reception/controller/command/adminCommand/ApprovedRequestsCommand.java
import com.reception.entity.UserRequest;
=======
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.ResultForRequest;
>>>>>>> parent of 0ef4810... version 20/04/18:src/main/java/com/reception/controller/command/Admin/ApprovedRequestsCommand.java
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.reception.controller.constant.Constant.WebProperty.PAGE_ADMIN_REQUEST;

public class ApprovedRequestsCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(UsersRequestCommand.class);

    @Override
<<<<<<< HEAD:src/main/java/com/reception/controller/command/adminCommand/ApprovedRequestsCommand.java
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
=======
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, DAOException {
>>>>>>> parent of 0ef4810... version 20/04/18:src/main/java/com/reception/controller/command/Admin/ApprovedRequestsCommand.java

        try {
            List<ResultForRequest> list = resultService.getAllUsers();
            for (int i = 0; i < resultService.getAllUsers().size(); i++) {
                resultService.updateUsers(list.get(i));
            }
            request.getSession().setAttribute("request", list);
<<<<<<< HEAD:src/main/java/com/reception/controller/command/adminCommand/ApprovedRequestsCommand.java
            response.sendRedirect(PAGE_ADMIN_REQUEST);
=======


            response.sendRedirect("/adminRequests");

>>>>>>> parent of 0ef4810... version 20/04/18:src/main/java/com/reception/controller/command/Admin/ApprovedRequestsCommand.java
        } catch (
                ServiceException e)

        {
            e.printStackTrace();
        }
    }
}
