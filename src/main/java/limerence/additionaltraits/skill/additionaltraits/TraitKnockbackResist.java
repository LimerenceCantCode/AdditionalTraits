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

public class TraitKnockbackResist extends Trait implements EventInterface {
		public TraitKnockbackResist() {
			super(new ResourceLocation("additionaltraits", "knockback_resist"), 4, 4, 
					new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
					new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
		}
	
		public static final UUID MODIFIER_UUID = UUID.fromString("167bd7a0-fc0e-4d53-aba7-023df78e8be9");
		
		private boolean failsafe = false;

		

		@Override
		public void onUnlock(EntityPlayer player) {
			IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
			modifier = new AttributeModifier(MODIFIER_UUID, "Defense Knockback Resist", 10.0D, 0);
			dmg.applyModifier(modifier);
						
		}
		
		@Override
		public void onLock(EntityPlayer player) {
			IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
			modifier = new AttributeModifier(MODIFIER_UUID, "Defense Knockback Resist", 10.0D, 0);
			dmg.removeModifier(modifier);
		}
				

		
		@Override
		public void onPlayerRespawn(PlayerRespawnEvent event) {

		EntityPlayer player = event.player;
		IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
		AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Defense Knockback Resist", 10.0D, 0);
		dmg.applyModifier(modifier);
		
		if(failsafe == true) {
			
			dmg.applyModifier(modifier);

		}

		
	}
	

}