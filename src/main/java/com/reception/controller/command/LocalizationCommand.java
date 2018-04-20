package com.reception.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LocalizationCommand implements Command {

    private final static String REQUEST_PAGE_PARAMETER = "page";

    private final static String LANGUAGE_PARAMETER = "language";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = request.getParameter(REQUEST_PAGE_PARAMETER);
        String language = request.getParameter(LANGUAGE_PARAMETER);
        request.getSession().setAttribute(LANGUAGE_PARAMETER, language);
        response.sendRedirect(page);
    }
}
