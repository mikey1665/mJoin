package me.mike;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener{
	
	public Main plugin = Main.getPlugin(Main.class);
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		String joinMsg = plugin.getConfiguration().getData().getString("join-message").replaceAll("%player%", event.getPlayer().getName().toString());
		event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMsg));
	}
	
	@EventHandler
	public void playerLeave(PlayerQuitEvent event) {
		String leaveMsg = plugin.getConfiguration().getData().getString("leave-message").replaceAll("%player%", event.getPlayer().getName().toString());
		event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', leaveMsg));
	}

}
