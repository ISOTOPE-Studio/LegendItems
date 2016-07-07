package cc.isotopestudio.LegendItems.command;

import cc.isotopestudio.LegendItems.items.ArmorObj;
import cc.isotopestudio.LegendItems.items.SuitObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import cc.isotopestudio.LegendItems.util.S;
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
                        player.getInventory().addItem(item.getItem());
                        player.sendMessage(S.toPrefixGreen("成功获得 " + args[1]));
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("gets")) {
                        SuitObj item = suits.get(args[1]);
                        if (item == null) {
                            player.sendMessage(S.toPrefixRed("套装不存在"));
                            return true;
                        }
                        player.getInventory().addItem(item.getItems());
                        player.sendMessage(S.toPrefixGreen("成功获得 " + args[1]));
                        return true;
                    }
                }
                if (args[0].equalsIgnoreCase("listw")) {
                    String result = weapons.keySet().toString();
                    if (result.length() == 2) {
                        player.sendMessage(S.toPrefixRed("没有装备"));
                        return true;
                    }
                    player.sendMessage(S.toPrefixGreen("武器列表 " + result.substring(1, result.length() - 1)));
                    return true;
                }
                if (args[0].equalsIgnoreCase("lista")) {
                    String result = armors.keySet().toString();
                    if (result.length() == 2) {
                        player.sendMessage(S.toPrefixRed("没有武器"));
                        return true;
                    }
                    player.sendMessage(S.toPrefixGreen("装备列表 " + result.substring(1, result.length() - 1)));
                    return true;
                }
                if (args[0].equalsIgnoreCase("lists")) {
                    String result = suits.keySet().toString();
                    if (result.length() == 2) {
                        player.sendMessage(S.toPrefixRed("没有武器"));
                        return true;
                    }
                    player.sendMessage(S.toPrefixGreen("装备列表 " + result.substring(1, result.length() - 1)));
                    return true;
                }
                if (args[0].equalsIgnoreCase("update")) {

                    player.sendMessage(S.toPrefixGreen("成功更新 "));
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

    private void sendHelp(CommandSender player, String label) {
        player.sendMessage(S.toPrefixGreen("帮助菜单"));
        player.sendMessage(S.toBoldGreen("/" + label + " getw <武器名>") + S.toGray(" - ") + S.toGold("获得传奇武器"));
        player.sendMessage(S.toBoldGreen("/" + label + " geta <装备名>") + S.toGray(" - ") + S.toGold("获得传奇装备"));
        player.sendMessage(S.toBoldGreen("/" + label + " gets <套装名>") + S.toGray(" - ") + S.toGold("获得传奇套装"));
        player.sendMessage(S.toBoldGreen("/" + label + " listw") + S.toGray(" - ") + S.toGold("查看传奇武器列表"));
        player.sendMessage(S.toBoldGreen("/" + label + " lista") + S.toGray(" - ") + S.toGold("查看传奇装备列表"));
        player.sendMessage(S.toBoldGreen("/" + label + " lists") + S.toGray(" - ") + S.toGold("查看传奇套装列表"));
        player.sendMessage(S.toBoldGreen("/" + label + " update") + S.toGray(" - ") + S.toGold("更新列表"));
    }

}
