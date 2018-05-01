package com.reception.controller.command;

import com.reception.controller.exception.ControllerException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        request.getSession().invalidate();
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            throw new ControllerException("exception from Logout command ",e);
        }
    }
}
