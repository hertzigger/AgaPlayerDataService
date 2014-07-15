package com.craftaga.agaplayerdataservice.valueobjects;

/**
 * description
 *
 * @author Jonathan
 * @since 15/07/2014
 */
public class PlayerData implements IPlayerData {
    private String username;
    private String displayName;
    private long onlineTime;
    private long onlineTimeToday;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public long getOnlineTime() {
        return onlineTime;
    }

    @Override
    public void setOnlineTime(long onlineTime) {
        this.onlineTime = onlineTime;
    }

    @Override
    public long getOnlineTimeToday() {
        return onlineTimeToday;
    }

    @Override
    public void setOnlineTimeToday(long onlineTimeToday) {
        this.onlineTimeToday = onlineTimeToday;
    }
}
