package org.blockface.spoof;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Chatty
{
    private final static String prefix = ChatColor.AQUA + "[Spoof] " + ChatColor.WHITE;
    public static void SendError(CommandSender sender, String message)
    {
        sender.sendMessage(prefix + ChatColor.RED + message);
    }

    public static void SendSuccess(CommandSender sender, String message)
    {
        sender.sendMessage(prefix + ChatColor.GREEN + message);
    }
}
