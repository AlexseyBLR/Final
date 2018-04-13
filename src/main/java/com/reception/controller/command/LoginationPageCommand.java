package com.reception.controller.command;

import com.reception.controller.constant.Constant;
import com.reception.controller.exception.ControllerException;
import com.reception.entity.NewUser;
import com.reception.entity.User;
import com.reception.service.CustomerService;
import com.reception.service.exception.ServiceException;
import com.reception.service.exception.ValidatorException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginationPageCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final CustomerService service = factory.getCustomerService();
    private final static Logger logger = Logger.getLogger(LoginationPageCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {

        String email = null;
        String password = null;

        try {
            email = request.getParameter("email");
            password = request.getParameter("password");

            NewUser user = service.findUserByEmailAndPassword(email, password);
            if (user != null| !email.equals("")) {
                request.getSession().setAttribute("userFIO", user.getLast_name() + " " + user.getFirst_name() + " " + user.getPatronymic());
                request.getSession().setAttribute("mathResult", user.getMathResult());
                request.getSession().setAttribute("physResult", user.getPhysResult());
                request.getSession().setAttribute("langResult", user.getLangResult());
                request.getSession().setAttribute("sertResult", user.getSertResult());
                request.getSession().setAttribute("role", user.getRole());
                if (user.getRole().equals("user")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/User/UserMain.jsp");
                    dispatcher.forward(request, response);
                }
                if (user.getRole().equals("admin")) {
                    response.sendRedirect("/adminMain");
                }
            } else {
                response.sendRedirect("/index.jsp");
            }
        } catch (ServiceException | IOException e) {
            logger.error("Exception from singIn command", e);
            throw new ControllerException(e);
        } catch (ValidatorException e) {

            try {
                response.sendRedirect(Constant.WebProperty.PAGE_LOGIN);
            } catch (IOException ex) {
                logger.debug("Exception ", e);
                throw new ControllerException("Exception in singinCommand while send redirect to main page", e);
            }
        }
    }
}