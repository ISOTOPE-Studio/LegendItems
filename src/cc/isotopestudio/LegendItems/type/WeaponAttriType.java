package cc.isotopestudio.LegendItems.type;

import cc.isotopestudio.LegendItems.utli.S;

public enum WeaponAttriType {
    ADDITIONAL("¹¥»÷", "Ôö¼Ó¹¥»÷Öµ", false),

    CRITICAL("±©»÷", "Ë«±¶¹¥»÷", true),

    VAMPIRIC("ÎüÑª", "Îü¹¥»÷Á¦5%µÄÉúÃü", true),

    DIRECT("ÆÆ¼×ÉËº¦", "ºöÊÓ»¤¼×·ÀÓù", false),

    MONSTER("¹ÖÎïÉËº¦", "Õë¶Ô¹ÖÎïÉËº¦", false),

    PLAYER("Íæ¼ÒÉËº¦", "Õë¶ÔÍæ¼ÒÉËº¦", false);

    final private String name;
    final private boolean isPercentile;
    final private String introduction;

    WeaponAttriType(String name, String introduction, boolean isPercentile) {
        this.name = name;
        this.isPercentile = isPercentile;
        this.introduction = introduction;
    }

    public String toString() {
        return S.toBoldGold(name);
    }

    public boolean isPercentile() {
        return isPercentile;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getLore(Double parameter) {
        if (isPercentile()) {
            return toString() + " " + getIntroduction() + " " + parameter + "%";
        } else {
            return toString() + " " + getIntroduction() + " " + parameter;
        }
    }
}
