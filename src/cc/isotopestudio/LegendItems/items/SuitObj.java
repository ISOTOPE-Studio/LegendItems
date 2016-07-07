package cc.isotopestudio.LegendItems.items;

import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import cc.isotopestudio.LegendItems.type.SuitPosType;
import cc.isotopestudio.LegendItems.type.WeaponAttriType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SuitObj {

    private final String name;
    private ArmorObj helmet;
    private ArmorObj chestplate;
    private ArmorObj leggings;
    private ArmorObj boots;
    private WeaponObj weapon;
    private final Set<ArmorAttriType> ArmorAttriList;
    private final HashMap<ArmorAttriType, Double> ArmorParameters;
    private final Set<ArmorAttriType> WeaponAttriListForArmor;
    private final HashMap<ArmorAttriType, Double> WeaponParametersForArmor;
    private final Set<WeaponAttriType> WeaponAttriListForWeapon;
    private final HashMap<WeaponAttriType, Double> WeaponParametersForWeapon;

    public SuitObj(String name, Set<ArmorAttriType> armorAttriList, HashMap<ArmorAttriType, Double> armorParameters,
                   Set<ArmorAttriType> weaponAttriListForArmor, HashMap<ArmorAttriType, Double> weaponParametersForArmor,
                   Set<WeaponAttriType> weaponAttriListForWeapon, HashMap<WeaponAttriType, Double> weaponParametersForWeapon) {
        this.name = name;
        this.ArmorAttriList = armorAttriList;
        this.ArmorParameters = armorParameters;
        this.WeaponAttriListForArmor = weaponAttriListForArmor;
        this.WeaponParametersForArmor = weaponParametersForArmor;
        this.WeaponAttriListForWeapon = weaponAttriListForWeapon;
        this.WeaponParametersForWeapon = weaponParametersForWeapon;
    }

    public void setWeapon(WeaponObj weapon) {
        this.weapon = weapon;
    }

    public void setEquip(SuitPosType type, ArmorObj armor) {
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
        }
    }

    public String getName() {
        return name;
    }

    public ArmorObj getHelmet() {
        return helmet;
    }

    public ArmorObj getChestplate() {
        return chestplate;
    }

    public ArmorObj getLeggings() {
        return leggings;
    }

    public ArmorObj getBoots() {
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
        return new HashSet<>(ArmorAttriList);
    }

    public HashMap<ArmorAttriType, Double> getArmorParameters() {
        return new HashMap<>(ArmorParameters);
    }

    public Set<ArmorAttriType> getWeaponAttriListForArmor() {
        return new HashSet<>(WeaponAttriListForArmor);
    }

    public HashMap<ArmorAttriType, Double> getWeaponParametersForArmor() {
        return new HashMap<>(WeaponParametersForArmor);
    }

    public Set<WeaponAttriType> getWeaponAttriListForWeapon() {
        return new HashSet<>(WeaponAttriListForWeapon);
    }

    public HashMap<WeaponAttriType, Double> getWeaponParametersForWeapon() {
        return new HashMap<>(WeaponParametersForWeapon);
    }

    @Override
    public String toString() {
        return "SuitObj{" + "name='" + name + '\'' +
                ", helmet=" + helmet +
                ", chestplate=" + chestplate +
                ", leggings=" + leggings +
                ", boots=" + boots +
                ", weapon=" + weapon +
                ", ArmorAttriList=" + ArmorAttriList +
                ", ArmorParameters=" + ArmorParameters +
                ", WeaponAttriListForArmor=" + WeaponAttriListForArmor +
                ", WeaponParametersForArmor=" + WeaponParametersForArmor +
                ", WeaponAttriListForWeapon=" + WeaponAttriListForWeapon +
                ", WeaponParametersForWeapon=" + WeaponParametersForWeapon +
                '}';
    }
}
