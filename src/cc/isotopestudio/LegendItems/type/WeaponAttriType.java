package cc.isotopestudio.LegendItems.type;

import java.util.HashMap;

import cc.isotopestudio.LegendItems.utli.S;

public enum WeaponAttriType {
	ADDITIONAL("����", false),

	CRITICAL("����", true),

	VAMPIRIC("��Ѫ", true),

	DIRECT("�Ƽ��˺�", false),

	MONSTER("�����˺�", false),

	PLAYER("����˺�", false);

	final private String name;
	final private boolean isPercentile;

	WeaponAttriType(String name, boolean isPercentile) {
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
