package com.reception.controller.command;

import com.reception.controller.command.Admin.ApprovedRequestsCommand;
import com.reception.controller.command.Admin.GetResultCommand;
import com.reception.controller.command.Admin.GetUsersCommand;
import com.reception.controller.command.Admin.GetRequestCommand;
import com.reception.controller.command.UserCommand.AddRequestToDesignCommand.ArchDesignCommand;
import com.reception.controller.command.UserCommand.AddRequestToBuildingCommand.ArchBuildingCommand;
import com.reception.controller.command.UserCommand.AddRequestToExploatationCommand.MechExploatationCommand;
import com.reception.controller.command.UserCommand.AddRequestToRepairCommand.MechRepairCommand;



import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<String, Command> commandMap = new HashMap<String, Command>();

    private final static CommandProvider instance = new CommandProvider();

    private CommandProvider() {
        commandMap.put("language", new LocalizationCommand());
        commandMap.put("logination", new LoginationPageCommand());
        commandMap.put("goToRegistration", new GoToRegistrationCommand());
        commandMap.put("logout", new LogOutCommand());
        commandMap.put("registration", new RegistrationCommand());
        commandMap.put("Exploatation", new MechExploatationCommand());
        commandMap.put("CarRepair", new MechRepairCommand());
        commandMap.put("Building", new ArchBuildingCommand());
        commandMap.put("Design", new ArchDesignCommand());
        commandMap.put("getRequests", new GetRequestCommand());
        commandMap.put("approvedRequests", new ApprovedRequestsCommand());
        commandMap.put("showResult", new GetResultCommand());
        commandMap.put("showResultToUser", new com.reception.controller.command.UserCommand.GetResultCommand());
        commandMap.put("showUsers", new GetUsersCommand());



    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static CommandProvider getInstance() {
        return instance;
    }
}
