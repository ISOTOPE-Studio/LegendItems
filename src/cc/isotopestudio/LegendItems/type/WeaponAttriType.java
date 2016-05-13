package cc.isotopestudio.LegendItems.type;

import cc.isotopestudio.LegendItems.utli.S;

public enum WeaponAttriType {
    ADDITIONAL("����", "���ӹ���ֵ", false),

    CRITICAL("����", "˫������", true),

    VAMPIRIC("��Ѫ", "��������5%������", true),

    DIRECT("�Ƽ��˺�", "���ӻ��׷���", false),

    MONSTER("�����˺�", "��Թ����˺�", false),

    PLAYER("����˺�", "�������˺�", false);

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
