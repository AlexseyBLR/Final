package com.reception.controller.command;

import com.reception.entity.User;
import com.reception.service.UserService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

<<<<<<< HEAD
<<<<<<< HEAD
import static com.reception.controller.constant.Constant.WebProperty.PAGE_REGISTRATION;

public class RegistrationCommand extends Thread implements Command {

=======
public class RegistrationPageCommand implements Command {
>>>>>>> parent of 0ef4810... version 20/04/18
=======
public class RegistrationCommand implements Command {
>>>>>>> parent of f48f517... version from 01/05/2018

    private final static Logger logger = Logger.getLogger(RegistrationPageCommand.class);
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
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String firstName = request.getParameter(FIRST_NAME_PARAMETER);
            String lastName = request.getParameter(LAST_NAME_PARAMETER);
            String patronymic = request.getParameter(PATRONYMIC_PARAMETER);
            String email = request.getParameter(EMAIL_PARAMETER);
            String password = request.getParameter(PASSWORD_PARAMETER);
            String phoneNumber = request.getParameter(PHONE_PARAMETER);
            int mathResult = Integer.parseInt(request.getParameter(MATH_RESULT_PARAMETER));
            int physResult = Integer.parseInt(request.getParameter(PHYS_RESULT_PARAMETER));
            int langResult = Integer.parseInt(request.getParameter(LANG_RESULT_PARAMETER));
            int sertResult = Integer.parseInt(request.getParameter(SERT_RESULT_PARAMETER));
            String role = "user";

            User user = new User(firstName, lastName, patronymic, email, password,
                    phoneNumber, mathResult, physResult, langResult, sertResult, role);

            boolean result = service.saveCustomer(user);

            if(result==true){
                response.sendRedirect("/index.jsp");
            }else {
<<<<<<< HEAD
<<<<<<< HEAD
                response.sendRedirect(PAGE_REGISTRATION);
=======
                RequestDispatcher dispatcher = request.getRequestDispatcher("/registration");
                dispatcher.forward(request, response);
>>>>>>> parent of 0ef4810... version 20/04/18
=======
                response.sendRedirect("/registration");
>>>>>>> parent of f48f517... version from 01/05/2018
            }

        }catch (ServiceException | IOException | RuntimeException e) {
            logger.error("Exception from SaveCustomer",e);
            response.sendRedirect("");
        }

    }
}
