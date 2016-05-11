package cc.isotopestudio.LegendItems.items;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cc.isotopestudio.LegendItems.type.WeaponAttriType;

public class WeaponObj {

	final String name;
	final Set<WeaponAttriType> attriList;
	final HashMap<WeaponAttriType, Double> parameters;
	final ItemStack item;

	public WeaponObj(String name, Material material, short damage, List<String> lore, Set<WeaponAttriType> attriList,
			HashMap<WeaponAttriType, Double> parameters) {
		this.name = name;
		this.attriList = attriList;
		this.parameters = parameters;
		for (WeaponAttriType type : attriList) {
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

	public Set<WeaponAttriType> getAttriList() {
		return attriList;
	}

	public ItemStack getItem() {
		return item;
	}

	@Override
	public String toString() {
		return "WeaponObj [name=" + name + ", attriList=" + attriList + ", item=" + item.getType() + "]";
	}

}
