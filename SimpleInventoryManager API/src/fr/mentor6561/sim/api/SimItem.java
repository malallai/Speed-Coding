package fr.mentor6561.sim.api;

import org.bukkit.Material;

import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class SimItem extends ItemStack {

    public static Material[] ENUM$DATA = (new Material[]{Material.STONE, Material.WOOD, Material.SPONGE,
            Material.SANDSTONE, Material.WOOL, Material.STEP, Material.STAINED_GLASS, Material.SMOOTH_BRICK,
            Material.WOOD_STEP, Material.ANVIL, Material.QUARTZ_BLOCK, Material.STAINED_CLAY,
            Material.STAINED_GLASS_PANE, Material.PRISMARINE, Material.CARPET, Material.RED_SANDSTONE,
            Material.RED_SANDSTONE_STAIRS, Material.COAL, Material.GOLDEN_APPLE, Material.COOKED_FISH,
            Material.INK_SACK, Material.BANNER});

    public static Material[] ENUM$EXCEPTION = (new Material[]{Material.INK_SACK});

    public SimItem() {
    }

    @SuppressWarnings("deprecation")
    public SimItem(ItemStack s) {
        this.setType(s.getType());
        this.setDurability(s.getDurability());
        if (s.getItemMeta() != null) {
            this.setItemMeta(s.getItemMeta());
        }
        this.setAmount(s.getAmount());
    }

    public static boolean hasEnumData(Material mat) {
        boolean check1 = false;
        for (int x = 0; x < ENUM$DATA.length; x++) {
            if (mat.equals(ENUM$DATA[x]) && !check1) {
                check1 = true;
            }
            if (x == ENUM$DATA.length) {
                check1 = false;
            }
        }
        return check1;
    }

    public static boolean isException(Material mat) {
        boolean check1 = false;
        for (int x = 0; x < ENUM$EXCEPTION.length; x++) {
            if (mat.equals(ENUM$EXCEPTION[x]) && !check1) {
                check1 = true;
            }
            if (x == ENUM$EXCEPTION.length) {
                check1 = false;
            }
        }
        return check1;
    }

    public SimItem setAmount2(int value) {
        this.setAmount(value);
        return this;
    }

    public SimItem createItem(Material material, int amount, int data) {
        this.setType(material);
        this.setAmount(amount);
        this.setDurability((short) data);
        return this;
    }

    public SimItem createItem(Material material, int amount, MaterialData data) {
        this.setType(material);
        this.setAmount(amount);
        this.setData(data);
        return this;
    }

    public SimItem createItem(Material material) {
        this.setType(material);
        this.setAmount(1);
        return this;
    }

    public String getName() {
        return this.getItemMeta().getDisplayName();
    }

    public SimItem setName(String name) {
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(name);
        this.setItemMeta(meta);
        return this;
    }

    public SimItem setLore(String... lore) {
        ItemMeta          meta = getItemMeta();
        ArrayList<String> list = new ArrayList<String>();
        if (lore.length > 0) {
            for (String line : lore) {
                list.add(ChatColor.translateAlternateColorCodes('&', line));
            }
        }
        if (lore.length > 0) {
            meta.setLore(list);
        }
        this.setItemMeta(meta);
        return this;
    }

    public SimItem setLore(List<String> lore) {
        ItemMeta meta = getItemMeta();
        if (lore != null)
            meta.setLore(lore);
        this.setItemMeta(meta);
        return this;
    }

    public SimItem addLore(List<String> lore) {
        ItemMeta meta = getItemMeta();
        if (getLore() != null) {
            List<String> defaultLore = getLore();
            defaultLore.addAll(lore);
            if (lore != null)
                meta.setLore(defaultLore);
            this.setItemMeta(meta);
        } else
            return setLore(lore);
        return this;
    }

    public SimItem addLore(String... lore) {
        ItemMeta meta = getItemMeta();
        if (getLore() != null) {
            ArrayList<String> list = new ArrayList<String>();
            list.addAll(getLore());
            if (lore.length > 0) {
                for (String line : lore) {
                    list.add(ChatColor.translateAlternateColorCodes('&', line));
                }
            }
            if (lore.length > 0) {
                meta.setLore(list);
            }
            this.setItemMeta(meta);
        } else
            return setLore(lore);
        return this;
    }

    public List<String> getLore() {
        return this.getItemMeta().getLore();
    }

    public SimItem addEnchantement(int level, Enchantment... enchant) {
        for (Enchantment ench : enchant) {
            this.addUnsafeEnchantment(ench, level);
        }
        return this;
    }

    public SimItem setOwner(OfflinePlayer off) {
        return setOwner(off.getName());
    }

    public SimItem addPatern(Pattern a) {
        if (this.getType().equals(Material.BANNER) || this.getType().equals(Material.STANDING_BANNER)
                || this.getType().equals(Material.WALL_BANNER)) {
            BannerMeta meta = (BannerMeta) getItemMeta();
            meta.addPattern(a);
        }
        return this;
    }

    public SimItem setBaseColor(DyeColor a) {
        if (this.getType().equals(Material.BANNER) || this.getType().equals(Material.STANDING_BANNER)
                || this.getType().equals(Material.WALL_BANNER)) {
            BannerMeta meta = (BannerMeta) getItemMeta();
            meta.setBaseColor(a);
        }
        return this;
    }

    public SimItem setOwner(String player) {
        try {
            if (!player.equals(null)) {
                if (this.getType().equals(Material.SKULL_ITEM) && this.getDurability() == 3) {
                    SkullMeta meta = (SkullMeta) getItemMeta();
                    meta.setOwner(player);
                    this.setItemMeta(meta);
                }
            }
        } catch (Exception e) {
        }
        return this;
    }

    public SimItem translateColor(byte color) {
        switch (color) {
            case 0:
                setColor(25, 25, 25);
                break;
            case 1:
                setColor(153, 51, 51);
                break;
            case 2:
                setColor(102, 127, 51);
                break;
            case 3:
                setColor(102, 76, 51);
                break;
            case 4:
                setColor(51, 76, 178);
                break;
            case 5:
                setColor(127, 63, 178);
                break;
            case 6:
                setColor(76, 127, 153);
                break;
            case 7:
                setColor(153, 153, 153);
                break;
            case 8:
                setColor(76, 76, 76);
                break;
            case 9:
                setColor(242, 127, 165);
                break;
            case 10:
                setColor(127, 204, 25);
                break;
            case 11:
                setColor(229, 229, 51);
                break;
            case 12:
                setColor(102, 153, 216);
                break;
            case 13:
                setColor(178, 76, 216);
                break;
            case 14:
                setColor(216, 127, 51);
                break;
            case 15:
                setColor(255, 255, 255);
                break;
            default:
                break;
        }
        return this;
    }

    public SimItem setColor(String string) {
        if (!string.equals("null")) {
            setColor(Integer.parseInt(string.split(" ")[0]), Integer.parseInt(string.split(" ")[1]),
                    Integer.parseInt(string.split(" ")[2]));
        }
        return this;
    }

    public SimItem addPage(String... string) {
        if (this.getType().equals(Material.WRITTEN_BOOK)) {
            BookMeta meta = (BookMeta) this.getItemMeta();
            meta.addPage(string);
            this.setItemMeta(meta);
        }
        return this;
    }

    public SimItem setAuthor(String name) {
        if (this.getType().equals(Material.WRITTEN_BOOK)) {
            BookMeta meta = (BookMeta) this.getItemMeta();
            meta.setAuthor(name);
            this.setItemMeta(meta);
        }
        return this;
    }

    public SimItem setTitle(String name) {
        if (this.getType().equals(Material.WRITTEN_BOOK)) {
            BookMeta meta = (BookMeta) this.getItemMeta();
            meta.setTitle(name);
            this.setItemMeta(meta);
        }
        return this;
    }

    public SimItem setColor(int red, int green, int blue) {
        String redd   = "" + red;
        String greenn = "" + green;
        String bluee  = "" + blue;
        try {
            if (!redd.equals(null) && !greenn.equals(null) && !bluee.equals(null)) {
                if (this.getType().equals(Material.LEATHER_BOOTS) || this.getType().equals(Material.LEATHER_LEGGINGS)
                        || this.getType().equals(Material.LEATHER_CHESTPLATE)
                        || this.getType().equals(Material.LEATHER_HELMET)) {
                    LeatherArmorMeta meta = (LeatherArmorMeta) getItemMeta();
                    meta.setColor(Color.fromRGB(red, green, blue));
                    this.setItemMeta(meta);
                }
            }
        } catch (Exception e) {
        }
        return this;
    }

    public ItemStack setGlowing() {
        ItemStack stack = this;
        /*
		 * if (this.getEnchantments() != null) stack = glow(this);
		 */
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.setItemMeta(meta);
        return stack;
    }

    public ItemStack removePotionLore() {
        ItemStack stack = this;
        ItemMeta  meta  = getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        this.setItemMeta(meta);
        return stack;
    }

    public ItemStack setGlowingRecord() {
        ItemStack stack = this;
		/*
		 * if (this.getEnchantments() != null) stack = glow(this);
		 */
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        this.setItemMeta(meta);
        return stack;
    }

    public ItemStack hideEnchants() {
        ItemStack stack = this;
        ItemMeta  meta  = getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.setItemMeta(meta);
        return stack;
    }

    public ItemStack removeAttributes() {
        ItemStack stack = this;
        ItemMeta  meta  = getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        this.setItemMeta(meta);
        return stack;
    }

    public SimItem translateItem(String[] args, Player player) {
        System.out.println(args.toString() + " " + args.length);
        createItem(Material.getMaterial(Integer.parseInt(args[0])),
                Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        try {
            for (int x = 3; x < args.length; x++) {
                if (args[x].startsWith("lore:")) {
                    ArrayList<String> list = new ArrayList<String>();
                    for (int i = x; i < args.length; i++) {
                        try {
                            list.add(args[i].replace('&', '§').replace("%player%", player.getName()).replace("_", " ").replace("lore:", ""));
                        } catch (Exception e) {
                        }
                    }
                    setLore(list);
                } else if (args[x].startsWith("owner:")) {
                    setOwner(args[x].replace("owner:", ""));
                } else if (args[x].startsWith("color:")) {
                    String argss = args[x].replace("color:", "");
                    setColor(Integer.parseInt(argss.split("_")[0]),
                            Integer.parseInt(argss.split("_")[1]), Integer.parseInt(argss.split("_")[2]));
                } else if (args[x].startsWith("name:")) {
                    setName(args[x].replace('&', '§').replace("%player%", player.getName())
                            .replace("_", " ").replace("name:", ""));
                }
            }
        } catch (Exception e) {
        }
        return this;
    }

}
