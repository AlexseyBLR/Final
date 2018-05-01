package com.reception.controller.command;

<<<<<<< HEAD
import com.reception.controller.command.user.GetResultCommand;
import org.apache.log4j.Logger;

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
