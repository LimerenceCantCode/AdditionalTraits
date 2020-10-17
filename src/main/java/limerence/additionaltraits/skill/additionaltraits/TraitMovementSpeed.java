package limerence.additionaltraits.skill.additionaltraits;

import java.util.UUID;

import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class TraitMovementSpeed extends Trait implements EventInterface {
		public TraitMovementSpeed() {
			super(new ResourceLocation("additionaltraits", "movement_increase"), 4, 3, 
					new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
					new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
		}
	
		public static final UUID MODIFIER_UUID = UUID.fromString("d08e238e-aa16-4338-8e37-9d2dd77f29f2");
		
		private boolean failsafe = false;

		

		@Override
		public void onUnlock(EntityPlayer player) {
			IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
			modifier = new AttributeModifier(MODIFIER_UUID, "Agility Movement Buff", 10.0D, 0);
			dmg.applyModifier(modifier);
						
		}
		
		@Override
		public void onLock(EntityPlayer player) {
			IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
			AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
			modifier = new AttributeModifier(MODIFIER_UUID, "Agility Movement Buff", 10.0D, 0);
			dmg.removeModifier(modifier);
		}
				

		
		@Override
		public void onPlayerRespawn(PlayerRespawnEvent event) {

		EntityPlayer player = event.player;
		IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Agility Movement Buff", 10.0D, 0);
		dmg.applyModifier(modifier);
		
		if(failsafe == true) {
			
			dmg.applyModifier(modifier);

		}

		
	}
	

}
