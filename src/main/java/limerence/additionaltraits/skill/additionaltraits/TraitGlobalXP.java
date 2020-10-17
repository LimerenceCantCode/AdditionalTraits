package limerence.additionaltraits.skill.additionaltraits;



import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class TraitGlobalXP extends Trait implements EventInterface { 
	
	public TraitGlobalXP() {
		super(new ResourceLocation("additionaltraits", "global_xp"), 1, 2, 
				new ResourceLocation("additionaltraits", "additionaltraits"), 
				8, new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
		}
	
	
	//&& player.isElytraFlying() || !player.onGround || player.capabilities.isFlying
	
	public void onXPCollect(EntityPlayer player, EntityXPOrb orb) {
		
		int A = orb.getXpValue();
		
		
		player.world.spawnEntity(new EntityXPOrb(player.world, player.posX, player.posY, player.posZ, A));
		
		
		
		
	}

	public void onUnlock(EntityPlayer player) {
		
		
		
		
	}
	
}

