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


public class TraitPact extends Trait implements EventInterface {
	
	public TraitPact() {
		super(new ResourceLocation("additionaltraits", "pact"), 1, 0, new ResourceLocation("additionaltraits", "additionaltraits"),
			1, new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
		}

	public static final UUID MODIFIER_UUID = UUID.fromString("000d5ef0-b92b-11ea-81d1-1ff5984171f7");
	public static final UUID MODIFIER_UUID2 = UUID.fromString("29cc66d5-b9b6-4f77-9f52-37ca5275cb79");
	private boolean failsafe = false;
	
	@Override
	public void onUnlock(EntityPlayer player) {
		IAttributeInstance attackSpeed = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED);
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = attackSpeed.getModifier(MODIFIER_UUID);
		AttributeModifier modifier2 = maxHealth.getModifier(MODIFIER_UUID2);
		modifier = new AttributeModifier(MODIFIER_UUID, "Pact Attack Speed Increase", 6.0D, 0);
		modifier2 = new AttributeModifier(MODIFIER_UUID2, "Pact Blood Toll", -4.0D, 0);

		attackSpeed.applyModifier(modifier);
		maxHealth.applyModifier(modifier2);
		failsafe = true;
			
	}
	
	@Override
	public void onLock(EntityPlayer player) {
		IAttributeInstance attackSpeed = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED);
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = attackSpeed.getModifier(MODIFIER_UUID);
		AttributeModifier modifier2 = maxHealth.getModifier(MODIFIER_UUID2);
		modifier = new AttributeModifier(MODIFIER_UUID, "Pact Attack Speed Increase", 6.0D, 0);
		modifier2 = new AttributeModifier(MODIFIER_UUID2, "Pact Blood Toll", -4.0D, 0);

		attackSpeed.removeModifier(modifier);
		maxHealth.removeModifier(modifier2);
		failsafe = false;
			
	}
	
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {

	EntityPlayer player = event.player;
	IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
	IAttributeInstance attackSpeed = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED);
	AttributeModifier modifier = attackSpeed.getModifier(MODIFIER_UUID);
	AttributeModifier modifier2 = maxHealth.getModifier(MODIFIER_UUID2);
	modifier = new AttributeModifier(MODIFIER_UUID, "Pact Attack Speed Increase", 6.0D, 0);
	modifier2 = new AttributeModifier(MODIFIER_UUID2, "Pact Blood Toll", -4.0D, 0);
	
	
	if(failsafe == true) {

		attackSpeed.applyModifier(modifier);
		maxHealth.applyModifier(modifier2);	
		
	}}
	
}
