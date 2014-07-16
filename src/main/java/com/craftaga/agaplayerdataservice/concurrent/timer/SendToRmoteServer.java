package com.craftaga.agaplayerdataservice.concurrent.timer;

import com.craftaga.agabacbone.commands.queue.CommandQueue;
import com.craftaga.agabacbone.commands.queue.QueueConstructor;
import com.craftaga.agabacbone.concurrent.IPluginManager;
import com.craftaga.agaplayerdataservice.commands.PopulateValueObject;
import com.craftaga.agaplayerdataservice.commands.SendValueObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description
 *
 * @author Jonathan
 * @since 16/07/2014
 */
public class SendToRmoteServer extends QueueConstructor {

    public SendToRmoteServer(ClassPathXmlApplicationContext context, IPluginManager pluginManager) {
        super(context, pluginManager);
    }

    @Override
    public CommandQueue getCommandQueue() {
        CommandQueue commandQueue = new CommandQueue();
        PopulateValueObject populateValueObject = new PopulateValueObject(commandQueue, getPluginManger().getSessionHandler());
        SendValueObject sendValueObject = new SendValueObject(commandQueue, populateValueObject);
        commandQueue.addCommand(populateValueObject);
        commandQueue.addCommand(sendValueObject);
        return commandQueue;
    }
}
