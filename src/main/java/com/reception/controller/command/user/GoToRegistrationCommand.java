package com.reception.controller.command.user;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of f48f517... version from 01/05/2018
=======
>>>>>>> parent of f48f517... version from 01/05/2018
=======
>>>>>>> parent of f48f517... version from 01/05/2018
=======
>>>>>>> parent of f48f517... version from 01/05/2018

=======
>>>>>>> parent of 0ef4810... version 20/04/18
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/RegistrationPage.jsp");
        dispatcher.forward(request, response);
    }
}
