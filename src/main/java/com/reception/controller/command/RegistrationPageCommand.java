//package com.reception.controller.command;
//
//import com.reception.entity.NewUser;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class RegistrationPageCommand implements Command {
//
//
//    public final static String FIRST_NAME_PARAMETER = "firstName";
//    public final static String LAST_NAME_PARAMETER = "lastName";
//    public final static String PATRONYMIC_PARAMETER = "patronymic";
//    public final static String LOGIN_PARAMETER = "login";
//    public final static String PASSWORD_PARAMETER = "password";
//    public final static String EMAIL_PARAMETER = "email";
//    public final static String PHONE_PARAMETER = "phone";
//    public final static String BIRTH_DATE_PARAMETER = "birthDate";
//    public final static String MATH_RESULT_PARAMETER = "mathResult";
//    public final static String PHYS_RESULT_PARAMETER = "physResult";
//    public final static String LANG_RESULT_PARAMETER = "langResult";
//    public final static String SERT_RESULT_PARAMETER = "sertResult";
//
//
//    @Override
//    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        try {
//            String firstName = request.getParameter(FIRST_NAME_PARAMETER);
//            String lastName = request.getParameter(LAST_NAME_PARAMETER);
//            String patronymic = request.getParameter(PATRONYMIC_PARAMETER);
//            String email = request.getParameter(EMAIL_PARAMETER);
//            String password = request.getParameter(PASSWORD_PARAMETER);
//            String birthDate = request.getParameter(BIRTH_DATE_PARAMETER);
//            String phoneNumber = request.getParameter(PHONE_PARAMETER);
//            String mathResult = request.getParameter(MATH_RESULT_PARAMETER);
//            String physResult = request.getParameter(PHYS_RESULT_PARAMETER);
//            String langResult = request.getParameter(LANG_RESULT_PARAMETER);
//            String sertResult = request.getParameter(SERT_RESULT_PARAMETER);
//
//            NewUser newUser = new NewUser(firstName, lastName, patronymic, email, password,
//                    birthDate, phoneNumber, mathResult, physResult, langResult, sertResult);
//        }catch (){
//
//        }
//
//    }
//}
