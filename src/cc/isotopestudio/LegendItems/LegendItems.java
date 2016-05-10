package cc.isotopestudio.LegendItems;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cc.isotopestudio.LegendItems.task.UpdateItems;

public class LegendItems extends JavaPlugin {

	public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
			.append("传奇物品").append("]").append(ChatColor.GREEN).toString();
	public static final String pluginName = "LegendItems";

	public void createFile(String name) {
		File file = new File(getDataFolder(), name + ".yml");
		if (!file.exists()) {
			saveDefaultConfig();
		}

	}

	@Override
	public void onEnable() {
		createFile("config");
		getLogger().info("加载装备文件！");
		try {
			getArmorsData().save(armorsDataFile);
		} catch (IOException e) {
			getLogger().info("装备文件出错！");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		getLogger().info("加载武器文件！");
		try {
			getWeaponsData().save(weaponsDataFile);
		} catch (IOException e) {
			getLogger().info("武器文件出错！");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		PluginManager pm = this.getServer().getPluginManager();
		// pm.registerEvents(new ConnoListener(), this);

		// this.getCommand("ConnoisseurAdmin").setExecutor(/*new
		// CommandCadmin()*/);
		new UpdateItems(this).runTask(this);
		getLogger().info(pluginName + "成功加载!");
		getLogger().info(pluginName + "由ISOTOPE Studio制作!");
		getLogger().info("http://isotopestudio.cc");
	}

	private File weaponsDataFile = null;
	private FileConfiguration weaponsData = null;

	public void reloadWeaponsData() {
		if (weaponsDataFile == null) {
			this.saveResource("weapons.yml", false);
		}
		weaponsDataFile = new File(getDataFolder(), "weapons.yml");
		weaponsData = YamlConfiguration.loadConfiguration(weaponsDataFile);
	}

	public FileConfiguration getWeaponsData() {
		if (weaponsData == null) {
			reloadWeaponsData();
		}
		return weaponsData;
	}

	public void saveWeaponsData() {
		if (weaponsData == null || weaponsDataFile == null) {
			return;
		}
		try {
			getWeaponsData().save(weaponsDataFile);
		} catch (IOException ex) {
			getLogger().info("武器文件保存失败！");
		}
	}

	private File armorsDataFile = null;
	private FileConfiguration armorsData = null;

	public void reloadArmorsData() {
		if (armorsDataFile == null) {
			this.saveResource("armors.yml", false);
		}
		armorsDataFile = new File(getDataFolder(), "armors.yml");
		armorsData = YamlConfiguration.loadConfiguration(armorsDataFile);
	}

	public FileConfiguration getArmorsData() {
		if (armorsData == null) {
			reloadArmorsData();
		}
		return armorsData;
	}

	public void saveArmorsData() {
		if (armorsData == null || armorsDataFile == null) {
			return;
		}
		try {
			getArmorsData().save(armorsDataFile);
		} catch (IOException ex) {
			getLogger().info("装备文件保存失败！");
		}
	}

}
