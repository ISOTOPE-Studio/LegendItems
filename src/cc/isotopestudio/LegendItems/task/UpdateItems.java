package cc.isotopestudio.LegendItems.task;

import java.util.List;
import java.util.Set;

import org.bukkit.scheduler.BukkitRunnable;

import cc.isotopestudio.LegendItems.LegendItems;

public class UpdateItems extends BukkitRunnable {
	private final LegendItems plugin;

	public UpdateItems(LegendItems plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		Set<String> names = plugin.getWeaponsData().getKeys(false);
		System.out.println(names.toString());
	}

}
