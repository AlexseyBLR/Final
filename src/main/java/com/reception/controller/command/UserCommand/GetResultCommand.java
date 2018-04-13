package com.reception.controller.command.UserCommand;

import com.reception.controller.command.Admin.UsersRequestCommand;
import com.reception.controller.command.Command;
import com.reception.controller.constant.Constant;
import com.reception.controller.exception.ControllerException;
import com.reception.dao.exception.DAOException;
import com.reception.entity.ResultForRequest;
import com.reception.service.ResultService;
import com.reception.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetResultCommand implements Command {

    private final ServiceFactory factory = ServiceFactory.getInstance();
    private final ResultService resultService = factory.getResultService();
    private final static Logger logger = Logger.getLogger(GetResultCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, DAOException {

        List<ResultForRequest> listME = resultService.getResult(Constant.ResultProperty.MECHANICAL_EXPLOATATION_FACULTY);
        request.getSession().setAttribute("resultME", listME);

        List<ResultForRequest> listMR = resultService.getResult(Constant.ResultProperty.MECHANICAL_REPAIR_FACULTY);
        request.getSession().setAttribute("resultMR", listMR);

        List<ResultForRequest> listAD = resultService.getResult(Constant.ResultProperty.ARCHITECTURE_DESIGN_FACULTY);
        request.getSession().setAttribute("resultAD", listAD);

        List<ResultForRequest> listAB = resultService.getResult(Constant.ResultProperty.ARCHITECTURE_BUILDING_FACULTY);
        request.getSession().setAttribute("resultAB", listAB);


        response.sendRedirect("/result");
    }
}
