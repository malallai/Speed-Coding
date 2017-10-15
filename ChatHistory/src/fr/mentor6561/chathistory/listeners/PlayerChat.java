package fr.mentor6561.chathistory.listeners;

import fr.mentor6561.chathistory.utils.Message;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Date;

/**
 * Created by mentor6561 on 15/10/2017
 * Created on Spigot:fr.mentor6561.chathistory.listeners
 */
public class PlayerChat implements Listener {

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Date date = new Date();
        String playerMessage = event.getMessage();

        Message message = new Message(player, date, playerMessage);
    }

}
