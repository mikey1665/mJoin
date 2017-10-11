package me.mike;

import org.bukkit.plugin.java.JavaPlugin;

import me.mike.Files.ConfigurationManager;

/*
 * mJoin; Simple lightweight plugin to 
 * change join/leave messages
 * @author: mike1665
 * 
 */

public class Main extends JavaPlugin{
	
	public Main plugin;
	public static ConfigurationManager mngr;
	
	@Override
	public void onEnable() {
		plugin = this;
		loadConfigManager();
		getCommand("mjoin").setExecutor(new EditMessageCommand());
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public void loadConfigManager() {
		mngr = new ConfigurationManager();
		mngr.setup();
		mngr.saveData();
		mngr.reloadData();
	}
	
	public ConfigurationManager getConfiguration() {
		return mngr;
	}
}
