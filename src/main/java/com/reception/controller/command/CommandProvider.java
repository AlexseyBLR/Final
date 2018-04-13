package com.reception.controller.command;

import com.reception.controller.command.Admin.ApprovedRequestsCommand;
import com.reception.controller.command.Admin.ShowResultCommand;
import com.reception.controller.command.Admin.ShowUsersCommand;
import com.reception.controller.command.Admin.UsersRequestCommand;
import com.reception.controller.command.UserCommand.ArchitectureFcultyCommand.ArchBuildingCommand;
import com.reception.controller.command.UserCommand.ArchitectureFcultyCommand.ArchDesignCommand;
import com.reception.controller.command.UserCommand.GetResultCommand;
import com.reception.controller.command.UserCommand.MechanicalFacultyCommand.MechExploatationCommand;
import com.reception.controller.command.UserCommand.MechanicalFacultyCommand.MechRepairCommand;

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
        commandMap.put("registration", new RegistrationPageCommand());
        commandMap.put("userSelectPage", new UserSelectPageCommand());
        commandMap.put("Exploatation", new MechExploatationCommand());
        commandMap.put("CarRepair", new MechRepairCommand());
        commandMap.put("Building", new ArchBuildingCommand());
        commandMap.put("Design", new ArchDesignCommand());
        commandMap.put("getRequests", new UsersRequestCommand());
        commandMap.put("approvedRequests", new ApprovedRequestsCommand());
        commandMap.put("showResult", new ShowResultCommand());
        commandMap.put("showResultToUser", new GetResultCommand());
        commandMap.put("showUsers", new ShowUsersCommand());



    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static CommandProvider getInstance() {
        return instance;
    }
}
