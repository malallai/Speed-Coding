package fr.mentor6561.sim;

import fr.mentor6561.sim.api.CustomInventory;
import fr.mentor6561.sim.api.InventoryManager;
import fr.mentor6561.sim.commands.SimAPICommand;
import fr.mentor6561.sim.examples.ExampleInventory;
import fr.mentor6561.sim.listeners.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;

public class SimAPI extends JavaPlugin {

    private static SimAPI api;

    private InventoryManager manager;

    public static SimAPI getApi() {
        return api;
    }

    public void registerNewInventory(String id, CustomInventory inventory) {
        manager.registerNewInventory(id, inventory);
    }

    public CustomInventory getInventory(String id) {
        return manager.getInventory(id);
    }

    public InventoryManager getManager() {
        return manager;
    }

    public void onEnable() {
        api = this;
        manager = new InventoryManager();

        getCommand("sim").setExecutor(new SimAPICommand());
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        registerNewInventory("example", new ExampleInventory());

    }

    public void onDisable() {

    }

}
