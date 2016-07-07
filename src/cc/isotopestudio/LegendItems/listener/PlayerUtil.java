package cc.isotopestudio.LegendItems.listener;

import cc.isotopestudio.LegendItems.items.ArmorObj;
import cc.isotopestudio.LegendItems.items.Items;
import cc.isotopestudio.LegendItems.items.SuitObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class PlayerUtil {

    public static Set<ArmorObj> getArmorItems(Player player) {
        Set<ArmorObj> result = new HashSet<>();
        if (player.getInventory().getArmorContents() != null)
            for (ItemStack armor : player.getInventory().getArmorContents()) {
                if (armor == null || !armor.hasItemMeta()) continue;
                if (!armor.getItemMeta().hasDisplayName()) continue;
                for (ArmorObj armorObj : Items.armors.values()) {
                    if (armor.getItemMeta().getDisplayName().equals(armorObj.getName())) {
                        result.add(armorObj);
                    }
                }
            }
        return result;
    }

    @Nullable
    public static WeaponObj getWeapon(Player player) {
        ItemStack item = player.getItemInHand();
        if (item == null || item.getType() == Material.AIR
                || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
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
        Set<ArmorObj> armors = getArmorItems(player);
        if (armors.size() != 4) return null;
        for (SuitObj suit : Items.suits.values()) {
            if (armors.contains(suit.getHelmet()) && armors.contains(suit.getChestplate())
                    && armors.contains(suit.getLeggings()) && armors.contains(suit.getBoots())) {
                return suit;
            }
        }
        return null;
    }

    public static boolean isSuitHasWeapon(Player player) {
        SuitObj suit = getSuits(player);
        return suit != null && suit.getWeapon().equals(getWeapon(player));
    }

}
