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




public class TraitBloodSacrifice extends Trait implements EventInterface {
	public TraitBloodSacrifice() {
		super(new ResourceLocation("additionaltraits", "blood_sacrifice"), 0, 0, 
				new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
				new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
	}
	
	
	
	public static final UUID MODIFIER_UUID = UUID.fromString("b181528e-3908-42f3-b36d-c1fecb4354aa");
	public static final UUID MODIFIER_UUID2 = UUID.fromString("64da2949-f3fb-4a99-97ce-4cf72f5aadc9");
	
	private boolean failsafe = false;

	

	@Override
	public void onUnlock(EntityPlayer player) {
		
		IAttributeInstance luck = player.getEntityAttribute(SharedMonsterAttributes.LUCK);
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = luck.getModifier(MODIFIER_UUID);
		AttributeModifier modifier2 = maxHealth.getModifier(MODIFIER_UUID2);
		modifier = new AttributeModifier(MODIFIER_UUID, "Blood Sacrifice Luck Increase", 10.0D, 0);
		modifier2 = new AttributeModifier(MODIFIER_UUID2, "Blood Sacrifice Max HP Reduction", -2.0D, 0);

		luck.applyModifier(modifier);
		maxHealth.applyModifier(modifier2);
		failsafe = true;
			
			
	}
	
	@Override
	public void onLock(EntityPlayer player) {
		IAttributeInstance luck = player.getEntityAttribute(SharedMonsterAttributes.LUCK);
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = luck.getModifier(MODIFIER_UUID);
		AttributeModifier modifier2 = maxHealth.getModifier(MODIFIER_UUID2);
		modifier = new AttributeModifier(MODIFIER_UUID, "Blood Sacrifice Luck Increase", 10.0D, 0);
		modifier2 = new AttributeModifier(MODIFIER_UUID2, "Blood Sacrifice Max HP Reduction", -2.0D, 0);
			
		luck.removeModifier(modifier);
		maxHealth.removeModifier(modifier2);
		failsafe = false;
			
			
	}
			

	
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {

	EntityPlayer player = event.player;
	IAttributeInstance luck = player.getEntityAttribute(SharedMonsterAttributes.LUCK);
	IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
	AttributeModifier modifier = luck.getModifier(MODIFIER_UUID);
	AttributeModifier modifier2 = maxHealth.getModifier(MODIFIER_UUID2);
	modifier = new AttributeModifier(MODIFIER_UUID, "Blood Sacrifice Luck Increase", 10.0D, 0);
	modifier2 = new AttributeModifier(MODIFIER_UUID2, "Blood Sacrifice Max HP Reduction", -2.0D, 0);
	
	if(failsafe == true) {
		
		luck.applyModifier(modifier);
		maxHealth.applyModifier(modifier2);

	}

	
}
	
}

