package xyz.mcallister.test.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import xyz.mcallister.api.framework.event.UserLoggedInEvent;
import xyz.mcallister.api.framework.user.User;

/**
 * Created by sethm on 10/12/2016.
 */
public class UserLoggedInListener implements Listener
{
    /**
     * Should be used instead of the PlayerLoginEvent.
     */
    @EventHandler
    public void onUserLogIn(UserLoggedInEvent event)
    {
        User user = event.getUser();
    }
}
