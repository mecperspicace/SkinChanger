package fr.gabrielmercier.skinchanger;

import fr.gabrielmercier.skinchanger.commands.SCommandManger;
import fr.gabrielmercier.skinchanger.listener.SPlayerListenerManager;
import fr.gabrielmercier.skinchanger.task.SPrintTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SMain extends JavaPlugin {

    /*
    Copyright [2021] [MERCIER GABRIEL]


    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    */

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
