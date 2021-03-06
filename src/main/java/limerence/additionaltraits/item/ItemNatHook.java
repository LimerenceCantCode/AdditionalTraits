package limerence.additionaltraits.item;

import javax.annotation.Nullable;

import limerence.additionaltraits.entity.EntityNatFishHook;
import limerence.additionaltraits.util.init.ItemInit;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNatHook extends ItemFishingRod {
    public int enchantability;
	
	//new IItemPropertyGetter()
	public ItemNatHook(String name) {
		//ItemInit.ITEMS.add(this);
		setUnlocalizedName(name);
		setRegistryName(name);
        addPropertyOverride(new ResourceLocation("cast"), (stack, world, entity) -> {
            if (entity != null) {
                boolean isMain = entity.getHeldItemMainhand() == stack;
                boolean isOff = entity.getHeldItemOffhand() == stack;
                if (entity.getHeldItemMainhand().getItem() instanceof ItemNatHook) {
                    isOff = false;
                }
                return (isMain || isOff) && entity instanceof EntityPlayer &&
                		((EntityPlayer) entity).fishEntity != null ? 1.0F : 0.0F;
            }
            return 0.0F;
        });
        
        //ItemInit.ITEMS.add(this);
    }
	
	
	
	//@SideOnly(Side.SERVER)
	public static final String fishServer = "skillable:realBobber";
	
	//@SideOnly(Side.CLIENT)
	public static final String fishClient = "skillable:fakeBobber";


	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

	 @SideOnly(Side.CLIENT)
	    public boolean shouldRotateAroundWhenRendering() {
	        return true;
	 }
	 

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		ItemStack NatHook = player.getHeldItem(hand);
		ItemStack DefaultRod = new ItemStack(Items.FISHING_ROD);
		
    	@Nullable
    	int GenericID = player.getEntityData().getInteger(fishServer);
    	System.out.println("GenericID is "+GenericID);
		
		
		
			if (GenericID != 0) {
            if (!world.isRemote) {
            	
        	@Nullable
        	int ServerID = player.getEntityData().getInteger(fishServer);
        	System.out.println("Server ID is "+ServerID);
            	
            if(ServerID != 0) {
            		
            //int i = player.fishEntity.handleHookRetraction();
            EntityPlayerMP ServerSide = null;
            EntityNatFishHook Retract = (EntityNatFishHook) player.world.getEntityByID(ServerID);
            Retract.handleHookRetraction();
			player.swingArm(hand);
			player.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_BOBBER_RETRIEVE, 
					SoundCategory.NEUTRAL, 1.0F, 0.4F / (player.getRNG().nextFloat() * 0.4F + 0.8F));
			
			
            }
            
		}
		}
		else
		{
			player.world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_BOBBER_THROW, 
					SoundCategory.NEUTRAL, 1.0F, 0.4F / (player.getRNG().nextFloat() * 0.4F + 0.8F));
			player.swingArm(hand);
			if (!world.isRemote) {
			EntityNatFishHook MakeShiftHook = new EntityNatFishHook(player.world, player);

			int SpeedBonus = EnchantmentHelper.getFishingSpeedBonus(DefaultRod);
			int LuckBonus = EnchantmentHelper.getFishingLuckBonus(DefaultRod);

			if (SpeedBonus > 0) {MakeShiftHook.setLureSpeed(SpeedBonus);}
			if (LuckBonus > 0) {MakeShiftHook.setLuck(LuckBonus);}
			player.world.spawnEntity(MakeShiftHook);
			
			
			//if (MakeShiftHook.caughtEntity.isCreatureType(EnumCreatureType.CREATURE, true)) {
			//Vec3d Tether = new Vec3d(MakeShiftHook.caughtEntity.posX, MakeShiftHook.caughtEntity.posY, MakeShiftHook.caughtEntity.posZ);
			//MakeShiftHook.caughtEntity.applyPlayerInteraction(player, Tether, EnumHand.MAIN_HAND);	
			
			//} 
			}


		}
		return new ActionResult<>(EnumActionResult.SUCCESS, NatHook);
	}
	public int getItemEnchantability() {
		return 0;	
	}

	}
