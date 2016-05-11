package cc.isotopestudio.LegendItems.type;

import cc.isotopestudio.LegendItems.utli.S;

public enum ArmorAttriType {
	DODGE("ÉÁ±Ü", true),

	BOUNCE("·´ÉË", true),

	DEFENSE("·ÀÓù", false),

	LIFE("ÉúÃü", false),

	FLEXIBILITY("ÈÍĞÔ", true),

	DURABILITY("ÄÍ¾Ã", false);

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
