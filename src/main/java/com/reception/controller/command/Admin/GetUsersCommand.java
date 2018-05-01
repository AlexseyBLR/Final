package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.dao.exception.DAOException;
import com.reception.entity.User;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

<<<<<<< HEAD:src/main/java/com/reception/controller/command/Admin/GetUsersCommand.java
<<<<<<< HEAD:src/main/java/com/reception/controller/command/adminCommand/GetUsersCommand.java
<<<<<<< HEAD:src/main/java/com/reception/controller/command/adminCommand/GetUsersCommand.java
import static com.reception.controller.constant.Constant.WebProperty.*;

=======
>>>>>>> parent of f48f517... version from 01/05/2018:src/main/java/com/reception/controller/command/Admin/GetUsersCommand.java
=======
>>>>>>> parent of f48f517... version from 01/05/2018:src/main/java/com/reception/controller/command/Admin/GetUsersCommand.java
public class GetUsersCommand implements Command {
=======
public class ShowUsersCommand implements Command {
>>>>>>> parent of 0ef4810... version 20/04/18:src/main/java/com/reception/controller/command/Admin/GetUsersCommand.java

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final UserService userService = factory.getUserService();
    private final static Logger logger = Logger.getLogger(ShowUsersCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException {


        try {
            List<User> list = userService.getAllUsers();
            request.getSession().setAttribute("userList", list);

            response.sendRedirect("/showUsers");
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
