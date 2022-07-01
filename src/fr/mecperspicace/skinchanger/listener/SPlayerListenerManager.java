package fr.mecperspicace.skinchanger.listener;

import fr.mecperspicace.skinchanger.SMain;
import fr.mecperspicace.skinchanger.manager.SSkinChangerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SPlayerListenerManager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        //  If the plugin is enabled, change the player's skin
        if (SMain.getInstance().getConfig().getBoolean("enabled")){
            SSkinChangerManager.SChangeSkin(player);
        }
    }
}
