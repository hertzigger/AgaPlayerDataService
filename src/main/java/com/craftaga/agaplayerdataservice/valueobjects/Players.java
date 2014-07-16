package com.craftaga.agaplayerdataservice.valueobjects;

import java.util.ArrayList;

/**
 * description
 *
 * @author Jonathan
 * @since 15/07/2014
 */
public class Players implements IPlayers {
    private ArrayList<IPlayerData> playersData;

    public Players()
    {
        this.playersData = new ArrayList<IPlayerData>();
    }

    @Override
    public void addPlayer(IPlayerData playerData) {
        this.playersData.add(playerData);
    }
}
