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
				sender.sendMessage(S.toPrefixRed("����Ҫ��Ҳ���ִ��"));
				sendHelp(sender, label);
				return true;
			}
			Player player = (Player) sender;
			if (!player.hasPermission("legend.admin")) {
				sender.sendMessage(S.toPrefixRed("��û��Ȩ��"));
				return true;
			}
			if (args.length > 0 && !args[0].equalsIgnoreCase("help")) {
				if (args.length > 1) {
					if (args[0].equalsIgnoreCase("getw")) {
						WeaponObj item = weapons.get(args[1]);
						if (item == null) {
							player.sendMessage(S.toPrefixRed("��Ʒ������"));
							return true;
						}
						player.getInventory().addItem(item.getItem());
						player.sendMessage(S.toPrefixGreen("�ɹ���� " + args[1]));
						return true;
					}
					if (args[0].equalsIgnoreCase("geta")) {
						ArmorObj item = armors.get(args[1]);
						if (item == null) {
							player.sendMessage(S.toPrefixRed("��Ʒ������"));
							return true;
						}
						// player.getInventory().addItem(item.getItem());
						player.sendMessage(S.toPrefixGreen("�ɹ���� " + args[1]));
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("listw")) {
					player.sendMessage(S.toPrefixGreen("�����б� " + armors.keySet().toString()));
					return true;
				}
				if (args[0].equalsIgnoreCase("lista")) {
					player.sendMessage(S.toPrefixGreen("װ���б� " + weapons.keySet().toString()));
					return true;
				}
				S.toPrefixRed("�������");
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
		player.sendMessage(S.toPrefixGreen("�����˵�"));
		player.sendMessage(S.toBoldGreen("/" + label + " getw <������>") + S.toGray(" - ") + S.toGold("��ô�������"));
		player.sendMessage(S.toBoldGreen("/" + label + " geta <װ����>") + S.toGray(" - ") + S.toGold("��ô���װ��"));
		player.sendMessage(S.toBoldGreen("/" + label + " listw") + S.toGray(" - ") + S.toGold("�鿴���������б�"));
		player.sendMessage(S.toBoldGreen("/" + label + " lista") + S.toGray(" - ") + S.toGold("�鿴����װ���б�"));
	}

}
