package limerence.additionaltraits.skill.additionaltraits;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;


public class TraitDivineProtection extends Trait implements EventInterface {
	public TraitDivineProtection() {
		super(new ResourceLocation("additionaltraits", "divine_protection"), 0, 3, 
				new ResourceLocation("additionaltraits", "additionaltraits"),
				1, new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
	}
	
	private static final String TAG_NOHEARTS = "skillable:NoGoldHearts";

	

	
	
	public void onHurt(LivingHurtEvent event) { 
		EntityPlayer player = (EntityPlayer) event.getEntity();
		if (!event.isCanceled() && event.getEntityLiving() instanceof EntityPlayer) {
			

			player.getEntityData().setInteger(TAG_NOHEARTS, 80);

			
			}
		}
	

	//honest try this one out, onPlayerTick for events
	
	
	
	public void onPlayerTick(PlayerTickEvent event) {
		if (event.phase == Phase.END) {
		EntityLivingBase e = event.player;
		int CD = e.getEntityData().getInteger(TAG_NOHEARTS);

		
		if (CD > 0){event.player.getEntityData().setInteger(TAG_NOHEARTS, CD-1);}
		
		if (CD == 0 && e.getAbsorptionAmount() < 10 ) {
			if ((e.getAbsorptionAmount() < 10.0F) && (e.ticksExisted % 10 == 0) && e.getMaxHealth() == e.getHealth()) {
			e.setAbsorptionAmount(e.getAbsorptionAmount()+1.0F); 
			event.player.world.playSound((EntityPlayer)null, event.player.posX, event.player.posY, event.player.posZ, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CONVERTED, SoundCategory.PLAYERS, 0.50F, 15.0F);
			}
	
		}
	}
	}
	
	
}
