package cc.isotopestudio.LegendItems.items;

import java.util.HashMap;

public class Items {

	public static HashMap<String, ArmorObj> armors;
	public static HashMap<String, WeaponObj> weapons;
	public static HashMap<String, SuitObj> suits;

	public static ArmorObj getArmor(String name) {
		return armors.get(name);
	}

}
