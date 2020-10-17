package limerence.additionaltraits.skill.additionaltraits;

import java.util.UUID;

import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class TraitBlackBlood extends Trait implements EventInterface {
	
	public TraitBlackBlood () {
		
		super(new ResourceLocation("additionaltraits", "black_blood"), 3, 1, 
				new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
				new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
	}
	
	public static final UUID MODIFIER_UUID = UUID.fromString("3d06e61e-c7c7-11ea-87d0-0242ac130003");

	
	private boolean failsafe = false;
	
	
	
	
	@Override
	public void onHurt(LivingHurtEvent event) {
		float Damage = event.getAmount();
		float Health = event.getEntityLiving().getMaxHealth();
		float RNG = event.getEntityLiving().getRNG().nextFloat();
		double Luck = (event.getEntityLiving().getEntityAttribute(SharedMonsterAttributes.LUCK).getAttributeValue())/100;
		float Wither = (float) (Luck + RNG);
		
		
		
		if (!event.isCanceled() && event.getEntityLiving() instanceof EntityPlayer && event.getSource().getTrueSource() instanceof EntityLivingBase) {
			EntityLivingBase Attacker = (EntityLivingBase) event.getSource().getTrueSource();
			Attacker.attackEntityFrom(DamageSource.causeThornsDamage(Attacker), Math.max(1, Damage/10));
			if (Wither >= 0.7F || Damage == Health/10) {
			Attacker.addPotionEffect(new PotionEffect(MobEffects.WITHER, 100, 5));
			
			}

		}
			

			
		
	}

	

	@Override
	public void onUnlock(EntityPlayer player) {
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = maxHealth.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Black Blood Health Cost", -4.0D, 0);
		maxHealth.applyModifier(modifier);
		failsafe = true;
			
			
	}
	
	@Override
	public void onLock(EntityPlayer player) {
		IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
		AttributeModifier modifier = maxHealth.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Black Blood Health Cost", -4.0D, 0);
		maxHealth.removeModifier(modifier);
		failsafe = false;
			
			
	}
			

	
	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
	EntityPlayer player = event.player;
	IAttributeInstance maxHealth = player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
	AttributeModifier modifier = maxHealth.getModifier(MODIFIER_UUID);
	modifier = new AttributeModifier(MODIFIER_UUID, "Black Blood Health Cost", -4.0D, 0);
	if(failsafe == true) {
		maxHealth.applyModifier(modifier);
	}

	}
	
	
}


