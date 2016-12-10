package xyz.sethy.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.mcallister.test.Test;
import xyz.sethy.core.framework.Framework;
import xyz.sethy.core.listeners.AsyncPlayerPreLoginListener;
import xyz.sethy.core.listeners.PlayerLoginListener;
import xyz.sethy.core.listeners.PlayerQuitListener;

/**
 * Created by sethm on 09/12/2016.
 */
public class Core extends JavaPlugin
{
    private Framework framework;

    public void onEnable()
    {
        this.framework = new Framework(this);
        this.setupListeners();
        new Test(this);
    }

    private void setupListeners()
    {
        Bukkit.getServer().getPluginManager().registerEvents(new AsyncPlayerPreLoginListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerLoginListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }

    public Framework getFramework()
    {
        return framework;
    }
}
