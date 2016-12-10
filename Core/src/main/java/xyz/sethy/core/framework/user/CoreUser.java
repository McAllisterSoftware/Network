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
    private String lastServer;
    private AtomicBoolean needsSave;

    public CoreUser(UUID uuid)
    {
        this.uuid = uuid;
        this.name = "unknown";
        this.lastIP = "unknown";
        this.lastServer = "unknown";
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
    public String saveToString(boolean redis)
    {
        StringBuilder user = new StringBuilder();
        user.append("UUID:").append(this.getUUID().toString()).append("\n");
        user.append("Name:").append(this.getName()).append("\n");
        user.append("LastIP:").append(this.getLastIP()).append("\n");
        user.append("LastServer:").append(this.getLastServer()).append("\n");

        return user.toString();
    }

    @Override
    public String getLastServer()
    {
        return this.lastServer;
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

    @Override
    public void loadFromString(String string)
    {
        final String[] split2 = string.split("\n");
        for(final String line : split2)
        {
            final String identifier = line.substring(0, line.indexOf(58));
            final String[] lineParts = line.substring(line.indexOf(58)).split(",");
            if(identifier.equalsIgnoreCase("UUID"))
                this.uuid = UUID.fromString(lineParts[0].replace(":", ""));
            if(identifier.equalsIgnoreCase("Name"))
                this.setName(lineParts[0].replace(":", ""));
            if(identifier.equalsIgnoreCase("LastIP"))
                this.setLastIP(lineParts[0].replace(":", ""));
            if(identifier.equalsIgnoreCase("LastServer"))
                this.setLastServer(lineParts[0].replace(":", ""));
        }
    }

    @Override
    public void setLastServer(String server)
    {
        this.lastServer = server;
    }
}
