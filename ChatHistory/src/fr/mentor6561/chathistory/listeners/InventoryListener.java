package fr.mentor6561.chathistory.listeners;

import fr.mentor6561.chathistory.ChatHistory;
import fr.mentor6561.chathistory.inventory.ChatHistoryViewer;
import fr.mentor6561.chathistory.utils.Message;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import java.text.SimpleDateFormat;

/**
 * Created by mentor6561 on 15/10/2017
 * Created on Spigot:fr.mentor6561.chathistory.listeners
 */
public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player    player = (Player) event.getWhoClicked();
        ItemStack item   = event.getCurrentItem();
        ClickType type = event.getClick();
        if(item != null && item.getItemMeta() != null) {
            if(event.getInventory().getTitle().toLowerCase().equalsIgnoreCase("chathistory")) {
                event.setCancelled(true);
                ChatHistoryViewer viewer = ChatHistory.getInstance().getVariables().getViewers().get(player);
                if (event.getSlot() == 47) {
                    viewer.next(player);
                } else if (event.getSlot() == 45) {
                    viewer.previous(player);
                } else if(event.getSlot() == 53) {
                    player.closeInventory();
                } else if(event.getSlot() >= 0 && event.getSlot() <= 35) {
                    Message message = ChatHistory.getInstance().getVariables().getMessage(item.getItemMeta().getDisplayName());
                    if(type == ClickType.LEFT) {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
                        player.sendMessage("§6Sender: §e" + message.getPlayer().getName());
                        player.sendMessage("§6Date: §e" + format.format(message.getDate()));
                        player.sendMessage("§6Message: §e" + message.getMessage());
                        player.sendMessage(" ");
                        player.sendMessage("§6ID: §e" + message.getId());
                    } else if(type == ClickType.RIGHT) {
                        ChatHistory.getInstance().getVariables().getMessages().remove(message);
                        viewer.update();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if(event.getInventory().getTitle().equalsIgnoreCase("chathistory")) {
            ChatHistory.getInstance().getVariables().getViewers().remove(player);
        }
    }

}
