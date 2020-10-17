package limerence.additionaltraits.skill.additionaltraits;

import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;

public class TraitMasterEnchanter extends Trait implements EventInterface {
	
	public TraitMasterEnchanter() {	
		super(new ResourceLocation("additionaltraits", "master_enchanter"), 2, 0, 
			new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
			new String[]{"reskillable:attack|2", "reskillable:defense|2", "reskillable:agility|2"});
	
	}
	
	public void onUnlock(EntityPlayer player) {failsafe = true;}
	public void onLock(EntityPlayer player) {failsafe = false;}
	
	
	
	
	
	private boolean failsafe = false;
	
	
	@Override
	public void onPlayerEnchant(EnchantmentLevelSetEvent event){
		System.out.println("ME FIRES");

				if(failsafe == true) {
					System.out.println("ME FIRES");
				System.out.println("Enchantment row: " + event.getEnchantRow() + ", level: " + event.getLevel());
				
						event.setLevel(Math.max(1, event.getLevel()*2/3));}
				else {event.setLevel(Math.max(1, event.getLevel()*1));}
					
					
				}
			
		
	

	
}
	
	
	

	
	
	



