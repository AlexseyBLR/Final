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
    public final static String MATH_RESULT_PARAMETER = "mathResult";
    public final static String PHYS_RESULT_PARAMETER = "physResult";
    public final static String LANG_RESULT_PARAMETER = "langResult";
    public final static String SERT_RESULT_PARAMETER = "sertResult";


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String firstName = request.getParameter(FIRST_NAME_PARAMETER);
            String lastName = request.getParameter(LAST_NAME_PARAMETER);
            String patronymic = request.getParameter(PATRONYMIC_PARAMETER);
            String email = request.getParameter(EMAIL_PARAMETER);
            String password = request.getParameter(PASSWORD_PARAMETER);
            String phoneNumber = request.getParameter(PHONE_PARAMETER);
            String mathResult = request.getParameter(MATH_RESULT_PARAMETER);
            String physResult = request.getParameter(PHYS_RESULT_PARAMETER);
            String langResult = request.getParameter(LANG_RESULT_PARAMETER);
            String sertResult = request.getParameter(SERT_RESULT_PARAMETER);

            NewUser newUser = new NewUser(firstName, lastName, patronymic, email, password,
                    phoneNumber, mathResult, physResult, langResult, sertResult);

            boolean result = service.saveCustomer(newUser);

            if(result==true){
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
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
