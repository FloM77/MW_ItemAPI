package mangoworld.item.enchantments;

import mangoworld.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EnchantFactory {
    public static void addEnchant(ItemStack toEnchant, Enchant enchant, int level)
    {
        toEnchant = Utils.setPersistentItemString(toEnchant, enchant.name, ""+level);
        ItemMeta im = toEnchant.getItemMeta();
        List<String> lore = im.getLore();
        if(lore==null)lore = new ArrayList<String>();
        lore.add(enchant.name + ": " + level);
        im.setLore(lore);
        toEnchant.setItemMeta(im);
    }

    public static void removeEnchant()
    {

    }

    public static boolean hasEnchant(ItemStack enchanted, Enchant enchant)
    {
        if(Utils.getPersistentItemString(enchanted, enchant.name)!=null) return true;
        return false;
    }
}
