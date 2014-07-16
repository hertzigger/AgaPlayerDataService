package com.craftaga.agaplayerdataservice;

import com.craftaga.agaplayerdataservice.valueobjects.IPlayers;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * description
 *
 * @author Jonathan
 * @since 16/07/2014
 */
public class PlayerDataClientHandler extends ChannelInboundHandlerAdapter {

    private IPlayers players;

    public PlayerDataClientHandler(IPlayers players)
    {
        this.players = players;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        ByteBuf m = (ByteBuf) msg; // (1)
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        } finally {
            m.release();
        }
        System.out.println("Ping");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
