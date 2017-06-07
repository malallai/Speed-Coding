package fr.mentor6561.sim.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public abstract class CustomInventory {

    public Inventory inventory;

    public CustomInventory(InventoryHolder inventoryHolder, InventoryType inventoryType, String name) {
        this.inventory = Bukkit.createInventory(inventoryHolder, inventoryType, name);
        registerItems();
    }

    public CustomInventory(InventoryHolder inventoryHolder, int slot, String name) {
        this.inventory = Bukkit.createInventory(inventoryHolder, slot, name);
        registerItems();
    }

    public CustomInventory(int slot, String name) {
        this(null, slot, name);
    }

    public CustomInventory(InventoryType inventoryType, String name) {
        this(null, inventoryType, name);
    }

    public CustomInventory(String name) {
        this(null, 1*9, name);
    }

    public void addItem(ItemStack itemStack) {
        this.inventory.addItem(itemStack);
    }

    public void setItem(int slot, ItemStack itemStack) {
        this.inventory.setItem(slot, itemStack);
    }

    public void open(Player player) {
        player.openInventory(getInventory());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public abstract void registerItems();
    public abstract void onClick(Player player, int slot, ItemStack item);

}
