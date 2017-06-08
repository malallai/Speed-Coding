package fr.mentor6561.sim;

import fr.mentor6561.sim.commands.SimAPICommand;
import fr.mentor6561.sim.listeners.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;

public class Sim extends JavaPlugin {

    static Sim sim;

    public static Sim getSim() {
        return sim;
    }

    public void onEnable() {
        sim = this;
        new SimAPI();
        getCommand("sim").setExecutor(new SimAPICommand());
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }

    public void onDisable() {

    }

}
