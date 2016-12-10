package xyz.mcallister.api.framework.user;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by sethm on 09/12/2016.
 */
public interface User
{
    UUID getUUID();
    String getName();
    String getLastIP();
    AtomicBoolean needsSave();
    String saveToString(boolean redis);
    String getLastServer();

    void setName(String name);
    void flagForSave();
    void setSave(boolean save);
    void setLastIP(String ip);
    void loadFromString(String string);
    void setLastServer(String server);
}
