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

public class TraitDamageIncrease extends Trait implements EventInterface {
		public TraitDamageIncrease() {
			super(new ResourceLocation("additionaltraits", "damage_increase"), 0, 0, 
					new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
					new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
		}
	
		public static final UUID MODIFIER_UUID = UUID.fromString("f498a2c9-10d0-43a6-883b-7277b177ff95");

		
		private boolean failsafe = false;

		

		@Override
		public void onUnlock(EntityPlayer player) {
			IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
			modifier = new AttributeModifier(MODIFIER_UUID, "Combat Tree Damage Buff", 10.0D, 0);
			dmg.applyModifier(modifier);
						
		}
		
		@Override
		public void onLock(EntityPlayer player) {
			IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
			modifier = new AttributeModifier(MODIFIER_UUID, "Combat Tree Damage Buff", 10.0D, 0);
			dmg.removeModifier(modifier);
		}
				

		
		@Override
		public void onPlayerRespawn(PlayerRespawnEvent event) {

		EntityPlayer player = event.player;
		IAttributeInstance dmg = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		AttributeModifier modifier = dmg.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Combat Tree Damage Buff", 10.0D, 0);
		dmg.applyModifier(modifier);
		
		if(failsafe == true) {
			
			dmg.applyModifier(modifier);

		}

		
	}
	

}
