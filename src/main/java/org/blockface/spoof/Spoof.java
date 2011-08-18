package org.blockface.spoof;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Spoof extends JavaPlugin {
    public void onDisable() {

    }

    public void onEnable()
    {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(label.equalsIgnoreCase("spoof")) return Commands.Spoof(sender,args);

        return false;
    }
}
