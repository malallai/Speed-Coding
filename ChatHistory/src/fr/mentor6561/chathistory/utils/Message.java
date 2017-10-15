package fr.mentor6561.chathistory.utils;

import fr.mentor6561.chathistory.ChatHistory;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mentor6561 on 15/10/2017
 * Created on Spigot:fr.mentor6561.chathistory.utils
 */
public class Message {

    Player player;
    Date   date;
    String message;
    UtilItem item;

    String id;

    public Message(Player player, Date date, String message) {
        this.player = player;
        this.date = date;
        this.message = message;
        this.id = new RandomString(15).nextString();
        ChatHistory.getInstance().getVariables().addNewMessage(this);
    }

    public Player getPlayer() {
        return player;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public UtilItem getItem() {
        if(item == null) {
            List<String> lore = new ArrayList<String>();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
            lore.add("§6Sender: §e" + getPlayer().getName());
            lore.add("§6Date: §e" + format.format(getDate()));
            lore.add("§6Message: §e" + getMessage());
            lore.add(" ");
            lore.add("§6ID: §e" + getId());
            item = new UtilItem().createItem(Material.PAPER).setName(getId()).setLore(lore);
        }
        return item;
    }
}
