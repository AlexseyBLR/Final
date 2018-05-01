package com.reception.controller.command.user.addRequestToBuilding;

import com.reception.controller.command.Command;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.reception.controller.constant.Constant.RequestProperty;
import static com.reception.controller.constant.Constant.WebProperty.PAGE_ERROR;
import static com.reception.controller.constant.Constant.WebProperty.PAGE_USER_REQUEST;

public class ArchBuildingCommand implements Command {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(ArchBuildingCommand.class);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException, DAOException {


        HttpSession session = request.getSession(true);
        String userFIO = (String)session.getAttribute("userFIO");
        int mathResult = Integer.parseInt(String.valueOf(session.getAttribute("mathResult")));
        int langResult = Integer.parseInt(String.valueOf(session.getAttribute("physResult")));
        int physResult = Integer.parseInt(String.valueOf(session.getAttribute("langResult")));
        int sertResult = Integer.parseInt(String.valueOf(session.getAttribute("sertResult")));


        UserRequest resultForRequest = new UserRequest(userFIO, mathResult, physResult, langResult, sertResult, RequestProperty.ARCHITECTURE_BUILDING_FACULTY);

        boolean result = resultService.saveResult(resultForRequest);
        if (result) {
            session.setAttribute("result1", new String("Send"));
            response.sendRedirect(PAGE_USER_REQUEST);

        } else {
            response.sendRedirect(PAGE_ERROR);
        }


    }


}


