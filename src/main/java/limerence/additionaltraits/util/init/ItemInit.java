package limerence.additionaltraits.util.init;

import java.util.ArrayList;
import java.util.List;

import limerence.additionaltraits.AdditionalTraits;
import limerence.additionaltraits.item.ItemNatHook;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final Item NATHOOK = new ItemNatHook("NatHook");
	
//	private static Item InitItems(Item item, String name){
		//item.setRegistryName(name);
	//	ForgeRegistries.ITEMS.register(item);
	//	return item;
	//}
	
	//@SubscribeEvent //final RegistryEvent.Register<Item> event
	//public static void RegisterItems() {
	//	InitItems(NATHOOK, "NatHook");
	//final Item[] items = {
			//NATHOOK
	//};
		//System.out.println("Item Registration Complete!");
	//final IForgeRegistry<Item> registry = event.getRegistry();

	//for (final Item item : items) {
		//registry.register(item);
		//ITEMS.add(item);
	//}
	
	//}
	
	
	
	
	
	
	
	
	
}
