package cc.isotopestudio.LegendItems.type;

import cc.isotopestudio.LegendItems.util.S;

public enum WeaponAttriType {
    ADDITIONAL("攻击", "增加攻击值", false),

    CRITICAL("暴击", "双倍攻击", true),

    VAMPIRIC("吸血", "吸攻击力5%的生命", true),

    DIRECT("破甲伤害", "忽视护甲防御", false),

    MONSTER("怪物伤害", "针对怪物伤害", false),

    PLAYER("玩家伤害", "针对玩家伤害", false);

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
        return S.toBoldPurple(introduction);
    }

    public String getLore(Double parameter) {
        return isPercentile() ?
                /*toString() + " " + */getIntroduction() + " " + parameter + "%" : /*toString() + " " + */getIntroduction() + " " + parameter;
    }
}
