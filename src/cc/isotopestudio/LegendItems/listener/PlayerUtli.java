package cc.isotopestudio.LegendItems.listener;

import cc.isotopestudio.LegendItems.items.Items;
import cc.isotopestudio.LegendItems.items.ArmorItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class PlayerUtli {

    public static Set<ArmorItem> getArmorItems(Player player) {
        Set<ArmorItem> result = new HashSet<>();
        for (ItemStack armor : player.getInventory().getArmorContents()) {
            if (armor == null) continue;
            if (!armor.getItemMeta().hasDisplayName()) continue;
            for (ArmorItem armorItem : Items.armors.values()) {
                if (armor.getItemMeta().getDisplayName().equals(armorItem.getName())) {
                    result.add(armorItem);
                }
            }
        }
        return result;
    }


}
