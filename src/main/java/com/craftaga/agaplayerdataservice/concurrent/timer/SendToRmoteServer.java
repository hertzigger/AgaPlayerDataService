package com.craftaga.agaplayerdataservice.concurrent.timer;

import com.craftaga.agabacbone.commands.queue.CommandQueue;
import com.craftaga.agabacbone.commands.queue.QueueConstructor;
import com.craftaga.agabacbone.concurrent.PluginManager;
import com.craftaga.agaplayerdataservice.commands.PopulateValueObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description
 *
 * @author Jonathan
 * @since 16/07/2014
 */
public class SendToRmoteServer extends QueueConstructor {

    public SendToRmoteServer(ClassPathXmlApplicationContext context, PluginManager pluginManager) {
        super(context, pluginManager);
    }

    @Override
    public CommandQueue getCommandQueue() {
        CommandQueue commandQueue = new CommandQueue();
        commandQueue.addCommand(new PopulateValueObject());
        return commandQueue;
    }
}
