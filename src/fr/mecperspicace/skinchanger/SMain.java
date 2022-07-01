package fr.mecperspicace.skinchanger;

import fr.mecperspicace.skinchanger.commands.SCommandManger;
import fr.mecperspicace.skinchanger.listener.SPlayerListenerManager;
import fr.mecperspicace.skinchanger.task.SPrintTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SMain extends JavaPlugin {

    private static SMain instance;

    //  On loading plugin
    @Override
    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage("[§cSkin Changer§r] §aLOADING...");
    }

    @Override
    public void onEnable() {
        //  Set instance
        instance = this;
        Bukkit.getConsoleSender().sendMessage("[§cSkin Changer§r] §aENABLING...");
        //  Print the current mode
        new SPrintTask().SPrintTask();
        Bukkit.getConsoleSender().sendMessage("[§cSkin Changer§r] §aLOAD CONFIG...");
        //  Load the config
        SLoadConfig();
        //  Register the listener
        getServer().getPluginManager().registerEvents(new SPlayerListenerManager(), this);
        //  Register the command
        getCommand("s").setExecutor(new SCommandManger());
    }

    //  On disabled plugin
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("[§cSkin Changer§r] §aDISABLING...");
    }

    //  Get instance
    public static SMain getInstance() {
        return instance;
    }

    private void SLoadConfig(){
        //  Load the config
        try {
            saveDefaultConfig();
            Bukkit.getConsoleSender().sendMessage("[§cSkin Changer§r] §aCONFIG LOAD SUCCESFULLY");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
