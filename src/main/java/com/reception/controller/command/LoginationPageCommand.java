package com.reception.controller.command;

import com.reception.controller.exception.ControllerException;
import com.reception.entity.User;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.exception.ValidatorException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.reception.controller.constant.Constant.WebProperty.PAGE_ADMIN;
import static com.reception.controller.constant.Constant.WebProperty.PAGE_USER;

public class LoginationPageCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final UserService service = factory.getUserService();
    private final static Logger logger = Logger.getLogger(LoginationPageCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {

        String email = null;
        String password = null;

        try {
            email = request.getParameter("email");
            password = request.getParameter("password");

            User user = service.findUserByEmailAndPassword(email, password);
            if (user != null) {
                request.getSession().setAttribute("userFIO", user.getLast_name() + " " + user.getFirst_name() + " " + user.getPatronymic());
                request.getSession().setAttribute("mathResult", user.getMathResult());
                request.getSession().setAttribute("physResult", user.getPhysResult());
                request.getSession().setAttribute("langResult", user.getLangResult());
                request.getSession().setAttribute("sertResult", user.getSertResult());
                request.getSession().setAttribute("role", user.getRole());
                if (user.getRole().equals("user")) {
                    response.sendRedirect(PAGE_USER);
                }
                if (user.getRole().equals("admin")) {
                    response.sendRedirect(PAGE_ADMIN);
                }
            } else {
                response.sendRedirect("/index.jsp");
            }
        } catch (ServiceException | IOException e) {
            logger.error("Exception from singIn command", e);
            throw new ControllerException(e);
        } catch (ValidatorException e) {
            throw new ControllerException("Exception in singin Command with validator", e);
        }
    }
}
