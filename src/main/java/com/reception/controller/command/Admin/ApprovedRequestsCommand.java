package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.reception.controller.constant.Constant.WebProperty.PAGE_ADMIN_REQUEST;
import static com.reception.controller.constant.Constant.WebProperty.REQUEST_HEADER_NAME;

public class ApprovedRequestsCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(ApprovedRequestsCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            List<UserRequest> list = resultService.getAllUsers();
            for (int i = 0; i < resultService.getAllUsers().size(); i++) {
                resultService.updateUsers(list.get(i));
            }
            request.getSession().setAttribute(REQUEST_HEADER_NAME, list);
            response.sendRedirect(PAGE_ADMIN_REQUEST);
        } catch (
                ServiceException e) {
            logger.error("Exception on \"ApprovedRequestsCommand\"", e);
        }
    }
}
