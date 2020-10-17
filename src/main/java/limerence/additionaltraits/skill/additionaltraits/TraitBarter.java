package limerence.additionaltraits.skill.additionaltraits;



import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.village.MerchantTradeOffersEvent;

public class TraitBarter extends Trait implements EventInterface {
	public TraitBarter() {
		super(new ResourceLocation("additionaltraits", "barter"), 4, 2, 
				new ResourceLocation("additionaltraits", "additionaltraits"),
				1, new String[]{"reskillable:attack|1", "reskillable:defense|1", "reskillable:agility|1"});
	}
	

	
	public void onTrade(MerchantTradeOffersEvent event) {
		
		int size = event.getList().size();
		System.out.println("Checking Size: "+size);
		int reps = 0;
		
		while (reps < size) {
		System.out.println("Running Rep: "+reps);
		
		ItemStack check = event.getList().get(reps).getItemToBuy();
		
		BlockPos Local = event.getMerchant().getPos();
		AxisAlignedBB Pos = new AxisAlignedBB(Local);
		java.util.List<EntityLiving> AtPo = event.getPlayer().world.getEntitiesWithinAABB(EntityLiving.class, Pos);
		
		EntityLiving AT = AtPo.get(0);

		
		
		Item Au = Items.GOLD_INGOT;
		Item Em = Items.EMERALD;
		
		if (AtPo.get(0).getTags().toString().contains("discount") && check.getItem() == Au || AtPo.get(0).getTags().toString().contains("discount") && check.getItem()== Em){
			System.out.println("Hit! on trade:"+reps);
			int calc = (int) Math.max(Math.floor((check.getCount()/4)*3), 1);
			check.setCount(calc);
			AtPo.get(0).addTag("discount");
			
			
			
			
		
		}
		reps++;
		}
		reps = 0;
		
	}
	
	
}