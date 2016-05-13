package cc.isotopestudio.LegendItems.listener;

import cc.isotopestudio.LegendItems.items.ArmorItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Set;

public class ArmorListener implements Listener {

    @EventHandler
    public void onDefense(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        Set<ArmorItem> armors = PlayerUtli.getArmorItems(player);

    }

}
