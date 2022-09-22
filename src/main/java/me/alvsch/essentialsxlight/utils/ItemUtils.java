package me.alvsch.essentialsxlight.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemUtils {

    public static ItemStack createItem(Material material, String name, int amount, String... lore) {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));

        return item;
    }

    public static void rename(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        meta.setDisplayName(Utils.color(name));

        item.setItemMeta(meta);

    }

    public static void updateLore(ItemStack item, String... lore) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;

        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);

    }
    public static void setLore(ItemStack item, int line, String new_lore) {
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        List<String> lore = meta.getLore();
        assert lore != null;

        try {
            lore.set(line, Utils.color(new_lore));
        } catch (Exception ignored) {
        }

        item.setItemMeta(meta);

    }

}
