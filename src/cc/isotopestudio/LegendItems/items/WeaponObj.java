package cc.isotopestudio.LegendItems.items;

import cc.isotopestudio.LegendItems.type.WeaponAttriType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class WeaponObj {

    private final String name;
    private final Set<WeaponAttriType> attriList;
    private final HashMap<WeaponAttriType, Double> parameters;
    private final ItemStack item;
    private SuitObj suit;

    public WeaponObj(String name, Material material, short damage, List<String> lore, Set<WeaponAttriType> attriList,
                     HashMap<WeaponAttriType, Double> parameters) {
        this.name = name;
        this.attriList = attriList;
        this.parameters = parameters;
        for (WeaponAttriType type : attriList)
            lore.add(type.getLore(parameters.get(type)));
        ItemStack item = new ItemStack(material, 1, damage);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public Set<WeaponAttriType> getAttriList() {
        return attriList;
    }

    public ItemStack getItem() {
        return item;
    }

    public SuitObj getSuit() {
        return suit;
    }

    public void setSuit(SuitObj suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "WeaponObj [name=" + name + ", attriList=" + attriList + ", parameters=" + parameters + ", item="
                + item.getType() + ((suit != null) ? (", suit=" + suit.getName()) : "") + "]";
    }

}
