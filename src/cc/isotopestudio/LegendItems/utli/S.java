package cc.isotopestudio.LegendItems.utli;

import org.bukkit.ChatColor;

import cc.isotopestudio.LegendItems.LegendItems;

public class S {
	public static String toRed(String s) {
		return new StringBuilder().append(ChatColor.RED).append(s).append(ChatColor.RESET).toString();
	}

	public static String toGreen(String s) {
		return new StringBuilder().append(ChatColor.GREEN).append(s).append(ChatColor.RESET).toString();
	}

	public static String toYellow(String s) {
		return new StringBuilder().append(ChatColor.YELLOW).append(s).append(ChatColor.RESET).toString();
	}

	public static String toAqua(String s) {
		return new StringBuilder().append(ChatColor.AQUA).append(s).append(ChatColor.RESET).toString();
	}

	public static String toGray(String s) {
		return new StringBuilder().append(ChatColor.GRAY).append(s).append(ChatColor.RESET).toString();
	}

	public static String toGold(String s) {
		return new StringBuilder().append(ChatColor.GOLD).append(s).append(ChatColor.RESET).toString();
	}

	public static String toBoldGreen(String s) {
		return new StringBuilder().append(ChatColor.GREEN).append(ChatColor.BOLD).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toBoldDarkGreen(String s) {
		return new StringBuilder().append(ChatColor.DARK_GREEN).append(ChatColor.BOLD).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toBoldBlue(String s) {
		return new StringBuilder().append(ChatColor.BLUE).append(ChatColor.BOLD).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toBoldDarkAqua(String s) {
		return new StringBuilder().append(ChatColor.DARK_AQUA).append(ChatColor.BOLD).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toBoldPurple(String s) {
		return new StringBuilder().append(ChatColor.LIGHT_PURPLE).append(ChatColor.BOLD).append(s)
				.append(ChatColor.RESET).toString();
	}

	public static String toBoldGold(String s) {
		return new StringBuilder().append(ChatColor.GOLD).append(ChatColor.BOLD).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toBoldRed(String s) {
		return new StringBuilder().append(ChatColor.RED).append(ChatColor.BOLD).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toItalicYellow(String s) {
		return new StringBuilder().append(ChatColor.YELLOW).append(ChatColor.ITALIC).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toPrefixRed(String s) {
		return new StringBuilder(LegendItems.prefix).append(ChatColor.RED).append(s).append(ChatColor.RESET).toString();
	}

	public static String toPrefixGreen(String s) {
		return new StringBuilder(LegendItems.prefix).append(ChatColor.GREEN).append(s).append(ChatColor.RESET)
				.toString();
	}

	public static String toPrefixYellow(String s) {
		return new StringBuilder(LegendItems.prefix).append(ChatColor.YELLOW).append(s).append(ChatColor.RESET)
				.toString();
	}
}
