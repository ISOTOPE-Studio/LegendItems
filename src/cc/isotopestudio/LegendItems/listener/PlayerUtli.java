package cc.isotopestudio.LegendItems.listener;

import cc.isotopestudio.LegendItems.items.ArmorItem;
import cc.isotopestudio.LegendItems.items.Items;
import cc.isotopestudio.LegendItems.items.SuitObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import cc.isotopestudio.LegendItems.type.SuitPosType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class PlayerUtli {

    public static Set<ArmorItem> getArmorItems(Player player) {
        Set<ArmorItem> result = new HashSet<>();
        for (ItemStack armor : player.getInventory().getArmorContents()) {
            if (armor == null) continue;
            if (!armor.getItemMeta().hasDisplayName()) continue;
            for (ArmorItem armorItem : Items.armors.values()) {
                System.out.println(armor.getItemMeta().getDisplayName() + ":" + armorItem.getName());
                if (armor.getItemMeta().getDisplayName().equals(armorItem.getName())) {
                    result.add(armorItem);
                }
            }
        }
        return result;
    }

    @Nullable
    public static WeaponObj getWeapon(Player player) {
        ItemStack item = player.getItemInHand();
        if (item == null || item.getType() == Material.AIR || !item.getItemMeta().hasDisplayName()) {
            return null;
        }
        for (WeaponObj weaponItem : Items.weapons.values()) {
            if (item.getItemMeta().getDisplayName().equals(weaponItem.getName())) {
                return weaponItem;
            }
        }
        return null;
    }

    @Nullable
    public static SuitObj getSuits(Player player) {
        Set<ArmorItem> armors = getArmorItems(player);
        if (armors.size() != 4) return null;
        for (SuitObj suit : Items.suits.values()) {
            
            SuitPosType.getTypebyItem()
        }
    }

}
