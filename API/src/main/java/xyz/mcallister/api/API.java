package xyz.mcallister.api;

import xyz.mcallister.api.framework.IFramework;
import xyz.mcallister.api.framework.user.IUserManager;

/**
 * Created by sethm on 09/12/2016.
 */
public abstract class API
{
    private static IFramework framework;

    public static IUserManager getUserManager()
    {
        return  framework.getUserManager();
    }
}
