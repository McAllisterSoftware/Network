package xyz.mcallister.test;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import xyz.mcallister.test.listeners.UserLoggedInListener;

/**
 * Created by sethm on 10/12/2016.
 */
public class Test
{
    private Plugin plugin;

    public Test(Plugin plugin)
    {
        this.plugin = plugin;

        Bukkit.getServer().getPluginManager().registerEvents(new UserLoggedInListener(), plugin);
    }

    public Plugin getPlugin()
    {
        return plugin;
    }
}
