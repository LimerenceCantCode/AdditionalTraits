package limerence.additionaltraits.skill.additionaltraits;


import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import java.util.UUID;

import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;


public class TraitHolyRush extends Trait implements EventInterface { 
	
	public TraitHolyRush() {
		super(new ResourceLocation("additionaltraits", "holy_rush"), 1, 2, 
				new ResourceLocation("additionaltraits", "additionaltraits"), 
				8, new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
		}
	
	
	//&& player.isElytraFlying() || !player.onGround || player.capabilities.isFlying
	
	
	public static final UUID MODIFIER_UUID = UUID.fromString("1be7c3b2-1c59-4213-8ed4-b8a71c8d88ad");
	boolean CD = false;
	boolean ttd = false;
	boolean draining = false;
	private static final String TAG_TIMETILLDRAIN = "skillable:RushTimeTillDrain";


	
	
	
	@Override
	public void onKillMob(LivingDeathEvent event) {
		
		
		
		EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
		int TIMEADD = (int) (220-(player.getAbsorptionAmount()*4));
		IAttributeInstance moveSpeed = player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		AttributeModifier modifier = moveSpeed.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Golden Wings", 0.02D, 0);
		//Valkyrie's Flight
		if (!event.isCanceled() && event.getEntity() instanceof IMob && event.getSource().getTrueSource() 
				instanceof EntityPlayer ){
			

				if (!moveSpeed.hasModifier(modifier)) {moveSpeed.applyModifier(modifier);}
				if (CD == false && (player.getAbsorptionAmount() < 40.0F)) {
					
					player.getEntityData().setInteger(TAG_TIMETILLDRAIN, TIMEADD);

					player.setAbsorptionAmount(player.getAbsorptionAmount()+2.0F); 
					ttd = true;
					CD = true;
					draining = false;
					System.out.println("+1 Heart");
					}
				}

			}
	
	@Override
	public void onPlayerTick(PlayerTickEvent event) {
		
		if (event.phase == Phase.END) {
		int TTD = event.player.getEntityData().getInteger(TAG_TIMETILLDRAIN);

		IAttributeInstance moveSpeed = event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		AttributeModifier modifier = moveSpeed.getModifier(MODIFIER_UUID);
		modifier = new AttributeModifier(MODIFIER_UUID, "Golden Wings", 0.10D, 0);
		int outsideMod = 10;
		

		
		
		
		if (CD == true && (event.player.ticksExisted % 10 == 0)) {CD = false; System.out.println("cd now false");}
		
		
		
		
		if (ttd == true || draining == true) {
			
			if (TTD == 0) {draining = true; ttd = false;}
			else {event.player.getEntityData().setInteger(TAG_TIMETILLDRAIN, TTD-1);}

			}
			if (draining == true) {
				if (moveSpeed.hasModifier(modifier)) {moveSpeed.removeModifier(modifier); System.out.println("modifier removed");}
				
				if (event.player.ticksExisted % 20 == 0) {event.player.setAbsorptionAmount(event.player.getAbsorptionAmount()-1.0F);
					System.out.println("-1 Heart");
					event.player.world.playSound((EntityPlayer)null, event.player.posX, event.player.posY, event.player.posZ, SoundEvents.ENTITY_IRONGOLEM_ATTACK, SoundCategory.PLAYERS, 6.0F, 6.0F);
					
					
						
					if (event.player.getAbsorptionAmount() <= outsideMod) {draining = false;
					System.out.println("Draining now false");}
					}
				}
			}	
		}
		
		

	
	
	}
	
	
