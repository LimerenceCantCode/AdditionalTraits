package limerence.additionaltraits.skill.additionaltraits;



import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;


import net.minecraft.util.ResourceLocation;

public class TraitCombatXP extends Trait implements EventInterface {
	public TraitCombatXP() {
		super(new ResourceLocation("additionaltraits", "combat_xp"), 0, 1, 
				new ResourceLocation("additionaltraits", "additionaltraits"),
				1, new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
	}

	public void onKillMob(LivingDeathEvent event) {
		int mobHP = (int) event.getEntityLiving().getMaxHealth();
		int playerHP = (int) ((EntityPlayer) event.getSource().getTrueSource()).getMaxHealth();
		int givenXP = mobHP / 10;

		
		if (!event.isCanceled() && event.getEntity() instanceof IMob
				&& event.getSource().getTrueSource() instanceof EntityPlayer) 
		{
			((EntityPlayer) event.getSource().getTrueSource()).addExperience(givenXP);
		}

		if (!event.isCanceled() && mobHP > playerHP * 10 && event.getSource().getTrueSource() instanceof EntityPlayer)
		{
			((EntityPlayer) event.getSource().getTrueSource()).addExperience(mobHP);
		}
		
		
	}
}