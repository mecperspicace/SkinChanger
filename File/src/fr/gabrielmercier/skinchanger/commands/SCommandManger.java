package fr.gabrielmercier.skinchanger.commands;

import fr.gabrielmercier.skinchanger.SMain;
import fr.gabrielmercier.skinchanger.manager.SSkinChangerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SCommandManger implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
            //  Usage command
            if (strings.length == 0){
                commandSender.sendMessage("[§cSkin Changer§r]  ---------- §cCommand usage :§r -----------");
                commandSender.sendMessage("[§cSkin Changer§r]  ");
                commandSender.sendMessage("[§cSkin Changer§r]  Stop/Start the plugin : §c/s on/off§r");
                commandSender.sendMessage("[§cSkin Changer§r]  Change the skin mode : §c/s mode <mode>§r");
                commandSender.sendMessage("[§cSkin Changer§r]  Reload the config : §c/s reload§r");
                commandSender.sendMessage("[§cSkin Changer§r]  ");
                commandSender.sendMessage("[§cSkin Changer§r]  -------------------------------------");
                return false;
            }
            //  Enabled the plugin
            if (strings[0].equalsIgnoreCase("on")){
                SMain.getInstance().getConfig().set("enabled", true);
                SMain.getInstance().saveConfig();
                SMain.getInstance().reloadConfig();
                commandSender.sendMessage("[§cSkin Changer§r]  §aPlugin enabled.");
                return false;
            }
            //  Disabled the plugin
            if (strings[0].equalsIgnoreCase("off")){
                SMain.getInstance().getConfig().set("enabled", false);
                SMain.getInstance().saveConfig();
                SMain.getInstance().reloadConfig();
                commandSender.sendMessage("[§cSkin Changer§r]  §cPlugin disabled.");
                return false;
            }
            //  Reload the plugin
            if (strings[0].equalsIgnoreCase("reload")){
                SMain.getInstance().reloadConfig();
                commandSender.sendMessage("[§cSkin Changer§r]  §aConfig reloaded.");
                return false;
            }
            //  Change the mode
            if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("mode")){
                    String mode = strings[1].toString();
                    if (SMain.getInstance().getConfig().getConfigurationSection("skin_textures").getKeys(false).contains(mode)){
                        SMain.getInstance().getConfig().set("mode", mode.toString());
                        SMain.getInstance().saveConfig();
                        SMain.getInstance().reloadConfig();
                        commandSender.sendMessage("[§cSkin Changer§r]  §aThe mode was succesfuly change to '" + mode + "'.");
                        return false;
                    }else{
                        commandSender.sendMessage("[§cSkin Changer§r]  §cThe mode '" + mode + "' doesn't exist.");
                        return false;
                    }
                }

            }
        commandSender.sendMessage("[§cSkin Changer§r]  ---------- §cCommand usage :§r -----------");
        commandSender.sendMessage("[§cSkin Changer§r]  ");
        commandSender.sendMessage("[§cSkin Changer§r]  Stop/Start the plugin : §c/s on/off§r");
        commandSender.sendMessage("[§cSkin Changer§r]  Change the skin mode : §c/s mode <mode>§r");
        commandSender.sendMessage("[§cSkin Changer§r]  Reload the config : §c/s reload§r");
        commandSender.sendMessage("[§cSkin Changer§r]  ");
        commandSender.sendMessage("[§cSkin Changer§r]  -------------------------------------");
        return false;
    }
}
