package limerence.additionaltraits.skill.additionaltraits;


import java.util.UUID;
import com.tmtravlr.potioncore.PotionCoreAttributes;
import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;


public class TraitDamageResist extends Trait implements EventInterface {
		public TraitDamageResist() {
			super(new ResourceLocation("additionaltraits", "damage_resist"), 0, 2, 

					new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
					new String[]{"reskillable:attack|2", "reskillable:defense|2", "reskillable:agility|2"});
			//just a ctrl c ctrl v from an existing trait, obviously customize values once it works.
		}
		
		
		
		public static final UUID MODIFIER_UUID = UUID.fromString("e10bb5c6-ccfb-4134-afd0-609d982cf447");
		private boolean failsafe = false;
		
		 public void onUnlock(EntityPlayer player) {
			IAttributeInstance DR = player.getEntityAttribute(PotionCoreAttributes.DAMAGE_RESISTANCE);
			AttributeModifier modifier = DR.getModifier(MODIFIER_UUID);
			modifier = new AttributeModifier(MODIFIER_UUID, "Trait DR", 0.10D, 0);
			DR.applyModifier(modifier);
			failsafe = true;

				
				
		}
		 
		 
		 public void onLock(EntityPlayer player) {
				IAttributeInstance DR = player.getEntityAttribute(PotionCoreAttributes.DAMAGE_RESISTANCE);
				AttributeModifier modifier = DR.getModifier(MODIFIER_UUID);
				modifier = new AttributeModifier(MODIFIER_UUID, "Trait DR", 0.10D, 0);
				DR.removeModifier(modifier);
				failsafe = false;
		 }
							 
		 	@Override
			public void onPlayerRespawn(PlayerRespawnEvent event) {
				EntityPlayer player = event.player;
				IAttributeInstance DR = player.getEntityAttribute(PotionCoreAttributes.DAMAGE_RESISTANCE);
				AttributeModifier modifier = DR.getModifier(MODIFIER_UUID);
				modifier = new AttributeModifier(MODIFIER_UUID, "Trait DR", 0.10D, 0);
			if(!failsafe == true) {
				DR.applyModifier(modifier);
			}MinecraftForge.EVENT_BUS.register(TraitDamageResist.class);}		
		

	
	}




//alternative: OnUnlockEvent setBaseValue RESISTANCE 
//has the benefit of showing DR on armor bar for some resource packs.
//and not checking the full script everytime an entity/player is damaged