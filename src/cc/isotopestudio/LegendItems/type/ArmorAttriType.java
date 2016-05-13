package cc.isotopestudio.LegendItems.type;

import cc.isotopestudio.LegendItems.utli.S;

public enum ArmorAttriType {
    DODGE("����", "����˺�", true),

    BOUNCE("����", "����30%�˺�", true),

    DEFENSE("����", "���ӷ���ֵ", false),

    LIFE("����", "��������ֵ", false),

    FLEXIBILITY("����", "���ᱻ����", true),

    DURABILITY("�;�", "����..", false);

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
