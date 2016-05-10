package cc.isotopestudio.LegendItems.items;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cc.isotopestudio.LegendItems.type.WeaponAttriType;

public class WeaponObj {

	final String name;
	final List<WeaponAttriType> attriList;
	final ItemStack item;

	public WeaponObj(String name, Material material, short damage, List<String> lore, List<WeaponAttriType> attriList) {
		this.name = name;
		this.attriList = attriList;
		ItemStack item = new ItemStack(material, damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		meta.setLore(lore);
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public List<WeaponAttriType> getAttriList() {
		return attriList;
	}

	public ItemStack getItem() {
		return item;
	}

}
