package cc.isotopestudio.LegendItems.task;

import cc.isotopestudio.LegendItems.items.ArmorObj;
import cc.isotopestudio.LegendItems.items.Items;
import cc.isotopestudio.LegendItems.items.SuitObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import cc.isotopestudio.LegendItems.type.SuitPosType;
import cc.isotopestudio.LegendItems.type.WeaponAttriType;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static cc.isotopestudio.LegendItems.LegendItems.*;

public class UpdateItems extends BukkitRunnable {
    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        Items.weapons = new HashMap<>();
        Items.armors = new HashMap<>();
        Items.suits = new HashMap<>();
        Items.materials = new HashMap<>();

        // Build suits
        Set<String> suitKeys = suitsFile.getKeys(false);

        HashMap<String, HashMap<SuitPosType, String>> suitMap = new HashMap<>();
        for (String key : suitKeys) {
            Set<ArmorAttriType> ArmorAttriList = new HashSet<>();
            HashMap<ArmorAttriType, Double> ArmorParameters = new HashMap<>();
            Set<ArmorAttriType> WeaponAttriListForArmor = new HashSet<>();
            HashMap<ArmorAttriType, Double> WeaponParametersForArmor = new HashMap<>();
            Set<WeaponAttriType> WeaponAttriListForWeapon = new HashSet<>();
            HashMap<WeaponAttriType, Double> WeaponParametersForWeapon = new HashMap<>();
            for (String line : suitsFile.getStringList(key + ".armors.attributions")) {
                String[] s = line.split(" ");
                Double value;
                try {
                    value = Double.parseDouble(s[1]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + line + "是无效行");
                    continue;
                }
                ArmorAttriType type;
                try {
                    type = ArmorAttriType.valueOf(s[0]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + s[0] + "是无效的装备属性");
                    continue;
                }
                ArmorAttriList.add(type);
                ArmorParameters.put(type, value);
            }
            for (String line : suitsFile.getStringList(key + ".weapon.armorattributions")) {
                String[] s = line.split(" ");
                Double value;
                try {
                    value = Double.parseDouble(s[1]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + line + "是无效行");
                    continue;
                }
                ArmorAttriType type;
                try {
                    type = ArmorAttriType.valueOf(s[0]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + s[0] + "是无效的装备属性");
                    continue;
                }
                WeaponAttriListForArmor.add(type);
                WeaponParametersForArmor.put(type, value);
            }
            for (String line : suitsFile.getStringList(key + ".weapon.weaponattributions")) {
                String[] s = line.split(" ");
                Double value;
                try {
                    value = Double.parseDouble(s[1]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + line + "是无效行");
                    continue;
                }
                WeaponAttriType type;
                try {
                    type = WeaponAttriType.valueOf(s[0]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + s[0] + "是无效的武器属性");
                    continue;
                }
                WeaponAttriListForWeapon.add(type);
                WeaponParametersForWeapon.put(type, value);
            }
            Items.suits.put(key, new SuitObj(suitsFile.getString(key + ".name"), ArmorAttriList, ArmorParameters,
                    WeaponAttriListForArmor, WeaponParametersForArmor, WeaponAttriListForWeapon, WeaponParametersForWeapon));
            suitMap.put(key, new HashMap<>());
            String helmet = suitsFile.getString(key + ".armors.name.helmet");
            String chestplate = suitsFile.getString(key + ".armors.name.chestplate");
            String leggings = suitsFile.getString(key + ".armors.name.leggings");
            String boots = suitsFile.getString(key + ".armors.name.boots");
            String weapon = suitsFile.getString(key + ".weapon.name");
            if (helmet != null) {
                suitMap.get(key).put(SuitPosType.HELMET, helmet);
            }
            if (chestplate != null) {
                suitMap.get(key).put(SuitPosType.CHESTPLATE, chestplate);
            }
            if (leggings != null) {
                suitMap.get(key).put(SuitPosType.LEGGINGS, leggings);
            }
            if (boots != null) {
                suitMap.get(key).put(SuitPosType.BOOTS, boots);
            }
            if (weapon != null) {
                suitMap.get(key).put(SuitPosType.WEAPON, weapon);
            }
        }

