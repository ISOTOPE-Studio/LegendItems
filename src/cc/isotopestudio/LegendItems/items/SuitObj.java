package cc.isotopestudio.LegendItems.items;

import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import cc.isotopestudio.LegendItems.type.SuitPosType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SuitObj {

    private final String name;
    private ArmorItem helmet;
    private ArmorItem chestplate;
    private ArmorItem leggings;
    private ArmorItem boots;
    private WeaponObj weapon;
    private final Set<ArmorAttriType> ArmorAttriList;
    private final HashMap<ArmorAttriType, Double> ArmorParameters;
    private final Set<ArmorAttriType> WeaponAttriList;
    private final HashMap<ArmorAttriType, Double> WeaponParameters;

    public SuitObj(String name, Set<ArmorAttriType> armorAttriList, HashMap<ArmorAttriType, Double> armorParameters,
                   Set<ArmorAttriType> weaponAttriList, HashMap<ArmorAttriType, Double> weaponParameters) {
        this.name = name;
        ArmorAttriList = armorAttriList;
        ArmorParameters = armorParameters;
        WeaponAttriList = weaponAttriList;
        WeaponParameters = weaponParameters;
    }

    public void setWeapon(WeaponObj weapon) {
        this.weapon = weapon;
    }

    public void setEquip(SuitPosType type, ArmorItem armor) {
        switch (type) {
            case BOOTS: {
                this.boots = armor;
                break;
            }
            case CHESTPLATE: {
                this.chestplate = armor;
                break;
            }
            case HELMET: {
                this.helmet = armor;
                break;
            }
            case LEGGINGS: {
                this.leggings = armor;
                break;
            }
            case WEAPON:
                break;
            default:
                break;
        }
    }

    public String getName() {
        return name;
    }

    public ArmorItem getHelmet() {
        return helmet;
    }

    public ArmorItem getChestplate() {
        return chestplate;
    }

    public ArmorItem getLeggings() {
        return leggings;
    }

    public ArmorItem getBoots() {
        return boots;
    }

    public WeaponObj getWeapon() {
        return weapon;
    }

    public ItemStack[] getItems() {
        Set<ItemStack> items = new HashSet<>();
        if (helmet != null) {
            items.add(helmet.getItem());
        }
        if (chestplate != null) {
            items.add(chestplate.getItem());
        }
        if (leggings != null) {
            items.add(leggings.getItem());
        }
        if (boots != null) {
            items.add(boots.getItem());
        }
        if (weapon != null) {
            items.add(weapon.getItem());
        }
        return items.toArray(new ItemStack[]{});
    }

    public Set<ArmorAttriType> getArmorAttriList() {
        return ArmorAttriList;
    }

    public HashMap<ArmorAttriType, Double> getArmorParameters() {
        return ArmorParameters;
    }

    public Set<ArmorAttriType> getWeaponAttriList() {
        return WeaponAttriList;
    }

    public HashMap<ArmorAttriType, Double> getWeaponParameters() {
        return WeaponParameters;
    }

    @Override
    public String toString() {
        return "SuitObj [name=" + name + ", helmet=" + helmet.getName() + ", chestplate=" + chestplate.getName()
                + ", leggings=" + leggings.getName() + ", boots=" + boots.getName() + ", weapon=" + weapon.getName()
                + "]";
    }

}
