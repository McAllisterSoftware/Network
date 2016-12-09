package xyz.sethy.core.framework.user;

import xyz.mcallister.api.framework.user.User;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by sethm on 09/12/2016.
 */
public class CoreUser implements User
{
    private UUID uuid;
    private String name;
    private String lastIP;
    private AtomicBoolean needsSave;

    public CoreUser(UUID uuid)
    {
        this.uuid = uuid;
        this.name = "unknown";
        this.lastIP = "unknown";
        this.needsSave = new AtomicBoolean(true);
    }


    @Override
    public UUID getUUID()
    {
        return this.uuid;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getLastIP()
    {
        return this.lastIP;
    }

    @Override
    public AtomicBoolean needsSave()
    {
        return this.needsSave;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void flagForSave()
    {
        this.needsSave.getAndSet(true);
    }

    @Override
    public void setSave(boolean save)
    {
        this.needsSave.getAndSet(save);
    }

    @Override
    public void setLastIP(String ip)
    {
        this.lastIP = ip;
    }
}
