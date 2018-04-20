package com.reception.controller.command.Admin;

import com.reception.controller.command.Command;
import com.reception.dao.exception.DAOException;
import com.reception.entity.UserRequest;
import com.reception.service.ResultService;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.reception.controller.constant.Constant.ResultProperty;

public class GetResultCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(GetResultCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<UserRequest> listME = null;
        List<UserRequest> listMR = null;
        List<UserRequest> listAD = null;
        List<UserRequest> listAB = null;
        try {
            listME = resultService.getResult(ResultProperty.MECHANICAL_EXPLOATATION_FACULTY);
            listMR = resultService.getResult(ResultProperty.MECHANICAL_REPAIR_FACULTY);
            listAD = resultService.getResult(ResultProperty.ARCHITECTURE_DESIGN_FACULTY);
            listAB = resultService.getResult(ResultProperty.ARCHITECTURE_BUILDING_FACULTY);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("resultME", listME);
        request.getSession().setAttribute("resultMR", listMR);
        request.getSession().setAttribute("resultAD", listAD);
        request.getSession().setAttribute("resultAB", listAB);


        response.sendRedirect("/adminResult");

    }
}
