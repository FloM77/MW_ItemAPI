package mangoworld;

import mangoworld.item.ItemFactory;
import mangoworld.item.ItemHandler;
import mangoworld.item.items.itemHealthStone;
import mangoworld.item.items.itemJumpStick;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        getLogger().info("MangoWorld initialized!");
        plugin = this;

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
        ItemFactory.givePlayer(e.getPlayer(), itemHealthStone.item, 2);
        ItemFactory.givePlayer(e.getPlayer(), itemJumpStick.item, 1);
    }
}