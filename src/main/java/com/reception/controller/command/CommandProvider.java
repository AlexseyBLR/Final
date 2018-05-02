package com.reception.controller.command;

import com.reception.controller.command.Admin.ApprovedRequestsCommand;
import com.reception.controller.command.Admin.GetRequestCommand;
import com.reception.controller.command.Admin.GetResultForAdminCommand;
import com.reception.controller.command.Admin.GetUsersCommand;
import com.reception.controller.command.user.Architecture.addRequestToBuildingCommand.ArchBuildingCommand;
import com.reception.controller.command.user.Architecture.addRequestToDesignCommand.ArchDesignCommand;
import com.reception.controller.command.user.GetResultCommand;
import com.reception.controller.command.user.Mechanical.addRequestToExploatationCommand.MechExploatationCommand;
import com.reception.controller.command.user.Mechanical.addRequestToRepairCommand.MechRepairCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<String, Command> commandMap = new HashMap<String, Command>();

    private final static CommandProvider instance = new CommandProvider();

    private CommandProvider() {
        commandMap.put("language", new LocalCommand());
        commandMap.put("logination", new LoginationPageCommand());
        commandMap.put("goToRegistration", new GoToRegistrationCommand());
        commandMap.put("logout", new LogOutCommand());
        commandMap.put("registration", new RegistrationCommand());
        commandMap.put("Exploatation", new MechExploatationCommand());
        commandMap.put("CarRepair", new MechRepairCommand());
        commandMap.put("Architecture", new ArchBuildingCommand());
        commandMap.put("Design", new ArchDesignCommand());
        commandMap.put("approvedRequests", new ApprovedRequestsCommand());

        commandMap.put("showResult", new GetResultCommand());
        commandMap.put("showResultToUser", new GetResultCommand());
        commandMap.put("showUsers", new GetUsersCommand());

        //commandMap.put("updateInfo", new UpdateUserInfoCommand());

        commandMap.put("showResultForAdmin", new GetResultForAdminCommand());
        commandMap.put("showResultToUser", new GetResultCommand());
        commandMap.put("showUsers", new GetUsersCommand());
        commandMap.put("getRequests", new GetRequestCommand());
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static CommandProvider getInstance() {
        return instance;
    }
}
