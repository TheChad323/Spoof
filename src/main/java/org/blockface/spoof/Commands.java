package org.blockface.spoof;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands
{
    public static Boolean Spoof(CommandSender sender, String[] args)
    {
        if(!sender.hasPermission("spoof.use"))
        {
            Chatty.SendError(sender,"You do not have permission to do this.");
            return true;
        }
        if(args.length < 2) return false;
        Player target = FindPlayer(args[0]);
        if(target == null)
        {
            Chatty.SendError(sender,"Could not find " + args[0]);
            return true;
        }
        String message = "";
        for(int i=1;i<args.length;i++)
        {
            message += args[i] + " ";
        }
        message = message.trim();
        target.chat(message);
        if(message.contains("/")) Chatty.SendSuccess(sender,target.getName() + " sent " + message);
        return true;
    }

    private static Player FindPlayer(String player)
    {
        player = player.toLowerCase();
        for(Player p : Bukkit.getServer().getOnlinePlayers())
        {
            if(p.getName().toLowerCase().contains(player)) return p;
        }
        return null;
    }
}
