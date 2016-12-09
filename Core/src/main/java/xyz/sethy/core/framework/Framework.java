package xyz.sethy.core.framework;

import org.bukkit.plugin.Plugin;
import xyz.mcallister.api.framework.IFramework;

/**
 * Created by sethm on 09/12/2016.
 */
public class Framework implements IFramework
{
    private final Plugin plugin;

    public Framework(Plugin plugin)
    {
        this.plugin = plugin;
    }


    @Override
    public Plugin getPlugin()
    {
        return this.plugin;
    }
}
