package com.reception.controller.command;

<<<<<<< HEAD
import com.reception.controller.command.user.addRequestToBuilding.ArchBuildingCommand;
import com.reception.controller.command.user.addRequestToDesign.ArchDesignCommand;
import com.reception.controller.command.user.addRequestToExploatation.MechExploatationCommand;
import com.reception.controller.command.user.addRequestToRepair.MechRepairCommand;
import com.reception.controller.command.adminCommand.ApprovedRequestsCommand;
import com.reception.controller.command.adminCommand.GetRequestCommand;
import com.reception.controller.command.adminCommand.GetResultCommand;
import com.reception.controller.command.adminCommand.GetUsersCommand;
import com.reception.controller.command.user.UpdateUserInfoCommand;
=======
import com.reception.controller.command.Admin.ApprovedRequestsCommand;
import com.reception.controller.command.Admin.ShowResultCommand;
import com.reception.controller.command.Admin.ShowUsersCommand;
import com.reception.controller.command.Admin.UsersRequestCommand;
import com.reception.controller.command.UserCommand.ArchitectureFcultyCommand.ArchBuildingCommand;
import com.reception.controller.command.UserCommand.ArchitectureFcultyCommand.ArchDesignCommand;
import com.reception.controller.command.UserCommand.GetResultCommand;
import com.reception.controller.command.UserCommand.MechanicalFacultyCommand.MechExploatationCommand;
import com.reception.controller.command.UserCommand.MechanicalFacultyCommand.MechRepairCommand;
>>>>>>> parent of 0ef4810... version 20/04/18

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
<<<<<<< HEAD
        commandMap.put("showResult", new GetResultCommand());
        commandMap.put("showResultToUser", new com.reception.controller.command.user.GetResultCommand());
        commandMap.put("showUsers", new GetUsersCommand());
        commandMap.put("updateInfo", new UpdateUserInfoCommand());
=======
        commandMap.put("showResult", new ShowResultCommand());
        commandMap.put("showResultToUser", new GetResultCommand());
        commandMap.put("showUsers", new ShowUsersCommand());

>>>>>>> parent of 0ef4810... version 20/04/18


    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static CommandProvider getInstance() {
        return instance;
    }

}
