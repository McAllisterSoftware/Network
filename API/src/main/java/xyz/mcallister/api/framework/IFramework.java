package xyz.mcallister.api.framework;

import org.bukkit.plugin.Plugin;
import xyz.mcallister.api.framework.user.IUserManager;

/**
 * Created by sethm on 09/12/2016.
 */
public interface IFramework
{
    Plugin getPlugin();

    IUserManager getUserManager();
}
