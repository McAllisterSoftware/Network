package xyz.mcallister.test.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.mcallister.api.API;
import xyz.mcallister.api.framework.user.IUserManager;
import xyz.mcallister.api.framework.user.User;

/**
 * Created by sethm on 11/12/2016.
 */
public class TestCommand implements CommandExecutor
{
    /**
     * UserManager to find users.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings)
    {
        Player player = (Player)sender;

        IUserManager iUserManager = API.getUserManager();
        User user = iUserManager.findByUUID(player.getUniqueId());

        player.sendMessage("Last Name: " + user.getName());
        player.sendMessage("Last Server: " + user.getLastServer());
        player.sendMessage("Last IP: " + user.getLastIP());
        return false;
    }
}
