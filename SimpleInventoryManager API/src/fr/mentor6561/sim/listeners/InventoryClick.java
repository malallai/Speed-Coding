package fr.mentor6561.sim.listeners;

import fr.mentor6561.sim.SimAPI;
import fr.mentor6561.sim.api.CustomInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getWhoClicked() instanceof Player) {
            if(event.getInventory().getName() != null) {
                for(CustomInventory inventory : SimAPI.getApi().getManager().getInventorys().values()) {
                    if(event.getInventory().getName().equalsIgnoreCase(inventory.getInventory().getName())) {
                        inventory.onClick((Player) event.getWhoClicked(), event.getSlot(), event.getCurrentItem());
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

}
