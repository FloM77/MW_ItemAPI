package mangoworld.item.items;

import mangoworld.item.ItemBase;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class itemJumpStick extends ItemBase {
    protected itemJumpStick() {
        super("Jump Stick", new ArrayList<String>() {{ add("It's very light"); }}, Material.STICK);
    }

    public static final itemJumpStick item = new itemJumpStick();

    @Override
    protected void onRightClick(PlayerInteractEvent e) {
        e.getPlayer().setVelocity(e.getPlayer().getVelocity().add(e.getPlayer().getLocation().getDirection().multiply(1.5)));
    }
}
