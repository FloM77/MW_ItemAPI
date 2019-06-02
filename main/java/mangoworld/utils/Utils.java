package mangoworld.utils;

import mangoworld.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Utils {
    public static String getPersistentItemString(ItemStack is, String key)
    {
        ItemMeta im = is.getItemMeta();
        PersistentDataContainer pdc = im.getPersistentDataContainer();
        NamespacedKey nsk = new NamespacedKey(Main.plugin, key);
        String value = pdc.get(nsk, PersistentDataType.STRING);
        return value;
    }

    public static ItemStack setPersistentItemString(ItemStack base, String key, String value)
    {
        ItemMeta im = base.getItemMeta();
        PersistentDataContainer pdc = im.getPersistentDataContainer();
        pdc.set(
                new NamespacedKey(Main.plugin, key),
                PersistentDataType.STRING,
                value
        );
        base.setItemMeta(im);
        return base;
    }
}
