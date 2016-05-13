package cc.isotopestudio.LegendItems.command;

import cc.isotopestudio.LegendItems.items.ArmorItem;
import cc.isotopestudio.LegendItems.items.SuitObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import cc.isotopestudio.LegendItems.utli.S;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                        ArmorItem item = armors.get(args[1]);
                        if (item == null) {
                            player.sendMessage(S.toPrefixRed("��Ʒ������"));
                            return true;
                        }
                        player.getInventory().addItem(item.getItem());
                        player.sendMessage(S.toPrefixGreen("�ɹ���� " + args[1]));
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("gets")) {
                        SuitObj item = suits.get(args[1]);
                        if (item == null) {
                            player.sendMessage(S.toPrefixRed("��װ������"));
                            return true;
                        }
                        player.getInventory().addItem(item.getItems());
                        player.sendMessage(S.toPrefixGreen("�ɹ���� " + args[1]));
                        return true;
                    }
                }
                if (args[0].equalsIgnoreCase("listw")) {
                    String result = weapons.keySet().toString();
                    if (result.length() == 2) {
                        player.sendMessage(S.toPrefixRed("û��װ��"));
                        return true;
                    }
                    player.sendMessage(S.toPrefixGreen("�����б� " + result.substring(1, result.length() - 1)));
                    return true;
                }
                if (args[0].equalsIgnoreCase("lista")) {
                    String result = armors.keySet().toString();
                    if (result.length() == 2) {
                        player.sendMessage(S.toPrefixRed("û������"));
                        return true;
                    }
                    player.sendMessage(S.toPrefixGreen("װ���б� " + result.substring(1, result.length() - 1)));
                    return true;
                }
                if (args[0].equalsIgnoreCase("lists")) {
                    String result = suits.keySet().toString();
                    if (result.length() == 2) {
                        player.sendMessage(S.toPrefixRed("û������"));
                        return true;
                    }
                    player.sendMessage(S.toPrefixGreen("װ���б� " + result.substring(1, result.length() - 1)));
                    return true;
                }
                if (args[0].equalsIgnoreCase("update")) {

                    player.sendMessage(S.toPrefixGreen("�ɹ����� "));
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

    private void sendHelp(CommandSender player, String label) {
        player.sendMessage(S.toPrefixGreen("�����˵�"));
        player.sendMessage(S.toBoldGreen("/" + label + " getw <������>") + S.toGray(" - ") + S.toGold("��ô�������"));
        player.sendMessage(S.toBoldGreen("/" + label + " geta <װ����>") + S.toGray(" - ") + S.toGold("��ô���װ��"));
        player.sendMessage(S.toBoldGreen("/" + label + " gets <��װ��>") + S.toGray(" - ") + S.toGold("��ô�����װ"));
        player.sendMessage(S.toBoldGreen("/" + label + " listw") + S.toGray(" - ") + S.toGold("�鿴���������б�"));
        player.sendMessage(S.toBoldGreen("/" + label + " lista") + S.toGray(" - ") + S.toGold("�鿴����װ���б�"));
        player.sendMessage(S.toBoldGreen("/" + label + " lists") + S.toGray(" - ") + S.toGold("�鿴������װ�б�"));
        player.sendMessage(S.toBoldGreen("/" + label + " update") + S.toGray(" - ") + S.toGold("�����б�"));
    }

}
