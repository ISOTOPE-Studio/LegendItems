package cc.isotopestudio.LegendItems.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import cc.isotopestudio.LegendItems.items.ArmorObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import cc.isotopestudio.LegendItems.utli.S;
import static cc.isotopestudio.LegendItems.items.Items.*;

public class CommandLegend implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("legend")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(S.toPrefixRed("必须要玩家才能执行"));
				sendHelp(sender, label);
				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("legend.admin")) {
				sender.sendMessage(S.toPrefixRed("你没有权限"));
				return true;
			}
			if (args.length > 0 && !args[0].equalsIgnoreCase("help")) {
				if (args.length > 1) {
					if (args[0].equalsIgnoreCase("getw")) {
						WeaponObj item = weapons.get(args[1]);
						if (item == null) {
							player.sendMessage(S.toPrefixRed("物品不存在"));
							return true;
						}
						player.getInventory().addItem(item.getItem());
						player.sendMessage(S.toPrefixGreen("成功获得 " + args[1]));
						return true;
					}
					if (args[0].equalsIgnoreCase("geta")) {
						ArmorObj item = armors.get(args[1]);
						if (item == null) {
							player.sendMessage(S.toPrefixRed("物品不存在"));
							return true;
						}
						// player.getInventory().addItem(item.getItem());
						player.sendMessage(S.toPrefixGreen("成功获得 " + args[1]));
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("listw")) {
					player.sendMessage(S.toPrefixGreen("武器列表 " + armors.keySet().toString()));
					return true;
				}
				if (args[0].equalsIgnoreCase("lista")) {
					player.sendMessage(S.toPrefixGreen("装备列表 " + weapons.keySet().toString()));
					return true;
				}
				S.toPrefixRed("命令不存在");
				sendHelp(player, label);
				return true;
			} else {
				sendHelp(player, label);
				return true;
			}
		}
		return false;
	}

	void sendHelp(CommandSender player, String label) {
		player.sendMessage(S.toPrefixGreen("帮助菜单"));
		player.sendMessage(S.toBoldGreen("/" + label + " getw <武器名>") + S.toGray(" - ") + S.toGold("获得传奇武器"));
		player.sendMessage(S.toBoldGreen("/" + label + " geta <装备名>") + S.toGray(" - ") + S.toGold("获得传奇装备"));
		player.sendMessage(S.toBoldGreen("/" + label + " listw") + S.toGray(" - ") + S.toGold("查看传奇武器列表"));
		player.sendMessage(S.toBoldGreen("/" + label + " lista") + S.toGray(" - ") + S.toGold("查看传奇装备列表"));
	}

}
