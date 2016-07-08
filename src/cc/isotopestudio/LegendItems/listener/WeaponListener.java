package cc.isotopestudio.LegendItems.listener;

import cc.isotopestudio.LegendItems.LegendItems;
import cc.isotopestudio.LegendItems.items.MaterialObj;
import cc.isotopestudio.LegendItems.items.WeaponObj;
import cc.isotopestudio.LegendItems.type.WeaponAttriType;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WeaponListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onAttack(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof LivingEntity)) return;
        Player player = (Player) event.getDamager();
        LivingEntity entity = (LivingEntity) event.getEntity();
        WeaponObj weapon = PlayerUtil.getWeapon(player);
        WeaponListener.onAttri(event, player, weapon, entity);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onShoot(ProjectileLaunchEvent event) {
        if (event.isCancelled()) {
            return;
        }
        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity().getShooter();
        WeaponObj weapon = PlayerUtil.getWeapon(player);
        if (weapon == null)
            return;
        LegendItems.plugin.getServer().getPluginManager().registerEvents(new ProjectileListener(event.getEntity(), weapon), LegendItems.plugin);
    }


    private class ProjectileListener implements Listener {
        private final WeaponObj weapon;
        private final Projectile projectile;

        ProjectileListener(Projectile projectile, WeaponObj info) {
            this.weapon = info;
            this.projectile = projectile;
        }

        @EventHandler
        public void onHit(EntityDamageByEntityEvent event) {
            if (!(event.getDamager().equals(projectile))) {
                return;
            }
            WeaponListener.onAttri(event, (Player) projectile.getShooter(), weapon, (LivingEntity) event.getEntity());
            HandlerList.unregisterAll(this);
        }

    }

    private static void addTwoAttri(Set<WeaponAttriType> attriList, HashMap<WeaponAttriType, Double> parameters,
                                    Set<WeaponAttriType> attriListA, HashMap<WeaponAttriType, Double> parametersA) {
        for (WeaponAttriType attri : attriListA) {
            if (attriList.contains(attri)) {
                parameters.put(attri, parameters.get(attri) + parametersA.get(attri));
            } else {
                attriList.add(attri);
                parameters.put(attri, parametersA.get(attri));
            }
        }
    }

    private static void onAttri(EntityDamageByEntityEvent event, Player player, @Nullable WeaponObj weapon,
                                LivingEntity damagee) {
        MaterialObj material = PlayerUtil.getMaterial(player);
        if (weapon == null && material == null)
            return;
        final Set<WeaponAttriType> attriList = weapon == null ? new HashSet<>() : weapon.getAttriList();
        final HashMap<WeaponAttriType, Double> parameters = weapon == null ? new HashMap<>() : weapon.getParameters();

        // Add attri from suit
        if (PlayerUtil.isSuitHasWeapon(player)) {
            addTwoAttri(attriList, parameters,
                    weapon.getSuit().getWeaponAttriListForWeapon(), weapon.getSuit().getWeaponParametersForWeapon());
        }

        // Add attri from material
        if (material != null) {
            addTwoAttri(attriList, parameters, material.getAttriListForWeapon(), material.getParametersForWeapon());
        }

        System.out.print(parameters);

        for (WeaponAttriType attri : attriList) {
            double parameter = parameters.get(attri);
            if (attri.isPercentile() && parameter < Math.random())
                continue;
            switch (attri) {
                case ADDITIONAL: {
                    onAdditional(event, parameter);
                    break;
                }
                case CRITICAL: {
                    onCtitical(event);
                    break;
                }
                case VAMPIRIC: {
                    onVampiric(player, damagee);
                    break;
                }
                case DIRECT: {
                    onDirect(damagee, parameter);
                    break;
                }
                case MONSTER: {
                    if (damagee instanceof Monster) {
                        onAdditional(event, parameter);
                    }
                    break;
                }
                case PLAYER: {
                    if (damagee instanceof Player) {
                        onAdditional(event, parameter);
                    }
                    break;
                }
            }
        }
    }

    private static void onAdditional(EntityDamageByEntityEvent event, double add) {
        System.out.print("--onAdditional--");
        System.out.print(event.getDamage());
        event.setDamage(event.getDamage() + add);
        System.out.print(event.getDamage());
        System.out.print("--onAdditional--");
    }

    private static void onCtitical(EntityDamageByEntityEvent event) {
        System.out.print("--onCtitical--");
        System.out.print(event.getDamage());
        event.setDamage(event.getDamage() * 2);
        System.out.print(event.getDamage());
        System.out.print("--onCtitical--");
    }

    private static void onVampiric(Player player, LivingEntity entity) {
        double eOriginalHealth = entity.getHealth();
        double eHealth = entity.getHealth() * (1 - 0.05);
        if (eHealth < 0)
            eHealth = 0;
        entity.setHealth(eHealth);
        double pHealth = player.getHealth() + (eOriginalHealth - eHealth);
        if (pHealth > player.getMaxHealth())
            pHealth = player.getMaxHealth();
        player.setHealth(pHealth);
        System.out.print("--onVampiric--");
    }

    private static void onDirect(LivingEntity entity, double damage) {
        System.out.print("--onDirect--");
        System.out.print(entity.getHealth());
        double health = entity.getHealth() - damage;
        if (health < 0)
            health = 0;
        entity.setHealth(health);
        System.out.print(entity.getHealth());
        System.out.print("--onDirect--");
    }

}
