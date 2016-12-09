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

    void setName(String name);
    void flagForSave();
    void setSave(boolean save);
    void setLastIP(String ip);
}
