package com.reception.controller.command.user;


import com.reception.controller.command.Command;
import com.reception.controller.constant.Constant;
import com.reception.dao.exception.DAOException;

import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.reception.controller.constant.Constant.WebProperty.*;

public class GetResultCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(GetResultCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException {

        List<UserRequest> listME = resultService.getResult(Constant.ResultProperty.MECHANICAL_EXPLOATATION_FACULTY);
        request.getSession().setAttribute(SESSION_ATTRIBUTE_ME, listME);

        List<UserRequest> listMR = resultService.getResult(Constant.ResultProperty.MECHANICAL_REPAIR_FACULTY);
        request.getSession().setAttribute(SESSION_ATTRIBUTE_MR, listMR);

        List<UserRequest> listAD = resultService.getResult(Constant.ResultProperty.ARCHITECTURE_DESIGN_FACULTY);
        request.getSession().setAttribute(SESSION_ATTRIBUTE_AD, listAD);

        List<UserRequest> listAB = resultService.getResult(Constant.ResultProperty.ARCHITECTURE_BUILDING_FACULTY);
        request.getSession().setAttribute(SESSION_ATTRIBUTE_AB, listAB);


        response.sendRedirect(PAGE_USER_RESULT);
    }
}
