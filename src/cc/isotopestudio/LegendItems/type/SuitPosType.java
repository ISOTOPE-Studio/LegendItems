package cc.isotopestudio.LegendItems.type;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum SuitPosType {

    HELMET,

    CHESTPLATE,

    LEGGINGS,

    BOOTS,

    WEAPON;

    public static SuitPosType getTypebyItem(ItemStack item) {
        if (item.getType() == Material.DIAMOND_HELMET || item.getType() == Material.GOLD_HELMET || item.getType() == Material.CHAINMAIL_HELMET || item.getType() == Material.IRON_HELMET || item.getType() == Material.LEATHER_HELMET)
            return HELMET;
        if (item.getType() == Material.DIAMOND_CHESTPLATE || item.getType() == Material.GOLD_CHESTPLATE || item.getType() == Material.CHAINMAIL_CHESTPLATE || item.getType() == Material.IRON_CHESTPLATE || item.getType() == Material.LEATHER_CHESTPLATE)
            return CHESTPLATE;
        if (item.getType() == Material.DIAMOND_LEGGINGS || item.getType() == Material.GOLD_LEGGINGS || item.getType() == Material.CHAINMAIL_LEGGINGS || item.getType() == Material.IRON_LEGGINGS || item.getType() == Material.LEATHER_LEGGINGS)
            return LEGGINGS;
        if (item.getType() == Material.DIAMOND_BOOTS || item.getType() == Material.GOLD_BOOTS || item.getType() == Material.CHAINMAIL_BOOTS || item.getType() == Material.IRON_BOOTS || item.getType() == Material.LEATHER_BOOTS)
            return BOOTS;
        return WEAPON;
    }
}
