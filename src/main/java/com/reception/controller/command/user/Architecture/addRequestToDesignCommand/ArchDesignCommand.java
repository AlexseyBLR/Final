package com.reception.controller.command.user.Architecture.addRequestToDesignCommand;

import com.reception.controller.command.Command;
import com.reception.controller.constant.Constant;
import com.reception.controller.exception.ControllerException;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.exception.ServiceException;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.reception.controller.constant.Constant.WebProperty.*;


public class ArchDesignCommand implements Command {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(ArchDesignCommand.class);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {


        HttpSession session = request.getSession(true);
        String userFIO = String.valueOf(session.getAttribute(FIO_PARAMETER));
        int mathResult = Integer.parseInt(String.valueOf(session.getAttribute(MATH_RESULT_PARAMETER)));
        int langResult = Integer.parseInt(String.valueOf(session.getAttribute(PHYS_RESULT_PARAMETER)));
        int physResult = Integer.parseInt(String.valueOf(session.getAttribute(LANG_RESULT_PARAMETER)));
        int sertResult = Integer.parseInt(String.valueOf(session.getAttribute(SERT_RESULT_PARAMETER)));



        UserRequest resultForRequest = new UserRequest(userFIO, mathResult, physResult, langResult, sertResult, Constant.RequestProperty.ARCHITECTURE_DESIGN_FACULTY);

        boolean result = false;
        try {
            result = resultService.saveResult(resultForRequest);
        } catch (ServiceException e) {
            logger.error("Request error", e);
        }
        if (result) {
            session.setAttribute(SESSION_ATTRIBUTE_RESULT, new String(SESSION_ATTRIBUTE_RESULT_SENT));
            response.sendRedirect(PAGE_USER_REQUEST);

        } else {
            response.sendRedirect(PAGE_ERROR);
        }


    }


}

