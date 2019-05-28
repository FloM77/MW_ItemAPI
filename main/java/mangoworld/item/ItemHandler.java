package mangoworld.item;

import mangoworld.Main;
import mangoworld.utils.Utils;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemHandler implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e)
    {
        if(
                e.getHand().equals(EquipmentSlot.HAND) &&
                (e.getAction().equals(Action.RIGHT_CLICK_AIR) | e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) &&
                e.getItem()!=null)
        {
            String custom;
            if((custom = Utils.getPersistentItemString(e.getItem(), "custom")) != null)
            {
                ItemBase.All.get(custom).onRightClick(e);
            }
        }
    }
}
