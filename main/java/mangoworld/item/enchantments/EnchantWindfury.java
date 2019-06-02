package mangoworld.item.enchantments;

import mangoworld.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnchantWindfury extends Enchant{
    private EnchantWindfury() {
        super("Windfury");
    }

    public final static EnchantWindfury enchant = new EnchantWindfury();

    @EventHandler
    public void onMine(BlockBreakEvent e)
    {
        ItemStack item = e.getPlayer().getInventory().getItemInMainHand();
        if(item!=null)
        if(EnchantFactory.hasEnchant(item, this))
        {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
                    20 * Integer.parseInt(Utils.getPersistentItemString(item, name))
                    , 1), true);
        }
    }
}
