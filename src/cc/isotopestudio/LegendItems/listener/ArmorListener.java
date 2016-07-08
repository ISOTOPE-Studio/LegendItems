package cc.isotopestudio.LegendItems.listener;

import cc.isotopestudio.LegendItems.items.ArmorObj;
import cc.isotopestudio.LegendItems.items.MaterialObj;
import cc.isotopestudio.LegendItems.items.SuitObj;
import cc.isotopestudio.LegendItems.type.ArmorAttriType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArmorListener implements Listener {

    @EventHandler
    public void onDefense(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player && event.getDamager() instanceof LivingEntity)) return;
        Player player = (Player) event.getEntity();
        Set<ArmorObj> armors = PlayerUtil.getArmorItems(player);
        if (armors == null) return;
        onAttri(event, player, armors, (LivingEntity) event.getDamager());
    }

    private static void addTwoAttri(Set<ArmorAttriType> attriList, HashMap<ArmorAttriType, Double> parameters,
                                    Set<ArmorAttriType> attriListA, HashMap<ArmorAttriType, Double> parametersA) {
        System.out.print("    method:  " + attriList + " : " + attriListA);
        System.out.print("    method:  " + parameters + " : " + parametersA);
        for (ArmorAttriType attri : attriListA) {
            if (attriList.contains(attri)) {
                parameters.put(attri, parameters.get(attri) + parametersA.get(attri));
            } else {
                attriList.add(attri);
                parameters.put(attri, parametersA.get(attri));
            }
        }
    }

    private static void onAttri(EntityDamageByEntityEvent event, Player player, Set<ArmorObj> armors,
                                LivingEntity damagee) {
        Set<ArmorAttriType> attriList = new HashSet<>();
        HashMap<ArmorAttriType, Double> parameters = new HashMap<>();
        for (ArmorObj armor : armors) {
            addTwoAttri(attriList, parameters, armor.getAttriList(), armor.getParameters());
            System.out.print(parameters);
        }
        SuitObj suit = PlayerUtil.getSuits(player);
        if (suit != null) {
            addTwoAttri(attriList, parameters, suit.getArmorAttriList(), suit.getArmorParameters());
            System.out.print(parameters);
        }
        MaterialObj material = PlayerUtil.getMaterial(player);
        if (material != null) {
            addTwoAttri(attriList, parameters, material.getAttriListForArmor(), material.getParametersForArmor());
            System.out.print(parameters);
        }
        System.out.print(parameters);
        for (ArmorAttriType attri : attriList) {
            double parameter = parameters.get(attri);
            if (attri.isPercentile() && parameter < Math.random())
                continue;
            switch (attri) {
                case DODGE: {
                    break;
                }
                case BOUNCE: {
                    break;
                }
                case DEFENSE: {
                    break;
                }
                case LIFE:
                    break;
                case FLEXIBILITY: {
                    break;
                }
                case DURABILITY: {
                    break;
                }
            }
        }
    }
}
