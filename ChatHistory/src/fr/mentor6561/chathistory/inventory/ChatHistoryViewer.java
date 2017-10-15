package fr.mentor6561.chathistory.inventory;

import fr.mentor6561.chathistory.ChatHistory;
import fr.mentor6561.chathistory.utils.Message;
import fr.mentor6561.chathistory.utils.UtilItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by mentor6561 on 15/10/2017
 * Created on Spigot:fr.mentor6561.chathistory.inventory
 */
public class ChatHistoryViewer {

    private Inventory inventory;
    private String    search;
    private int       page;

    public ChatHistoryViewer(Inventory inventory, String search) {
        this.inventory = inventory;
        this.search = search;
        this.page = 1;
    }

    public ChatHistoryViewer(Inventory inventory) {
        this.inventory = inventory;
        this.page = 1;
    }

    public void open(Player player) {
        update();
        player.openInventory(this.inventory);
    }

    public void update() {
        for (int i = 0; i < 54; i++) this.inventory.setItem(i, new ItemStack(Material.AIR));
        for (int x = 36; x < 45; x++)
            inventory.setItem(x, new UtilItem().createItem(Material.STAINED_GLASS_PANE, 1, 7).setName(" "));
        this.inventory.setItem(47, new UtilItem().createItem(Material.SKULL_ITEM, 1, 3).setName("§7Page suivante").setOwner("MHF_ArrowRight"));
        this.inventory.setItem(45, new UtilItem().createItem(Material.SKULL_ITEM, 1, 3).setName("§7Page précédente").setOwner("MHF_ArrowLeft"));
        this.inventory.setItem(46, new UtilItem().createItem(Material.PAPER, page, 0).setName("§7Page actuelle: §8" + page));
        this.inventory.setItem(53, new UtilItem().createItem(Material.REDSTONE, 1, 0).setName("§cAnnuler"));

        int max    = page * 35;
        int number = (page - 1) * 35;
        int slot   = 0;
        int size   = ChatHistory.getInstance().getVariables().getMessages().size();
        for (Message message : ChatHistory.getInstance().getVariables().getMessages()) {
            if (number <= max) {
                this.inventory.setItem(slot, new ItemStack(Material.AIR));
                if(size > number) {
                    if (search == null) {
                        this.inventory.setItem(slot, message.getItem());
                        number++;
                        slot++;
                    } else {
                        if (message.getMessage().toLowerCase().contains(search.toLowerCase()) || message.getPlayer().getName().toLowerCase().contains(search.toLowerCase())) {
                            this.inventory.setItem(slot, message.getItem());
                            number++;
                            slot++;
                        }
                    }
                }
            }
        }
    }

    public void changePage(int page, Player player) {
        this.page = page;
        update();
    }

    public final int getPage() {
        return this.page;
    }

    public void next(Player player) {
        this.changePage(this.page + 1, player);
    }

    public void previous(Player player) {
        if ((this.page - 1) != 0) this.changePage(this.page - 1, player);
    }

}
