package com.craftaga.agaplayerdataservice.valueobjects;

/**
 * description
 *
 * @author Jonathan
 * @since 15/07/2014
 */
public interface IPlayerData {
    String getUsername();

    void setUsername(String username);

    String getDisplayName();

    void setDisplayName(String displayName);

    long getOnlineTime();

    void setOnlineTime(long onlineTime);

    long getOnlineTimeToday();

    void setOnlineTimeToday(long onlineTimeToday);
}
