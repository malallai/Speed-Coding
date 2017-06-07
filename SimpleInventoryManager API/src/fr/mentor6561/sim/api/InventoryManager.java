package fr.mentor6561.sim.api;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private static Map<String, CustomInventory> inventorys = new HashMap<String, CustomInventory>();

    public static Map<String, CustomInventory> getInventorys() {
        return inventorys;
    }

    public void registerNewInventory(String id, CustomInventory inventory) {
        inventorys.put(id, inventory);
    }

    public CustomInventory getInventory(String id) {
        return inventorys.get(id);
    }

}
