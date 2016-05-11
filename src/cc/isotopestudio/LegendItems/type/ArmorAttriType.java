package cc.isotopestudio.LegendItems.type;

import cc.isotopestudio.LegendItems.utli.S;

public enum ArmorAttriType {
	DODGE("����", true),

	BOUNCE("����", true),

	DEFENSE("����", false),

	LIFE("����", false),

	FLEXIBILITY("����", true),

	DURABILITY("�;�", false);

	final private String name;
	final private boolean isPercentile;

	ArmorAttriType(String name, boolean isPercentile) {
		this.name = name;
		this.isPercentile = isPercentile;
	}

	public String toString() {
		return S.toBoldGold(name);
	}

	public boolean isPercentile() {
		return isPercentile;
	}
}
