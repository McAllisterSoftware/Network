package xyz.sethy.core.framework;

import org.bukkit.plugin.Plugin;
import xyz.mcallister.api.framework.IFramework;
import xyz.sethy.core.framework.user.UserManager;

/**
 * Created by sethm on 09/12/2016.
 */
public class Framework implements IFramework
{
    private final Plugin plugin;
    private final UserManager userManager;

    public Framework(Plugin plugin)
    {
        this.plugin = plugin;
        this.userManager = new UserManager();
    }


    @Override
    public Plugin getPlugin()
    {
        return this.plugin;
    }

    @Override
    public UserManager getUserManager()
    {
        return userManager;
    }
}
