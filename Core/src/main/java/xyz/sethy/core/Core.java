package xyz.sethy.core;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.sethy.core.framework.Framework;

/**
 * Created by sethm on 09/12/2016.
 */
public class Core extends JavaPlugin
{
    private Framework framework;

    public void onEnable()
    {
        this.framework = new Framework(this);
    }

    public Framework getFramework()
    {
        return framework;
    }
}
