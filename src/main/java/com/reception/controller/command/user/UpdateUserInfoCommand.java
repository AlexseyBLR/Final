package com.reception.controller.command.user;

import com.reception.controller.command.Command;
import com.reception.controller.command.RegistrationCommand;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.User;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.reception.controller.constant.Constant.WebProperty.PAGE_ERROR;
import static com.reception.controller.constant.Constant.WebProperty.PAGE_USER_MAIN;
import static com.reception.controller.constant.Constant.WebProperty.PAGE_USER_UPDATE;

public class UpdateUserInfoCommand implements Command {

    private final static Logger logger = Logger.getLogger(RegistrationCommand.class);
    private ServiceFactory factory = ServiceFactory.getInstance();
    private UserService service = factory.getUserService();


    public final static String FIRST_NAME_PARAMETER = "firstName";
    public final static String LAST_NAME_PARAMETER = "lastName";
    public final static String PATRONYMIC_PARAMETER = "patronymic";
    public final static String PASSWORD_PARAMETER = "password";
    public final static String EMAIL_PARAMETER = "email";
    public final static String PHONE_PARAMETER = "phone";
    public final static String MATH_RESULT_PARAMETER = "math";
    public final static String PHYS_RESULT_PARAMETER = "phys";
    public final static String LANG_RESULT_PARAMETER = "lang";
    public final static String SERT_RESULT_PARAMETER = "sert";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, DAOException {
        try {
            String firstName = request.getParameter(FIRST_NAME_PARAMETER);
            String lastName = request.getParameter(LAST_NAME_PARAMETER);
            String patronymic = request.getParameter(PATRONYMIC_PARAMETER);
            String email = (String) request.getSession().getAttribute(EMAIL_PARAMETER);
            String phoneNumber = (String) request.getSession().getAttribute(PHONE_PARAMETER);
            String password = (String) request.getSession().getAttribute(PASSWORD_PARAMETER);
            int mathResult = Integer.parseInt(request.getParameter(MATH_RESULT_PARAMETER));
            int physResult = Integer.parseInt(request.getParameter(PHYS_RESULT_PARAMETER));
            int langResult = Integer.parseInt(request.getParameter(LANG_RESULT_PARAMETER));
            int sertResult = Integer.parseInt(request.getParameter(SERT_RESULT_PARAMETER));
            String role = "user";

            User user = new User(firstName, lastName, patronymic, email, password,
                    phoneNumber, mathResult, physResult, langResult, sertResult, role);


            boolean result = service.update(user);

            if(result==true){
                response.sendRedirect(PAGE_USER_MAIN);
            }else {
                response.sendRedirect(PAGE_USER_UPDATE);
            }

        }catch (ServiceException | IOException | RuntimeException e) {
            logger.error("Exception from SaveCustomer",e);
            response.sendRedirect(PAGE_ERROR);
        }
    }
}
