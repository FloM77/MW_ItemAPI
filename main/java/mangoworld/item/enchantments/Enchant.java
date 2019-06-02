package mangoworld.item.enchantments;

import mangoworld.Main;
import mangoworld.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Enchant implements Listener {
    protected String name = "undefined";
    protected Enchant(String name)
    {
        this.name = name;
        Main.plugin.getServer().getPluginManager().registerEvents(this, Main.plugin);
    }
}
