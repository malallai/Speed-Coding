package fr.mentor6561.chathistory.commands;

import fr.mentor6561.chathistory.ChatHistory;
import fr.mentor6561.chathistory.inventory.ChatHistoryViewer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by mentor6561 on 15/10/2017
 * Created on Spigot:fr.mentor6561.chathistory.commands
 */
public class ChatHistoryCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(args.length == 0) {
            ChatHistoryViewer viewer = new ChatHistoryViewer(Bukkit.getServer().createInventory(null, 6*9, "ChatHistory"));
            viewer.open(player);
            ChatHistory.getInstance().getVariables().addNewChatViewer(player, viewer);
        } else if(args.length == 1) {
            String search = args[0];
            ChatHistoryViewer viewer = new ChatHistoryViewer(Bukkit.getServer().createInventory(null, 6*9, "ChatHistory"), search);
            viewer.open(player);
            ChatHistory.getInstance().getVariables().addNewChatViewer(player, viewer);
        } else {
            // Help
        }
        return false;
    }
}
