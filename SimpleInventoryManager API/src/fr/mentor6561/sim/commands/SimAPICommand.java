package fr.mentor6561.sim.commands;

import fr.mentor6561.sim.Sim;
import fr.mentor6561.sim.SimAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SimAPICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage("§8[§7SimAPI§8] §aVersion " + Sim.getSim().getDescription().getVersion());
        } else {
            if(args[0].equalsIgnoreCase("v") || args[0].equalsIgnoreCase("ver") || args[0].equalsIgnoreCase("version")) {
                sender.sendMessage("§8[§7SimAPI§8] §aVersion " + Sim.getSim().getDescription().getVersion());
            } else if(args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
                sender.sendMessage("§3Usage : §c/sim §6>> §3Show version");
                sender.sendMessage("§3Usage : §c/sim <v/ver/version> §6>> §3Show version");
                sender.sendMessage("§3Usage : §c/sim <h/help/?> §6>> §3Show this page");
                sender.sendMessage("§3Usage : §c/sim example §6>> §3Open example inventory");
            } else if(args[0].equalsIgnoreCase("example")) {
                if(sender instanceof Player) {
                    SimAPI.getApi().getInventory("example").open((Player) sender);
                }
            }
        }
        return false;
    }
}
