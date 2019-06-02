package mangoworld.item.items;

import mangoworld.Main;
import mangoworld.item.ItemBase;
import org.bukkit.Material;
import org.bukkit.block.EnchantingTable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemBlessingTable extends ItemBase implements Listener {

    protected ItemBlessingTable() {
        super("Blessing Table", new ArrayList<String>() {{ add("Used to bless items");add("Blessings are strong enchantments"); }}, Material.ENCHANTING_TABLE);
        createRecipe(
                new HashMap<Character, Material>() {{
                    put('d', Material.DIAMOND);
                    put('e', Material.ENCHANTING_TABLE);
                }}
                ,
                "ddd",
                "ded",
                "ddd"
        );
        Main.plugin.getServer().getPluginManager().registerEvents(this, Main.plugin);
    }

    public static final ItemBlessingTable item = new ItemBlessingTable();

    @EventHandler
    public void onBreak(BlockBreakEvent e)
    {
        if(e.getBlock().getType().equals(Material.ENCHANTING_TABLE))
        {
            EnchantingTable et = (EnchantingTable) e.getBlock().getState();
            if(et.getCustomName().equals(name)) {
                e.setDropItems(false);
                e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), item.Create(new ItemStack(
                        getMaterial()
                )));
            }
        }
    }
}