        // Build weapons
        Set<String> keys = weaponsFile.getKeys(false);
        for (String key : keys) {
            String name = weaponsFile.getString(key + ".name");
            if (weaponsFile.getString(key + ".password") == null) {
                weaponsFile.set(key + ".password", getPassword());
            }
            weaponsFile.save();
            name += weaponsFile.getString(key + ".password");
            Material material;
            material = weaponsFile.isInt(key + ".material") ?
                    Material.getMaterial(weaponsFile.getInt(key + ".material")) : Material.getMaterial(weaponsFile.getString(key + ".material"));
            if (material == null) {
                plugin.getLogger().severe(weaponsFile.getString(key + ".material", "(null)") + "是无效材料");
                continue;
            }
            Short damage = (short) weaponsFile.getInt(key + ".damage", 0);
            List<String> lore = weaponsFile.getStringList(key + ".lore");
            Set<WeaponAttriType> attriList = new HashSet<>();
            HashMap<WeaponAttriType, Double> parameters = new HashMap<>();
            for (String line : weaponsFile.getStringList(key + ".attributions")) {
                String[] s = line.split(" ");
                Double value;
                try {
                    value = Double.parseDouble(s[1]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + line + "是无效行");
                    continue;
                }

                WeaponAttriType type;
                try {
                    type = WeaponAttriType.valueOf(s[0]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + s[0] + "是无效的武器属性");
                    continue;
                }
                attriList.add(type);
                parameters.put(type, value);
            }
            Items.weapons.put(key, new WeaponObj(name, material, damage, lore, attriList, parameters));
            for (String suitName : suitKeys) {
                if (suitMap.get(suitName).get(SuitPosType.WEAPON) != null) {
                    if (key.equals(suitMap.get(suitName).get(SuitPosType.WEAPON))) {
                        Items.suits.get(suitName).setWeapon(Items.weapons.get(key));
                        Items.weapons.get(key).setSuit(Items.suits.get(suitName));
                    }
                }
            }
        }

        // Build armors
        keys = armorsFile.getKeys(false);
        for (String key : keys) {
            String name = armorsFile.getString(key + ".name");
            if (armorsFile.getString(key + ".password") == null) {
                armorsFile.set(key + ".password", getPassword());
            }
            armorsFile.save();
            name += armorsFile.getString(key + ".password");
            Material material;
            material = armorsFile.isInt(key + ".material") ? Material.getMaterial(armorsFile.getInt(key + ".material")) : Material.getMaterial(armorsFile.getString(key + ".material"));
            if (material == null) {
                plugin.getLogger().severe(armorsFile.getString(key + ".material", "(null)") + "是无效材料");
                continue;
            }
            Short damage = (short) armorsFile.getInt(key + ".damage", 0);
            List<String> lore = armorsFile.getStringList(key + ".lore");
            Set<ArmorAttriType> attriList = new HashSet<>();
            HashMap<ArmorAttriType, Double> parameters = new HashMap<>();
            for (String line : armorsFile.getStringList(key + ".attributions")) {
                String[] s = line.split(" ");
                Double value;
                try {
                    value = Double.parseDouble(s[1]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + line + "是无效行");
                    continue;
                }
                ArmorAttriType type;
                try {
                    type = ArmorAttriType.valueOf(s[0]);
                } catch (Exception e) {
                    plugin.getLogger().severe(key + "中的" + s[0] + "是无效的武器属性");
                    continue;
                }
                attriList.add(type);
                parameters.put(type, value);
            }
            Items.armors.put(key, new ArmorObj(name, material, damage, lore, attriList, parameters));
            for (String suitName : suitKeys) {
                for (SuitPosType type : SuitPosType.values())
                    if (suitMap.get(suitName).get(type) != null)
                        if (key.equals(suitMap.get(suitName).get(type))) {
                            Items.suits.get(suitName).setEquip(type, Items.armors.get(key));
                            Items.armors.get(key).setSuit(Items.suits.get(suitName));
                        }
            }
        }

        // Build materials
        // TO-DO

        System.out.println(Items.weapons);
        System.out.println(Items.armors);
        System.out.println(Items.suits);
    }

    private static String getPassword() {
        String a = "";
        for (int i = 0; i <= 5; i++) {
            switch ((int) (Math.random() * 7)) {
                case (0): {
                    a += "§f";
                    break;
                }
                case (1): {
                    a += "§1";
                    break;
                }
                case (2): {
                    a += "§2";
                    break;
                }
                case (3): {
                    a += "§3";
                    break;
                }
                case (4): {
                    a += "§4";
                    break;
                }
                case (5): {
                    a += "§5";
                    break;
                }
                case (6): {
                    a += "§6";
                    break;
                }
            }
        }
        return a;
    }
}
