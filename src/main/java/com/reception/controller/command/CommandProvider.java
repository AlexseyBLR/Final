package com.reception.controller.command;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<String , Command> commandMap = new HashMap<String, Command>();

    private final static CommandProvider instance = new CommandProvider();

    private CommandProvider(){
        commandMap.put("language", new LocalCommand());
        commandMap.put("logination", new LoginationPageCommand());
        commandMap.put("goToRegistration", new GoToRegistrationCommand());
        commandMap.put("resultPage", new ResultPageCommand());
        commandMap.put("registration", new RegistrationPageCommand());
        commandMap.put("adminAddRequestPage", new AdminAddRequestPageCommand());
        commandMap.put("adminSendResultPage", new AdminSendResultPageCommand());
        commandMap.put("userSelectPage", new UserSelectPageCommand());
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static CommandProvider getInstance() {
        return instance;
    }
}
