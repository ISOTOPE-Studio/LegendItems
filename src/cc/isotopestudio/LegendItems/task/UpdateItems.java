package cc.isotopestudio.LegendItems.task;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

import cc.isotopestudio.LegendItems.LegendItems;
import cc.isotopestudio.LegendItems.items.ArmorObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;

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
			weapons.put(key, new WeaponObj(name, material, damage, lore, null));
		}
		System.out.println(weapons);
	}

	public static String getPassword() {
		String a = "";
		for (int i = 0; i <= 5; i++) {
			switch ((int) (Math.random() * 5)) {
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
			}
		}
		return a;
	}
}
