package fr.mentor6561.chathistory;

import fr.mentor6561.chathistory.commands.ChatHistoryCommand;
import fr.mentor6561.chathistory.inventory.ChatHistoryViewer;
import fr.mentor6561.chathistory.listeners.InventoryListener;
import fr.mentor6561.chathistory.listeners.PlayerChat;
import fr.mentor6561.chathistory.utils.Message;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mentor6561 on 15/10/2017
 * Created on Spigot:fr.mentor6561.chathistory
 */
public class Variables {

    List<Message> messages;
    Map<Player, ChatHistoryViewer> viewers;

    public void enable() {
        this.messages = new ArrayList<Message>();
        this.viewers = new HashMap<Player, ChatHistoryViewer>();

        ChatHistory instance = ChatHistory.getInstance();

        PluginManager pluginManager = instance.getServer().getPluginManager();
        pluginManager.registerEvents(new InventoryListener(), instance);
        pluginManager.registerEvents(new PlayerChat(), instance);

        instance.getCommand("chathistory").setExecutor(new ChatHistoryCommand());
    }

    public void disable() {

    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addNewMessage(Message message) {
        this.messages.add(message);
    }

    public Message getMessage(String id) {
        for(Message message : getMessages()) if(message.getId().equalsIgnoreCase(id)) return message;
        return null;
    }

    public Map<Player, ChatHistoryViewer> getViewers() {
        return viewers;
    }

    public void addNewChatViewer(Player player, ChatHistoryViewer chatHistoryViewer) {
        this.viewers.put(player, chatHistoryViewer);
    }
}
