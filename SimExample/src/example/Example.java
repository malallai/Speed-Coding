package example;

import fr.mentor6561.sim.api.SimInventory;
import fr.mentor6561.sim.api.SimItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class Example extends SimInventory {

    public Example() {
        super(InventoryType.HOPPER, "Example");
    }

    @Override
    public void registerItems() {
        setItem(1, new SimItem().createItem(Material.IRON_INGOT).setName("§fIron !!"));
        setItem(2, new SimItem().createItem(Material.GOLD_INGOT).setName("§6Gold !!"));
        setItem(3, new SimItem().createItem(Material.DIAMOND).setName("§bDiamond !!"));
    }

    @Override
    public void onClick(Player player, int slot, ItemStack item) {
        player.sendMessage("§7You've get an " + item.getItemMeta().getDisplayName());
        player.getInventory().addItem(item);
    }

}
