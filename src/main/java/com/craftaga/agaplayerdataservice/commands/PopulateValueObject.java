package com.craftaga.agaplayerdataservice.commands;

import com.craftaga.agabacbone.commands.Command;
import com.craftaga.agabacbone.commands.IValueHolderCommand;
import com.craftaga.agabacbone.commands.queue.CommandQueue;
import com.craftaga.agabacbone.session.ISessionHandler;
import com.craftaga.agaplayerdataservice.PlayerDataClientHandler;
import com.craftaga.agaplayerdataservice.valueobjects.IPlayerData;
import com.craftaga.agaplayerdataservice.valueobjects.IPlayers;
import com.craftaga.agaplayerdataservice.valueobjects.PlayerData;
import com.craftaga.agaplayerdataservice.valueobjects.Players;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.bukkit.entity.Player;

/**
 * Build value object for all players ready to be json-ised and sent
 *
 * @author Jonathan
 * @since 16/07/2014
 */
public class PopulateValueObject extends Command implements IValueHolderCommand<PlayerDataClientHandler> {

    private PlayerDataClientHandler playerDataClientHandler;
    private ISessionHandler sessionHandler;

    public PopulateValueObject(CommandQueue commandQueue, ISessionHandler sessionHandler) {
        super(commandQueue);
        this.sessionHandler = sessionHandler;
    }

    @Override
    public void execute()
    {
        IPlayers thePlayers = new Players();
        for(Player player : sessionHandler.getPlayers()) {
            IPlayerData playerData = new PlayerData();
            playerData.setDisplayName(player.getDisplayName());
            playerData.setUsername(player.getPlayerListName());
            thePlayers.addPlayer(playerData);
        }
        playerDataClientHandler = new PlayerDataClientHandler(thePlayers);
    }

    @Override
    public void setValue(PlayerDataClientHandler playerDataClientHandler) {
        this.playerDataClientHandler = playerDataClientHandler;
    }

    @Override
    public PlayerDataClientHandler getValue() {
        return playerDataClientHandler;
    }
}
