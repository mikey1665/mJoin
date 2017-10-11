package me.mike;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EditMessageCommand implements CommandExecutor{
	
	public Main plugin = Main.getPlugin(Main.class);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("mjoin.change") || sender.isOp()) {
			if(args.length == 0) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cCorrect Usage: /mjoin set {join/leave} {message}"));
				return false;
			} else {
				if(args.length == 1) {
					sender.sendMessage(ChatColor.RED + "Please specify your message type & message!");
					return false;
				}
				if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("join")) {
						StringBuilder str = new StringBuilder();
						for (int i = 2; i < args.length; i++) {
							str.append(args[i] + " ");
						}
						String message = str.toString();
						plugin.getConfiguration().getData().set("join-message", message);
						plugin.getConfiguration().saveData();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eJoin message set to: &r" + message));
						return true;
					}else if (args[1].equalsIgnoreCase("leave")) {
						StringBuilder str = new StringBuilder();
						for (int i = 2; i < args.length; i++) {
							str.append(args[i] + " ");
						}
						String message = str.toString();
						plugin.getConfiguration().getData().set("leave-message", message);
						plugin.getConfiguration().saveData();
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eLeave message set to: &r" + message));
						return true;
					} else {
						sender.sendMessage(ChatColor.RED + "Invalid set option!");
					}
				}
			}
		}
		return false;
	}

}
