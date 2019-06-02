package mangoworld.item.items;

import mangoworld.item.ItemBase;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemBlessingShard extends ItemBase {
    protected ItemBlessingShard() {
        super("Blessing Shard", new ArrayList<String>() {{ add("Infused with powerful magic"); }}, Material.PRISMARINE_SHARD);
        createRecipe(
                new HashMap<Character, Material>() {{
                    put('d', Material.DIAMOND);
                    put('g', Material.GOLD_INGOT);
                    put('r', Material.REDSTONE);
                }}
                ,
                "ddd",
                "ggg",
                "rrr"
        );
    }
    public static final ItemBlessingShard item = new ItemBlessingShard();
}
