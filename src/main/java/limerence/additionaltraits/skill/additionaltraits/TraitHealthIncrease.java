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

public class TraitHealthIncrease extends Trait implements EventInterface {
	public TraitHealthIncrease() {
		super(new ResourceLocation("additionaltraits", "health_increase"), 3, 0, 
				new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
				new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
	}
	
	
	
	public static final UUID MODIFIER_UUID = UUID.fromString("73b3337b-1002-4fab-b31f-791becd4ceb5");
	private boolean failsafe = false;
	

	@Override
	public void onUnlock(EntityPlayer player) {
		
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = maxHealth.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Defense Health", 4.0D, 0);

		maxHealth.applyModifier(modifier);
		failsafe = true;
			
			
	}
	
	@Override
	public void onLock(EntityPlayer player) {
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = maxHealth.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Defense Health", 4.0D, 0);
			
		maxHealth.removeModifier(modifier);
		failsafe = false;
			
			
	}
			

	
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
	EntityPlayer player = event.player;
	IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
	AttributeModifier modifier = maxHealth.getModifier(MODIFIER_UUID);
	modifier = new AttributeModifier(MODIFIER_UUID, "Defense Health", 4.0D, 0);
	
	if(failsafe == true) {

		maxHealth.applyModifier(modifier);

	}

	
}
	
}


