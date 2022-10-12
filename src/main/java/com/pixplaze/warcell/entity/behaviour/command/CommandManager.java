package com.pixplaze.warcell.entity.behaviour.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static final Map<String, UnitCommand> commandMap = new HashMap<>();

    private static CommandManager instance;

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }

    public void register(String key, UnitCommand unitCommand) {
        commandMap.put(key, unitCommand);
    }

    public void unregister(String key) {
        commandMap.remove(key);
    }

    public UnitCommand get(String key) {
        return commandMap.get(key);
    }
}
