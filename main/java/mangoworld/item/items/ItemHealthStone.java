package mangoworld.item.items;

import mangoworld.item.ItemBase;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class ItemHealthStone extends ItemBase {
    protected ItemHealthStone() {
        super("Health Stone", new ArrayList<String>() {{add("Restores 2 health");}}, Material.REDSTONE);
    }

    public static final ItemHealthStone item = new ItemHealthStone();

    @Override
    public void onRightClick(PlayerInteractEvent e) {
        double newVal = e.getPlayer().getHealth() + 4d;
        e.getPlayer().setHealth(
                (newVal > e.getPlayer().getHealthScale()) ? e.getPlayer().getHealthScale() : newVal
        );
        e.getItem().setAmount(e.getItem().getAmount()-1);
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) e.setCancelled(true);
    }
}
