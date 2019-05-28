package mangoworld.item;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemFactory {
    public static void givePlayer(Player player, ItemBase ib, int amount)
    {
        ItemStack is = ib.Create(new ItemStack(ib.material));
        is.setAmount(amount);
        player.getInventory().addItem(is);
    }
}
