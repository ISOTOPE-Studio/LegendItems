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

	final String name;
	final Set<ArmorAttriType> attriList;
	final HashMap<ArmorAttriType, Double> parameters;
	final ItemStack item;
	final public static String header = S.toGray("——————— ") + S.toBoldRed("【传奇大陆传奇装备】") + S.toGray(" ———————");

	public ArmorObj(String name, Material material, short damage, List<String> lore, Set<ArmorAttriType> attriList,
			HashMap<ArmorAttriType, Double> parameters) {
		this.name = name;
		this.attriList = attriList;
		this.parameters = parameters;
		lore.add(header);
		for (ArmorAttriType type : attriList) {
			if (type.isPercentile()) {
				lore.add(type.toString() + " " + parameters.get(type) + "%");
			} else {
				lore.add(type.toString() + " " + parameters.get(type));
			}
		}
		lore.add(header);
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

	@Override
	public String toString() {
		return "ArmorObj [name=" + name + ", attriList=" + attriList + ", item=" + item + "]";
	}

}
