package limerence.additionaltraits.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

import javax.annotation.Nonnull;

import limerence.additionaltraits.AdditionalTraits;
import limerence.additionaltraits.entity.EntityNatFishHook;


@Mod.EventBusSubscriber(modid = "additionaltraits")
public class RegistryHandler
{


  /*  public static void postInitRegistries()
    {
    	//BiomeInit.unregisterBiomes();
    	// ItemInit.RegisterItems();
    	// System.out.println("Attempting Item Registry");
    	//event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    	//event.getRegistry().register(new ResourceLocation(AdditionalTraits.MOD_ID + ":" +"NatHook"), EntityNatFishHook.class, "NatHook", AdditionalTraits.instance, 64, 1, true);
    	//event.getRegistry().registerAll(EntityInit.ENTITIES.toArray(new EntityEntry[0]))
    }*/
   
    public static void serverRegistries(FMLServerStartingEvent event)
    {
    }
    
  /*  @SubscribeEvent
    public static void onItemRegister(@Nonnull final RegistryEvent.Register<Item> event){
    final IForgeRegistry<Item> registry = event.getRegistry();
    registry.registerAll(
			
		);
	
    }*/

    @SubscribeEvent
    public static void onRegisterEntitiesEvent(@Nonnull final RegistryEvent.Register<EntityEntry> event) {
    	int id = 0;
    	final ResourceLocation natfishhook = new ResourceLocation("at", "natfishhook");
    	
    	
    	event.getRegistry().registerAll(
    			EntityEntryBuilder.create()
    				.entity(EntityNatFishHook.class)
    				.id(natfishhook, id++)
    				.name("NatHook")
    				.tracker(64, 1, true)
    				.build()
    				);
    	
    	
    	
    	
    	
    	System.out.println("Entities Registered");
    
    
    }
    
    

}
