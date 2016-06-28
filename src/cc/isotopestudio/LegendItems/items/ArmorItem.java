package cc.isotopestudio.LegendItems.items;

import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import cc.isotopestudio.LegendItems.utli.S;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ArmorItem {

    private final String name;
    private final Set<ArmorAttriType> attriList;
    private final HashMap<ArmorAttriType, Double> parameters;
    private final ItemStack item;
    private SuitObj suit = null;

    public ArmorItem(String name, Material material, short damage, List<String> lore, Set<ArmorAttriType> attriList,
                     HashMap<ArmorAttriType, Double> parameters) {
        this.name = name;
        this.attriList = attriList;
        this.parameters = parameters;
        for (ArmorAttriType type : attriList)
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

    public Set<ArmorAttriType> getAttriList() {
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
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        lore.add(S.toBoldDarkAqua("套装 ") + suit.getName());

        lore.add(S.toBoldDarkAqua("穿上四件装备:"));
        for (ArmorAttriType type : suit.getArmorAttriList()) {
            meta.setLore(lore);
        }
        lore.add(S.toBoldDarkAqua("使用武器:"));
        for (ArmorAttriType type : suit.getWeaponAttriList())
            lore.add(type.getLore(suit.getWeaponParameters().get(type)));
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    @Override
    public String toString() {
        return "ArmorItem [name=" + name + ", attriList=" + attriList + ", parameters=" + parameters + ", item="
                + item.getType() + ((suit != null) ? (", suit=" + suit.getName()) : "" + "]");
    }

}
