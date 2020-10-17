package limerence.additionaltraits.skill.additionaltraits;


import com.tmtravlr.potioncore.potion.PotionCure;

import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.GameType;




public class TraitPhaseWalk extends Trait implements EventInterface {
	private static final String TAG_COOLDOWN = "skillable:PhaseWalkCD";
	private static final String TAG_ACTIVETIMER = "skillable:PhaseWalkTime";
	
	public TraitPhaseWalk() {
		super(new ResourceLocation("additionaltraits", "phase_walk"), 1, 1, 
				new ResourceLocation("additionaltraits", "additionaltraits"), 1, 
				new String[]{"reskillable:attack|2", "reskillable:defense|2", "reskillable:agility|2"});
		if (FMLCommonHandler.instance().getSide().isClient()) {
			MinecraftForge.EVENT_BUS.register(this);
		}
	}
	
	boolean Active = false;
	GameType Spec = GameType.SPECTATOR;
	GameType Surv = GameType.SURVIVAL;
	private final ResourceLocation Shader = new ResourceLocation("shaders/post/sobel.json");

	@Override
	public void onHurt(LivingHurtEvent event) {
		if (!event.isCanceled()) {
			EntityLivingBase e = event.getEntityLiving();
			EntityPlayer player = (EntityPlayer) event.getEntity();
			//
			if (Active == false && player.isSneaking() && e.getEntityData().getInteger(TAG_COOLDOWN) == 0 && event.getSource().isUnblockable() == true 
					&& event.getSource() != DamageSource.FALL) {
					player.setGameType(Spec);
					e.getEntityData().setInteger(TAG_COOLDOWN, 100);
					e.getEntityData().setInteger(TAG_ACTIVETIMER, 40); 
					player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 7.0F, 7.0F);
					player.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 10.0F, 10.0F);  Active = true;
					player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 45, 2)); 
					player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 45, 2)); 

					
				}
				}
				//.isInstant(false)
				//&& event.getSource().isUnblockable()
		
		//e.getEntityData().getInteger(TAG_COOLDOWN) < 1 && 
		
		// && e.isSneaking() 
	
		
			//if (Active = false)
				 
				}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void clientTick(TickEvent.ClientTickEvent event) {
	EntityRenderer ER = Minecraft.getMinecraft().entityRenderer;
		if ((event.phase == TickEvent.Phase.END) && Active == true && !ER.isShaderActive())
		{ER.loadShader(Shader); System.out.println("Shader Activated?");
		}
		
		
		
		if ((event.phase == TickEvent.Phase.END) && Active == false && ER.isShaderActive())
		{ER.stopUseShader(); System.out.println("Shader Deactivated");}
		
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void fogEvent(EntityViewRenderEvent.RenderFogEvent event) {
	    if (Active == true) {
	    		GlStateManager.setFogDensity(3);
	            GlStateManager.setFogStart(15F);
	            GlStateManager.setFogEnd(30F);
	       
	    }
	}
	
	
	
	
	
	
	//40-60 ticks for 2-3 seconds
	
	@Override
	public void onPlayerTick(PlayerTickEvent event) {
		
		int cd = event.player.getEntityData().getInteger(TAG_COOLDOWN);
		int TimeLeft = event.player.getEntityData().getInteger(TAG_ACTIVETIMER);
		if (cd > 0) {event.player.getEntityData().setInteger(TAG_COOLDOWN, cd-1);}	
		if (Active == true) {
		if (TimeLeft > 0) {event.player.getEntityData().setInteger(TAG_ACTIVETIMER, TimeLeft-1);}
		if (Active == true && TimeLeft == 0 && cd != 0 ) {event.player.addPotionEffect(new PotionEffect(PotionCure.INSTANCE, 1, 0));
		event.player.setGameType(Surv);
		event.player.world.playSound((EntityPlayer)null, event.player.posX, event.player.posY, event.player.posZ, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 6.0F, 6.0F);
		Active = false;}
		
		}
	    }
		}
	

	
	
	
	
	
