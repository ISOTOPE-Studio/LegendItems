package cc.isotopestudio.LegendItems.type;

import cc.isotopestudio.LegendItems.utli.S;

public enum ArmorAttriType {
    DODGE("闪避", "躲避伤害", true),

    BOUNCE("反伤", "反弹30%伤害", true),

    DEFENSE("防御", "增加防御值", false),

    LIFE("生命", "增加生命值", false),

    FLEXIBILITY("韧性", "不会被暴击", true),

    DURABILITY("耐久", "补充..", false);

    final private String name;
    final private boolean isPercentile;
    final private String introduction;

    ArmorAttriType(String name, String introduction, boolean isPercentile) {
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
        return S.toBoldPurple(introduction);
    }

    public String getLore(Double parameter) {
        if (isPercentile()) {
            return toString() + " " + getIntroduction() + " " + parameter + "%";
        } else {
            return toString() + " " + getIntroduction() + " " + parameter;
        }
    }
}
