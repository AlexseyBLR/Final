package com.reception.controller.command;

import com.reception.entity.NewUser;
import com.reception.service.CustomerService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPageCommand implements Command {

    private final static Logger logger = Logger.getLogger(RegistrationPageCommand.class);
    private ServiceFactory factory = ServiceFactory.getInstance();
    private CustomerService service = factory.getCustomerService();


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

            NewUser newUser = new NewUser(firstName, lastName, patronymic, email, password,
                    phoneNumber, mathResult, physResult, langResult, sertResult, role);

            boolean result = service.saveCustomer(newUser);

            if(result==true){
                response.sendRedirect("/index.jsp");
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/RegistrationPage.jsp");
                dispatcher.forward(request, response);
            }

        }catch (ServiceException | IOException | RuntimeException e) {
            logger.error("Exception from SaveCustomer",e);
            response.sendRedirect("");
        }

    }
}
