package fr.mentor6561.sim.api;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private static Map<String, SimInventory> inventorys = new HashMap<String, SimInventory>();

    public static Map<String, SimInventory> getInventorys() {
        return inventorys;
    }

    public void registerNewInventory(String id, SimInventory inventory) {
        inventorys.put(id, inventory);
    }

    public SimInventory getInventory(String id) {
        return inventorys.get(id);
    }

}
