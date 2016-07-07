package cc.isotopestudio.LegendItems.items;

import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import cc.isotopestudio.LegendItems.type.WeaponAttriType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaterialObj {

    private final String name;
    private final Set<ArmorAttriType> attriListForArmor;
    private final HashMap<ArmorAttriType, Double> parametersForArmor;
    private final Set<WeaponAttriType> attriListForWeapon;
    private final HashMap<WeaponAttriType, Double> parametersForWeapon;
    private final ItemStack item;

    public MaterialObj(String name, Material material, short damage, List<String> lore,
                       Set<ArmorAttriType> attriListForArmor, HashMap<ArmorAttriType, Double> parametersForArmor,
                       Set<WeaponAttriType> attriListForWeapon, HashMap<WeaponAttriType, Double> parametersForWeapon) {
        this.name = name;
        this.attriListForArmor = attriListForArmor;
        this.parametersForArmor = parametersForArmor;
        this.attriListForWeapon = attriListForWeapon;
        this.parametersForWeapon = parametersForWeapon;
        for (ArmorAttriType type : attriListForArmor)
            lore.add(type.getLore(parametersForArmor.get(type)));
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

    public Set<ArmorAttriType> getAttriListForArmor() {
        return new HashSet<>(attriListForArmor);
    }

    public HashMap<ArmorAttriType, Double> getParametersForArmor() {
        return new HashMap<>(parametersForArmor);
    }

    public Set<WeaponAttriType> getAttriListForWeapon() {
        return attriListForWeapon;
    }

    public HashMap<WeaponAttriType, Double> getParametersForWeapon() {
        return parametersForWeapon;
    }

    public ItemStack getItem() {
        return item;
    }

    @Override
    public String toString() {
        String sb = "MaterialObj{" + "name='" + name + '\'' +
                ", attriListForArmor=" + attriListForArmor +
                ", parametersForArmor=" + parametersForArmor +
                ", attriListForWeapon=" + attriListForWeapon +
                ", parametersForWeapon=" + parametersForWeapon +
                ", item=" + item +
                '}';
        return sb;
    }
}
