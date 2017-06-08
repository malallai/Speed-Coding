package fr.mentor6561.sim;

import fr.mentor6561.sim.api.SimInventory;
import fr.mentor6561.sim.api.InventoryManager;
import fr.mentor6561.sim.examples.ExampleInventory;

public class SimAPI {

    private static SimAPI api;

    private InventoryManager manager;

    public SimAPI() {
        api = this;

        manager = new InventoryManager();
        registerNewInventory("example", new ExampleInventory());
    }

    public static SimAPI getApi() {
        return api;
    }

    public void registerNewInventory(String id, SimInventory inventory) {
        manager.registerNewInventory(id, inventory);
    }

    public SimInventory getInventory(String id) {
        return manager.getInventory(id);
    }

    public InventoryManager getManager() {
        return manager;
    }

}
