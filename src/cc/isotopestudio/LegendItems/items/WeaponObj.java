package cc.isotopestudio.LegendItems.items;

import cc.isotopestudio.LegendItems.type.WeaponAttriType;
import cc.isotopestudio.LegendItems.util.S;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.HashSet;
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
        return new HashSet<>(attriList);
    }

    public ItemStack getItem() {
        return item;
    }

    public HashMap<WeaponAttriType, Double> getParameters() {
        return new HashMap<>(parameters);
    }

    public SuitObj getSuit() {
        return suit;
    }

    public void setSuit(SuitObj suit) {
        this.suit = suit;
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        lore.add(S.toBoldDarkAqua("套装 ") + suit.getName());

        lore.add(S.toBoldDarkAqua("穿上四件装备并使用武器:"));
        for (WeaponAttriType type : suit.getWeaponAttriListForWeapon())
            lore.add(type.getLore(suit.getWeaponParametersForWeapon().get(type)));
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    @Override
    public String toString() {
        return "WeaponObj [name=" + name + ", attriList=" + attriList + ", parameters=" + parameters + ", item="
                + item.getType() + ((suit != null) ? (", suit=" + suit.getName()) : "") + "]";
    }

}
