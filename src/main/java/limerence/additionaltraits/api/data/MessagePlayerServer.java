package limerence.additionaltraits.api.data;

import io.netty.buffer.ByteBuf;
import limerence.additionaltraits.entity.EntityNatFishHook;
import limerence.additionaltraits.skill.additionaltraits.TraitNaturalFisher;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessagePlayerServer implements IMessage, IMessageHandler<MessagePlayerServer, IMessage> {


		public MessagePlayerServer() {}

		@Override
		public void fromBytes(ByteBuf buf) {}

		@Override
		public void toBytes(ByteBuf buf) {}
		@Override
		public IMessage onMessage(MessagePlayerServer message, MessageContext ctx)
		{
			if (Side.SERVER == ctx.side)
			{	
			EntityPlayerMP Player = ctx.getServerHandler().player;
			Player.getServerWorld().addScheduledTask(() -> {EntityNatFishHook.resetID(Player);});
			}
			//TODO: Find a way to pull EntityPlayerSP
			
			
			return null;
		}


	}
		
		