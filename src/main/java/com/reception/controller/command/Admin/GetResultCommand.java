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

public class ShowResultCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(UsersRequestCommand.class);


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException {

        List<UserRequest> listME = resultService.getResult(ResultProperty.MECHANICAL_EXPLOATATION_FACULTY);
        request.getSession().setAttribute("resultME", listME);

        List<UserRequest> listMR = resultService.getResult(ResultProperty.MECHANICAL_REPAIR_FACULTY);
        request.getSession().setAttribute("resultMR", listMR);

        List<UserRequest> listAD = resultService.getResult(ResultProperty.ARCHITECTURE_DESIGN_FACULTY);
        request.getSession().setAttribute("resultAD", listAD);

        List<UserRequest> listAB = resultService.getResult(ResultProperty.ARCHITECTURE_BUILDING_FACULTY);
        request.getSession().setAttribute("resultAB", listAB);


        response.sendRedirect("/adminResult");

    }
}
