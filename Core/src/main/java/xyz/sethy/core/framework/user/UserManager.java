package xyz.sethy.core.framework.user;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import xyz.mcallister.api.framework.user.IUserManager;
import xyz.mcallister.api.framework.user.User;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by sethm on 09/12/2016.
 */
public class UserManager implements IUserManager
{
    private final List<User> users;
    private final Jedis jedis;

    public UserManager()
    {
        this.users = Lists.newArrayList();
        this.jedis = new Jedis();
    }

    @Override
    public User findByUUID(UUID uuid)
    {
        return users.stream().filter(u -> u.getUUID().equals(uuid)).findAny().orElse(null);
    }

    @Override
    public List<User> getAllUsers()
    {
        return Collections.unmodifiableList(users);
    }

    @Override
    public void createUser(User user)
    {
        this.users.add(user);
    }

    @Override
    public void load(User user)
    {
        this.users.add(user);
    }

    @Override
    public void unloadUser(User user)
    {
        this.users.remove(user);
    }

    @Override
    public void deleteUser(User user)
    {
        Pipeline pipeline = jedis.pipelined();
        pipeline.del("network.users." + user.getUUID().toString());
        users.remove(user);
    }

    @Override
    public User loadFromRedis(UUID uuid)
    {
        Pipeline pipeline = jedis.pipelined();
        for(String key : pipeline.keys("network.users.*").get())
        {
            String id = key.replace("network.users.", "");
            if(id.equalsIgnoreCase(uuid.toString()))
            {
                CoreUser coreUser = new CoreUser(uuid);
                coreUser.loadFromString(pipeline.get(key).get());
                this.users.add(coreUser);
                return coreUser;
            }
        }
        return null;
    }
}
