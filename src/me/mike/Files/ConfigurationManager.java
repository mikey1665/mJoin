package me.mike.Files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.mike.Main;

public class ConfigurationManager {

	private Main plugin = Main.getPlugin(Main.class);

	String configName = "Messages.yml";

	public FileConfiguration msgData;
	public File msgFile;

	public void setup() {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		msgFile = new File(plugin.getDataFolder(), configName);
		if (!msgFile.exists()) {
			plugin.saveResource(configName, false);
			Bukkit.getServer().getConsoleSender()
					.sendMessage(ChatColor.GREEN + configName + " successfully loaded!");
		}
		msgData = YamlConfiguration.loadConfiguration(msgFile);
	}

	public void saveData() {
		try {
			msgData.save(msgFile);
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + configName + " successfully saved!");
		} catch (IOException e) {
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + configName + " could not be saved!");
		}
	}

	public void reloadData() {
		msgData = YamlConfiguration.loadConfiguration(msgFile);
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + configName + " has been reloaded!");
	}

	public FileConfiguration getData() {
		return msgData;
	}

}
