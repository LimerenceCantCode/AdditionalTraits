package limerence.additionaltraits.api.data;

import codersafterdark.reskillable.api.data.PlayerData;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent.Open;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickEmpty;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.village.MerchantTradeOffersEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;


public class PlayerDataExtension extends PlayerData {
	
	public PlayerDataExtension(EntityPlayer player) {
		super(player);
		// TODO Auto-generated constructor stub
	}
	

	
	
    public void respawn(PlayerRespawnEvent event) {
    	System.out.println("DATA RESPAWN");

        forEachEventHandler(h -> {
        	if(h instanceof EventInterface){
        	((EventInterface) h).onPlayerRespawn(event);
        	}
        	}
        	);
    }
    
    public void open(Open event) {
    	System.out.println("CONTAINEROPEN");

        forEachEventHandler(h -> {
        	if(h instanceof EventInterface){
        	((EventInterface) h).onContainerOpen(event);
        	}
        	}
        	);
    }
    
    public void enchant(EnchantmentLevelSetEvent event) {
    	System.out.println("EnchantEvent");
    	
        forEachEventHandler(h -> {
        	if(h instanceof EventInterface){
        	((EventInterface) h).onPlayerEnchant(event);
        	}
        	}
        	);
    }
    
    public void trade(MerchantTradeOffersEvent event) {

        forEachEventHandler(h -> {
        	if(h instanceof EventInterface){
        	((EventInterface) h).onTrade(event);
        	}
        	}
        	);
    }
    
    public void xp(PlayerPickupXpEvent event) {
    	System.out.println("PlayerPickupXpEvent");
    	
        forEachEventHandler(h -> {
        	if(h instanceof EventInterface){
        	((EventInterface) h).onXPCollect(event);
        	}
        	}
        	);
    }

    public void eat(LivingEntityUseItemEvent.Finish event) {
    	System.out.println("PlayerPickupXpEvent");
    	
        forEachEventHandler(h -> {
        	if(h instanceof EventInterface){
        	((EventInterface) h).onEat(event);
        	}
        	}
        	);
    }

    




	

}
