package limerence.additionaltraits.util.handlers;

import limerence.additionaltraits.AdditionalTraits;
import limerence.additionaltraits.api.data.MessageCastLine;
import limerence.additionaltraits.api.data.MessagePlayerServer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler{
	
	
	    public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel("additionaltraits");
    


	    public static void init()
	    {
	    	instance.registerMessage(MessageCastLine.class, MessageCastLine.class, 5, Side.SERVER);
	    	instance.registerMessage(MessagePlayerServer.class, MessagePlayerServer.class, 6, Side.SERVER);

	    }
	}


