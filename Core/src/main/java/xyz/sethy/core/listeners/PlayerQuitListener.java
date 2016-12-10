package xyz.sethy.core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.mcallister.api.API;
import xyz.sethy.core.framework.user.CoreUser;
import xyz.sethy.core.framework.user.UserManager;

/**
 * Created by sethm on 10/12/2016.
 */
public class PlayerQuitListener implements Listener
{
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        UserManager manager = (UserManager) API.getUserManager();
        CoreUser user = (CoreUser) manager.findByUUID(event.getPlayer().getUniqueId());
        manager.unloadUser(user);
    }
}
