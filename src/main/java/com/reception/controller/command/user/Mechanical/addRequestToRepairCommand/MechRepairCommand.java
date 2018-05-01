package com.reception.controller.command.user.Mechanical.addRequestToRepairCommand;

import com.reception.controller.command.Command;
import com.reception.controller.constant.Constant;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class MechRepairCommand implements Command {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(MechRepairCommand.class);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, DAOException {


        HttpSession session = request.getSession(true);
        String userFIO = String.valueOf(session.getAttribute("userFIO"));
        int mathResult = Integer.parseInt(String.valueOf(session.getAttribute("mathResult")));
        int langResult = Integer.parseInt(String.valueOf(session.getAttribute("physResult")));
        int physResult = Integer.parseInt(String.valueOf(session.getAttribute("langResult")));
        int sertResult = Integer.parseInt(String.valueOf(session.getAttribute("sertResult")));


        UserRequest resultForRequest = new UserRequest(userFIO, mathResult, physResult, langResult, sertResult, Constant.RequestProperty.MECHANICAL_REPAIR_FACULTY);

        boolean result = resultService.saveResult(resultForRequest);
        if (result) {
            session.setAttribute("result1", new String("Send"));
            response.sendRedirect("/userReq");

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/BasePages/errorPage.jsp");
            dispatcher.forward(request, response);
        }


    }


}
