package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.controller.exception.ControllerException;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.reception.controller.constant.Constant.WebProperty.HIDDEN_PARAMETER_FOR_DELETE_REQUEST;
import static com.reception.controller.constant.Constant.WebProperty.PAGE_ADMIN_REQUEST;

public class DeleteRequestCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService service = factory.getResultService();
    private final static Logger logger = Logger.getLogger(DeleteRequestCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, ServiceException {
        String fio = (String) request.getParameter(HIDDEN_PARAMETER_FOR_DELETE_REQUEST);
        service.delete(fio);
        response.sendRedirect(PAGE_ADMIN_REQUEST);
    }
}
