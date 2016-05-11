package cc.isotopestudio.LegendItems.task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

import cc.isotopestudio.LegendItems.LegendItems;
import cc.isotopestudio.LegendItems.items.ArmorObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import cc.isotopestudio.LegendItems.type.WeaponAttriType;

import static cc.isotopestudio.LegendItems.items.Items.*;

public class UpdateItems extends BukkitRunnable {
	private final LegendItems plugin;

	public UpdateItems(LegendItems plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		weapons = new HashMap<String, WeaponObj>();
		armors = new HashMap<String, ArmorObj>();
		Set<String> keys = plugin.getWeaponsData().getKeys(false);
		for (String key : keys) {
			String name = plugin.getWeaponsData().getString(key + ".name");
			if (plugin.getWeaponsData().getString(key + ".password") == null) {
				plugin.getWeaponsData().set(key + ".password", getPassword());
			}
			plugin.saveWeaponsData();
			name += plugin.getWeaponsData().getString(key + ".password");
			Material material;
			if (plugin.getWeaponsData().isInt(key + ".material")) {
				material = Material.getMaterial(plugin.getWeaponsData().getInt(key + ".material"));
			} else {
				material = Material.getMaterial(plugin.getWeaponsData().getString(key + ".material"));
			}
			if (material == null) {
				plugin.getLogger().severe(plugin.getWeaponsData().getString(key + ".material", "(null)") + "是无效的物品");
				continue;
			}
			Short damage = (short) plugin.getWeaponsData().getInt(key + ".damage", 0);
			List<String> lore = plugin.getWeaponsData().getStringList(key + ".lore");
			Set<WeaponAttriType> attriList = new HashSet<WeaponAttriType>();
			HashMap<WeaponAttriType, Double> parameters = new HashMap<WeaponAttriType, Double>();
			for (String line : plugin.getWeaponsData().getStringList(key + ".attributions")) {
				String[] s = line.split(" ");
				Double value = 0.0;
				try {
					value = Double.parseDouble(s[1]);
				} catch (Exception e) {
					plugin.getLogger().severe(key + "中的" + line + "是无效行");
					continue;
				}

				WeaponAttriType type = null;
				try {
					type = WeaponAttriType.valueOf(s[0]);
				} catch (Exception e) {
					plugin.getLogger().severe(key + "中的" + s[0] + "是无效的武器属性");
					continue;
				}
				attriList.add(type);
				parameters.put(type, value);
			}
			weapons.put(key, new WeaponObj(name, material, damage, lore, attriList, parameters));
		}
		System.out.println(weapons);
		
		
		keys = plugin.getArmorsData().getKeys(false);
		for (String key : keys) {
			String name = plugin.getArmorsData().getString(key + ".name");
			if (plugin.getArmorsData().getString(key + ".password") == null) {
				plugin.getArmorsData().set(key + ".password", getPassword());
			}
			plugin.saveArmorsData();
			name += plugin.getArmorsData().getString(key + ".password");
			Material material;
			if (plugin.getArmorsData().isInt(key + ".material")) {
				material = Material.getMaterial(plugin.getArmorsData().getInt(key + ".material"));
			} else {
				material = Material.getMaterial(plugin.getArmorsData().getString(key + ".material"));
			}
			if (material == null) {
				plugin.getLogger().severe(plugin.getArmorsData().getString(key + ".material", "(null)") + "是无效的物品");
				continue;
			}
			Short damage = (short) plugin.getArmorsData().getInt(key + ".damage", 0);
			List<String> lore = plugin.getArmorsData().getStringList(key + ".lore");
			Set<ArmorAttriType> attriList = new HashSet<ArmorAttriType>();
			HashMap<ArmorAttriType, Double> parameters = new HashMap<ArmorAttriType, Double>();
			for (String line : plugin.getArmorsData().getStringList(key + ".attributions")) {
				String[] s = line.split(" ");
				Double value = 0.0;
				try {
					value = Double.parseDouble(s[1]);
				} catch (Exception e) {
					plugin.getLogger().severe(key + "中的" + line + "是无效行");
					continue;
				}
				ArmorAttriType type = null;
				try {
					type = ArmorAttriType.valueOf(s[0]);
				} catch (Exception e) {
					plugin.getLogger().severe(key + "中的" + s[0] + "是无效的装备属性");
					continue;
				}
				attriList.add(type);
				parameters.put(type, value);
			}
			armors.put(key, new ArmorObj(name, material, damage, lore, attriList, parameters));
		}
		System.out.println(armors);
	}

	public static String getPassword() {
		String a = "";
		for (int i = 0; i <= 5; i++) {
			switch ((int) (Math.random() * 7)) {
			case (0): {
				a += "§f";
				break;
			}
			case (1): {
				a += "§1";
				break;
			}
			case (2): {
				a += "§2";
				break;
			}
			case (3): {
				a += "§3";
				break;
			}
			case (4): {
				a += "§4";
				break;
			}
			case (5): {
				a += "§5";
				break;
			}
			case (6): {
				a += "§6";
				break;
			}
			}
		}
		return a;
	}
}
