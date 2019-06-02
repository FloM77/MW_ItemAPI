package mangoworld.item.items;

import mangoworld.item.ItemBase;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class ItemJumpStick extends ItemBase {
    protected ItemJumpStick() {
        super("Jump Stick", new ArrayList<String>() {{ add("It's very light"); }}, Material.STICK);
    }

    public static final ItemJumpStick item = new ItemJumpStick();

    @Override
    public void onRightClick(PlayerInteractEvent e) {
        e.getPlayer().setVelocity(e.getPlayer().getVelocity().add(e.getPlayer().getLocation().getDirection().multiply(1.5)));
    }
}
