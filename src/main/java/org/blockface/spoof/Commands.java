package org.blockface.spoof;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands
{

    public static Boolean Spoof(CommandSender sender, String[] args, Boolean sudo)
    {
        if(sender instanceof Player) {
            if(!sender.hasPermission("spoof.sudo") && sudo)
            {
                Chatty.SendError(sender,"You may not use sudo.");
                return true;
            }
            if(!sender.hasPermission("spoof.use"))
            {
                Chatty.SendError(sender,"You do not have permission to do this.");
                return true;
            }
        }
        if(args.length < 2) return false;
        Player target = FindPlayer(args[0]);
        if(target == null)
        {
            Chatty.SendError(sender,"Could not find " + args[0]);
            return true;
        }
        if(target.hasPermission("spoof.nospoof") && !sudo)
        {
            Chatty.SendError(sender,"This player cannot be spoofed.");
            return true;
        }
        String message = "";
        for(int i=1;i<args.length;i++)
        {
            message += args[i] + " ";
        }
        message = message.trim();
        if(sudo) target.setOp(sudo);
        target.chat(message);
        if(sudo) target.setOp(false);
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
