package limerence.additionaltraits.util;

import codersafterdark.reskillable.api.unlockable.IAbilityEventHandler;
import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent.Open;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickEmpty;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.event.village.MerchantTradeOffersEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public interface EventInterface extends IAbilityEventHandler {
	
	default void onPlayerRespawn(PlayerRespawnEvent event) {}

	default void onContainerOpen(Open event) {}

	default void onPlayerEnchant(EnchantmentLevelSetEvent event) {}

	default void onTrade(MerchantTradeOffersEvent event) {}
	
	default void onXPCollect(PlayerPickupXpEvent event) {}
	
	default void onEat(LivingEntityUseItemEvent.Finish event) {}
	


	
}
