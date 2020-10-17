package limerence.additionaltraits.skill.additionaltraits;

import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

public class TraitBonusSaturation extends Trait implements EventInterface {

		public TraitBonusSaturation() {
			super(new ResourceLocation("additionaltraits", "bonus_saturation"), 4, 1, 
					new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
					new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
		}
		
		
		 public void onEat(LivingEntityUseItemEvent.Finish event) {
			
			 if (event.getItem().getItem() instanceof ItemFood) {
			
				 ItemFood food = (ItemFood) event.getItem().getItem();
				 
				 float Saturation = food.getSaturationModifier(event.getItem())/2;
				 
				 
				 if (event.getEntityLiving() instanceof EntityPlayer) {
					EntityPlayer Player = (EntityPlayer) event.getEntityLiving();
					
					Player.getFoodStats().setFoodSaturationLevel(Player.getFoodStats().getSaturationLevel()+Saturation);
				 }
				
				 
			 }
			
			 
		 }
		
		
		
		
		
}
