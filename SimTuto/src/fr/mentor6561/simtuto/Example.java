package fr.mentor6561.simtuto;

import fr.mentor6561.sim.api.SimInventory;
import fr.mentor6561.sim.api.SimItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class Example extends SimInventory {

    public Example() {
        super(InventoryType.HOPPER, "§6Example");
    }

    @Override
    public void registerItems() {
        setItem(1, new SimItem().createItem(Material.IRON_INGOT, 10, 0).setName("§fFree iron ingots").setLore("Ligne 1", "Ligne 2"));
        setItem(2, new SimItem().createItem(Material.GOLD_INGOT, 5, 0).setName("§6Free gold ingots").setLore("Ligne 1", "Ligne 2"));
        setItem(3, new SimItem().createItem(Material.DIAMOND).setName("§bFree diamond").setLore("Ligne 1", "Ligne 2"));
    }

    @Override
    public void onClick(Player player, int i, ItemStack itemStack) {
        player.sendMessage("§c" + itemStack.getAmount() + " §7free " + itemStack.getType().name().toLowerCase() + " for you.");
        player.getInventory().addItem(itemStack);
        player.closeInventory();
    }
}
