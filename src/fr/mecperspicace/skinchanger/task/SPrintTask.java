package fr.mecperspicace.skinchanger.task;

import fr.mecperspicace.skinchanger.SMain;
import org.bukkit.Bukkit;

public class SPrintTask {

    public void SPrintTask(){
        Bukkit.getScheduler().runTaskLater(SMain.getInstance(), new Runnable() {
            //  Print the current mode at start
            @Override
            public void run() {
                Bukkit.getConsoleSender().sendMessage(String.format("[§cSkin Changer§r]  Current mode : §c%s      ", SMain.getInstance().getConfig().getString("mode").toUpperCase()));
            }
        }, 40);
    }
}
