package com.craftaga.agaplayerdataservice.commands;

import com.craftaga.agabacbone.commands.Command;
import com.craftaga.agabacbone.commands.IValueHolderCommand;
import com.craftaga.agabacbone.commands.queue.CommandQueue;
import com.craftaga.agaplayerdataservice.PlayerDataClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * Does the actual sending of data to target
 *
 * @author Jonathan
 * @since 16/07/2014
 */
public class SendValueObject extends Command {

    private IValueHolderCommand<PlayerDataClientHandler>  playerDataClientHandlerHolder;

    public SendValueObject(
            final CommandQueue commandQueue,
            final IValueHolderCommand<PlayerDataClientHandler> playerDataClientHandlerHolder
    )
    {
        super(commandQueue);
        this.playerDataClientHandlerHolder = playerDataClientHandlerHolder;
    }

    @Override
    public void execute()
    {
        String host = "craftaga.com";
        int port = 80;
        final PlayerDataClientHandler playerDataClientHandler = playerDataClientHandlerHolder.getValue();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(playerDataClientHandler);
                }
            });

            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();

            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            getDefaultCommandQueue().getPlugin().getPlugin().getLogger().info("Interrupt exception while trying to send" +
                    " data to " + host + this.getClass().getCanonicalName());
            getDefaultCommandQueue().getPlugin().getPlugin().getLogger().info(ExceptionUtils.getStackTrace(e));
        } finally {
            workerGroup.shutdownGracefully();
        }


    }
}
