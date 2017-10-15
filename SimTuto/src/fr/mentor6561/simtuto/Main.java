package fr.mentor6561.simtuto;

import fr.mentor6561.sim.SimAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    SimAPI simAPI;

    public void onEnable() {
        simAPI = SimAPI.getApi();
        simAPI.registerNewInventory("exampletuto", new Example());

        getServer().getPluginManager().registerEvents(this, this);
    }

    public void onDisable() {

    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if(event.getMessage().equalsIgnoreCase("open")) {
            simAPI.getInventory("exampletuto").open(event.getPlayer());
        }
    }

}
