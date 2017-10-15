package fr.mentor6561.chathistory;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by mentor6561 on 15/10/2017
 * Created on Spigot:fr.mentor6561.chathistory
 */
public class ChatHistory extends JavaPlugin {

    public static ChatHistory instance;
    Variables variables;

    @Override
    public void onEnable() {
        instance = this;
        variables = new Variables();
        variables.enable();
    }

    @Override
    public void onDisable() {
        variables.disable();
    }

    public static ChatHistory getInstance() {
        return instance;
    }

    public Variables getVariables() {
        return variables;
    }

}
