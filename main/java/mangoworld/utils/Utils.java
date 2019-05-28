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
        NamespacedKey nsk = new NamespacedKey(Main.plugin, "custom");
        String value = pdc.get(nsk, PersistentDataType.STRING);
        return value;
    }
}
