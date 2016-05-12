package cc.isotopestudio.LegendItems.items;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import cc.isotopestudio.LegendItems.utli.S;

public class ArmorObj {

	private final String name;
	private final Set<ArmorAttriType> attriList;
	private final HashMap<ArmorAttriType, Double> parameters;
	private final ItemStack item;
	private SuitObj suit;

	public ArmorObj(String name, Material material, short damage, List<String> lore, Set<ArmorAttriType> attriList,
			HashMap<ArmorAttriType, Double> parameters) {
		this.name = name;
		this.attriList = attriList;
		this.parameters = parameters;
		for (ArmorAttriType type : attriList) {
			if (type.isPercentile()) {
				lore.add(type.toString() + " " + parameters.get(type) + "%");
			} else {
				lore.add(type.toString() + " " + parameters.get(type));
			}
		}
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
		lore.add(S.toBoldDarkAqua("匹配套装 ") + suit.getName());

		lore.add(S.toBoldDarkAqua("穿上四件装备:"));
		for (ArmorAttriType type : suit.getArmorAttriList()) {
			if (type.isPercentile()) {
				lore.add(type.toString() + " " + suit.getArmorParameters().get(type) + "%");
			} else {
				lore.add(type.toString() + " " + suit.getArmorParameters().get(type));
			}
		}
		lore.add(S.toBoldDarkAqua("使用武器:"));
		for (ArmorAttriType type : suit.getWeaponAttriList()) {
			if (type.isPercentile()) {
				lore.add(type.toString() + " " + suit.getWeaponParameters().get(type) + "%");
			} else {
				lore.add(type.toString() + " " + suit.getWeaponParameters().get(type));
			}
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
	}

	@Override
	public String toString() {
		return "ArmorObj [name=" + name + ", attriList=" + attriList + ", parameters=" + parameters + ", item="
				+ item.getType() + suit != null ? (", suit=" + suit.getName()) : "" + "]";
	}

}
