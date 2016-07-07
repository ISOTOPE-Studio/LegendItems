package cc.isotopestudio.LegendItems;

import cc.isotopestudio.LegendItems.command.CommandLegend;
import cc.isotopestudio.LegendItems.listener.ArmorListener;
import cc.isotopestudio.LegendItems.listener.WeaponListener;
import cc.isotopestudio.LegendItems.task.UpdateItems;
import cc.isotopestudio.LegendItems.util.PluginFile;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LegendItems extends JavaPlugin {

    public static final String prefix = (new StringBuilder()).append(ChatColor.GOLD).append(ChatColor.BOLD).append("[")
            .append("传奇物品").append("]").append(ChatColor.GREEN).toString();
    private static final String pluginName = "LegendItems";

    public static LegendItems plugin;

    public static PluginFile configFile;
    public static PluginFile armorsFile;
    public static PluginFile weaponsFile;
    public static PluginFile suitsFile;

    @Override
    public void onEnable() {
        plugin = this;
        configFile = new PluginFile(this, "config.yml", "config.yml");
        armorsFile = new PluginFile(this, "armors.yml", "armors.yml");
        weaponsFile = new PluginFile(this, "weapons.yml", "weapons.yml");
        suitsFile = new PluginFile(this, "suits.yml", "suits.yml");

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ArmorListener(), this);
        pm.registerEvents(new WeaponListener(), this);

        this.getCommand("Legend").setExecutor(new CommandLegend());
        new UpdateItems().runTask(this);
        getLogger().info(pluginName + "成功加载!");
        getLogger().info(pluginName + "由ISOTOPE Studio制作!");
        getLogger().info("http://isotopestudio.cc");
    }

}
