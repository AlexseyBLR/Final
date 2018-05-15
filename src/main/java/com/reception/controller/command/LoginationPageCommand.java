package com.reception.controller.command;

import com.reception.controller.constant.Constant;
import com.reception.controller.exception.ControllerException;
import com.reception.entity.User;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.exception.ValidatorException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.reception.controller.constant.Constant.WebProperty.*;


public class LoginationPageCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final UserService service = factory.getUserService();
    private final static Logger logger = Logger.getLogger(LoginationPageCommand.class);



    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {

        String email = null;
        String password = null;

        try {
            email = request.getParameter(REQUEST_PARAMETER_EMAIL);
            password = request.getParameter(REQUEST_PARAMETER_PASSWORD);

            User user = service.findUserByEmailAndPassword(email, password);
            if (user != null) {
                request.getSession().setAttribute(FIO_PARAMETER, user.getLast_name() + " " + user.getFirst_name() + " " + user.getPatronymic());
                request.getSession().setAttribute(MATH_RESULT_PARAMETER, user.getMathResult());
                request.getSession().setAttribute(PHYS_RESULT_PARAMETER, user.getPhysResult());
                request.getSession().setAttribute(LANG_RESULT_PARAMETER, user.getLangResult());
                request.getSession().setAttribute(SERT_RESULT_PARAMETER, user.getSertResult());
                request.getSession().setAttribute(USER_ATTRIBUTE_ROLE, user.getRole());
                if (user.getRole().equals(USER_ATTRIBUTE_NAME)) {
                    response.sendRedirect(PAGE_USER);
                }
                if (user.getRole().equals(ADMIN_ROLE)) {
                    response.sendRedirect(PAGE_ADMIN);
                }
            } else {
                response.sendRedirect(PAGE_REGISTRATION);
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