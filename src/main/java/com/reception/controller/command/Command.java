package com.reception.controller.command;

import com.reception.controller.exception.ControllerException;
import com.reception.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, ServiceException;
}
