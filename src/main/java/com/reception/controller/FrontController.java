package com.reception.controller;

import com.reception.controller.command.Command;
import com.reception.controller.command.CommandProvider;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class FrontController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String commandName = request.getParameter("command");
        Command command1 = CommandProvider.getInstance().getCommandMap().get(commandName);
        try {
            command1.execute(request, response);
        } catch (ControllerException e) {
            e.printStackTrace();
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init() throws ServletException {
        super.init();

    }


}