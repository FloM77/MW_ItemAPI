package mangoworld.item;

import javafx.animation.KeyValue;
import mangoworld.Main;
import mangoworld.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.List;

public class ItemBase {
    protected Material material;
    protected String name = "undefined";
    protected List<String> description;

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
        base.setItemMeta(im);
        base = Utils.setPersistentItemString(base, "custom", name);
        return base;
    }

    public void onRightClick(PlayerInteractEvent e)
    {

    }

    public Material getMaterial()
    {
        return material;
    }

    protected void createRecipe(HashMap<Character, Material> ingredients, String... shape)
    {
        NamespacedKey nsk = new NamespacedKey(Main.plugin, name.replaceAll("\\s+",""));
        ShapedRecipe recipe = new ShapedRecipe(nsk, Create(new ItemStack(
                getMaterial()
        )));

        recipe.shape(shape);
        for(char x : ingredients.keySet())
        {
            recipe.setIngredient(x, ingredients.get(x));
        }
        Main.plugin.getServer().addRecipe(recipe);
    }
}
