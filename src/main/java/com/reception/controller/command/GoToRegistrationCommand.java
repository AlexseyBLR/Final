package com.reception.controller.command;

import com.reception.controller.command.user.GetResultCommand;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRegistrationCommand implements Command {

    private final static Logger logger = Logger.getLogger(GetResultCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/RegistrationPage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (IOException e) {
            logger.error("Exception on \"GoToRegistrationCommand\"", e);
        }
    }
}
