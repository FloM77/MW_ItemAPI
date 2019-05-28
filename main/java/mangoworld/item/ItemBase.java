package mangoworld.item;

import mangoworld.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.List;

public class ItemBase {
    protected Material material;
    protected String name = "undefined";
    protected List<String> description;
    protected PersistentDataContainer pdc;

    public static HashMap<String, ItemBase> All = new HashMap<String, ItemBase>();

    protected ItemBase(String name, List<String> description, Material material)
    {
        this.name = name;
        this.description = description;
        this.material = material;
        All.put(name, this);
    }

    public ItemStack Create(ItemStack base)
    {
        ItemMeta im = base.getItemMeta();
        im.setDisplayName(name);
        im.setLore(description);
        pdc = im.getPersistentDataContainer();
        pdc.set(
                new NamespacedKey(Main.plugin, "custom"),
                PersistentDataType.STRING,
                name
        );
        base.setItemMeta(im);
        return base;
    }

    protected void onRightClick(PlayerInteractEvent e)
    {

    }
}
