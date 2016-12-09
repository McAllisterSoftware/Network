package xyz.mcallister.api.framework.user;

import java.util.List;
import java.util.UUID;

/**
 * Created by sethm on 09/12/2016.
 */
public interface IUserManager
{
    public User findByUUID(UUID uuid);
    public List<User> getAllUsers();

    void createUser(User user);
    void load(User user);
    void unloadUser(User user);
    void deleteUser(String id);
    void loadFromRedis(UUID uuid);
}
