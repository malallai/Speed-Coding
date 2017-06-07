package fr.mentor6561.sim.examples;

import fr.mentor6561.sim.api.CustomInventory;
import fr.mentor6561.sim.api.UtilItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class ExampleInventory extends CustomInventory {

    public ExampleInventory() {
        super(InventoryType.HOPPER, "Example");
    }

    @Override
    public void registerItems() {
        setItem(1, new UtilItem().createItem(Material.IRON_INGOT).setName("§fIron !!"));
        setItem(2, new UtilItem().createItem(Material.GOLD_INGOT).setName("§6Gold !!"));
        setItem(3, new UtilItem().createItem(Material.DIAMOND).setName("§bDiamond !!"));
    }

    @Override
    public void onClick(Player player, int slot, ItemStack item) {
        player.sendMessage("§7You've get an " + item.getItemMeta().getDisplayName());
        player.getInventory().addItem(item);
    }

}
