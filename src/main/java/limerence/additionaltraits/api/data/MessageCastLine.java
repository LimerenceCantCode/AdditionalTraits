package limerence.additionaltraits.api.data;

import io.netty.buffer.ByteBuf;
import limerence.additionaltraits.skill.additionaltraits.TraitNaturalFisher;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageCastLine implements IMessage, IMessageHandler<MessageCastLine, IMessage> {


	public MessageCastLine() {}

	@Override
	public void fromBytes(ByteBuf buf) {}

	@Override
	public void toBytes(ByteBuf buf) {}

	@Override
	public IMessage onMessage(MessageCastLine message, MessageContext ctx)
	{
		if (Side.SERVER == ctx.side)
		{	
		
	
		EntityPlayerMP data = ctx.getServerHandler().player;
		EntityFishHook hook = data.fishEntity;
	

		data.getServerWorld().addScheduledTask(() -> {TraitNaturalFisher.Decider(data, false);});

		
		
		}
		return null;
	}


}
	
	


