package limerence.additionaltraits;


import org.apache.logging.log4j.Logger;

import codersafterdark.reskillable.ReskillableModAccess;
import codersafterdark.reskillable.api.ReskillableAPI;
import limerence.additionaltraits.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = "additionaltraits", name = "Additional Traits", version = "1.12.2", acceptedMinecraftVersions = "[1.12.2]")
public class AdditionalTraits {
	
	@SidedProxy(serverSide = "limerence.additionaltraits.proxy.CommonProxy", clientSide = "limerence.additionaltraits.proxy.ClientProxy")
	public static CommonProxy proxy;
	public static Logger logger;
	
	public AdditionalTraits() {
		ReskillableAPI.setInstance(new ReskillableAPI(new ReskillableModAccess()));
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		proxy.serverStarting(event);
	}

	
}


