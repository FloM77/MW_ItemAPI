package mangoworld;

import mangoworld.item.ItemFactory;
import mangoworld.item.ItemHandler;
import mangoworld.item.enchantments.EnchantFactory;
import mangoworld.item.enchantments.EnchantWindfury;
import mangoworld.item.items.ItemBlessingShard;
import mangoworld.item.items.ItemBlessingTable;
import mangoworld.item.items.ItemHealthStone;
import mangoworld.item.items.ItemJumpStick;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        getLogger().info("MangoWorld initialized!");
        plugin = this;

        System.out.println("Init recipe for:" + ItemBlessingShard.item);

        getServer().getPluginManager().registerEvents(new ItemHandler(), this);
        getServer().getPluginManager().registerEvents(this, this);
    }
    @Override
    public void onDisable() {
        getLogger().info("MangoWorld safe shutdown!");
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e)
    {
        /*
        ItemFactory.givePlayer(e.getPlayer(), ItemHealthStone.item, 2);
        ItemFactory.givePlayer(e.getPlayer(), ItemJumpStick.item, 1);

        ItemStack ironPick = new ItemStack(Material.IRON_PICKAXE);
        EnchantFactory.addEnchant(ironPick, EnchantWindfury.enchant, 2);
        e.getPlayer().getInventory().addItem(ironPick);
        */
        //ItemFactory.givePlayer(e.getPlayer(), ItemBlessingTable.item,1);
    }
}