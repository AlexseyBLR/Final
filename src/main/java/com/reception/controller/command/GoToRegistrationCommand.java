package com.reception.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.reception.controller.constant.Constant.WebProperty.PAGE_REGISTRATION;

public class GoToRegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect(PAGE_REGISTRATION);
    }
}
