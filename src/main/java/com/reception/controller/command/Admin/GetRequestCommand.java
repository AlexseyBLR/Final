package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

<<<<<<< HEAD:src/main/java/com/reception/controller/command/Admin/GetRequestCommand.java
<<<<<<< HEAD:src/main/java/com/reception/controller/command/adminCommand/GetRequestCommand.java
<<<<<<< HEAD:src/main/java/com/reception/controller/command/adminCommand/GetRequestCommand.java
import static com.reception.controller.constant.Constant.WebProperty.*;

=======
>>>>>>> parent of f48f517... version from 01/05/2018:src/main/java/com/reception/controller/command/Admin/GetRequestCommand.java
=======
>>>>>>> parent of f48f517... version from 01/05/2018:src/main/java/com/reception/controller/command/Admin/GetRequestCommand.java
public class GetRequestCommand implements Command {
=======
public class UsersRequestCommand implements Command {
>>>>>>> parent of 0ef4810... version 20/04/18:src/main/java/com/reception/controller/command/Admin/GetRequestCommand.java

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(UsersRequestCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, DAOException {


        try {
            List<UserRequest> list = resultService.getAllUsers();
            request.getSession().setAttribute("requests", list);

            response.sendRedirect("/adminRequests");
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}

