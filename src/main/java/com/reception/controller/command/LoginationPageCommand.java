package com.reception.controller.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginationPageCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/LoginationPage.jsp");
            dispatcher.forward(request, response);
        }catch (IOException e){
            System.out.println(111);
        }
    }
}
