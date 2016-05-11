package cc.isotopestudio.LegendItems.items;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.LegendItems.type.SuitPosType;

public class SuitObj {

	private final String name;
	private ArmorObj helmet;
	private ArmorObj chestplate;
	private ArmorObj leggings;
	private ArmorObj boots;
	private WeaponObj weapon;

	public SuitObj(String name) {
		this.name = name;
	}

	public void setHelmet(ArmorObj helmet) {
		this.helmet = helmet;
	}

	public void setChestplate(ArmorObj chestplate) {
		this.chestplate = chestplate;
	}

	public void setLeggings(ArmorObj leggings) {
		this.leggings = leggings;
	}

	public void setBoots(ArmorObj boots) {
		this.boots = boots;
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
		default:
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
		Set<ItemStack> items = new HashSet<ItemStack>();
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
		return (ItemStack[]) items.toArray(new ItemStack[] {});
	}

	@Override
	public String toString() {
		return "SuitObj [name=" + name + ", helmet=" + helmet.getName() + ", chestplate=" + chestplate.getName()
				+ ", leggings=" + leggings.getName() + ", boots=" + boots.getName() + ", weapon=" + weapon.getName()
				+ "]";
	}

}
