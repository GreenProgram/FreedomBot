package com.FoxIshDaBest.FreedomBot.Commands;

import com.FoxIshDaBest.FreedomBot.BotUtil;
import com.FoxIshDaBest.FreedomBot.FreedomBot;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_admintool implements CommandExecutor {

    private FreedomBot plugin;

    public Command_admintool(FreedomBot plugin) {
        FreedomBot.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        
        if (TFM_AdminList.isSuperAdmin(sender) && args.length == 0) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "purgeall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setl");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "nickclean");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "potion clearall");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rd");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "invis smite");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "opall -c");
            sender.sendMessage(BotUtil.BOTPREFIX + "You have used the admintool command.");
        }

        return true;

    }

}
