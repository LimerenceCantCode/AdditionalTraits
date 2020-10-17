package limerence.additionaltraits.util.handlers;

import java.util.HashMap;
import java.util.List;

import codersafterdark.reskillable.api.requirement.RequirementCache;
import limerence.additionaltraits.api.data.PlayerDataExtension;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent.Open;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickEmpty;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.village.MerchantTradeOffersEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class PlayerDataHandlerExtension {
	
	private static HashMap<Integer, PlayerDataExtension> playerData = new HashMap<>();
	
	public static PlayerDataExtension get(EntityPlayer player) {
		  if (player == null) {
	            return null;
	        }
		  
		     int key = getKey(player);
		        if (!playerData.containsKey(key)) {
		            playerData.put(key, new PlayerDataExtension(player));
		        }
		  
	        PlayerDataExtension data = playerData.get(key);
	        if (data.playerWR.get() != player) {
	            NBTTagCompound cmp = new NBTTagCompound();
	            data.saveToNBT(cmp);
	            RequirementCache.removeCache(player.getUniqueID(), player.getEntityWorld().isRemote);
	            playerData.remove(key);
	            data = get(player);
	            data.loadFromNBT(cmp);
	        }

	        return data;
	    }

  private static int getKey(EntityPlayer player) {
      return player == null ? 0 : player.hashCode() << 1 + (player.getEntityWorld().isRemote ? 1 : 0);
  }

	public static class EventHandler {
    @SubscribeEvent
    public static void onRespawn(PlayerRespawnEvent event) {
            PlayerDataExtension data = (PlayerDataExtension) PlayerDataHandlerExtension.get((EntityPlayer) event.player);
            if (data != null) {
                 data.respawn(event);
            }
        }
    
    @SubscribeEvent
	public static void onContainerOpen(Open event) {
        PlayerDataExtension data = (PlayerDataExtension) PlayerDataHandlerExtension.get((EntityPlayer) event.getEntityPlayer());
        if (data != null) {
             data.open(event);
    }
    }
    
    @SubscribeEvent
	public static void onEnchantment(EnchantmentLevelSetEvent event) {
		
		List<EntityPlayer> players = event.getWorld().getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(event.getPos()).grow(9));
		EntityPlayer Player = players.get(0);
		
			
        PlayerDataExtension data = (PlayerDataExtension) PlayerDataHandlerExtension.get((EntityPlayer) Player);
        if (data != null) {
             data.enchant(event);
    }
    }
    
    @SubscribeEvent
 	public static void onTrade(MerchantTradeOffersEvent event) {
        PlayerDataExtension data = (PlayerDataExtension) PlayerDataHandlerExtension.get((EntityPlayer) event.getPlayer());
        if (data != null) {
             data.trade(event);
     }
     }

	
   
    @SubscribeEvent
 	public static void onXPCollect(PlayerPickupXpEvent event) {
        PlayerDataExtension data = (PlayerDataExtension) PlayerDataHandlerExtension.get((EntityPlayer) event.getEntityPlayer());
        if (data != null) {
             data.xp(event);
     }
     }


    @SubscribeEvent
 	public static void onEat(LivingEntityUseItemEvent.Finish event) {
        PlayerDataExtension data = (PlayerDataExtension) PlayerDataHandlerExtension.get((EntityPlayer) event.getEntity());
        if (data != null) {
             data.eat(event);
     }
     }










	}



}









