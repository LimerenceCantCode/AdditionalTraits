package limerence.additionaltraits.skill.additionaltraits;

import codersafterdark.reskillable.api.unlockable.Trait;
import limerence.additionaltraits.util.EventInterface;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TraitSmeltingSpeed extends Trait implements EventInterface{
	
	public TraitSmeltingSpeed() {
		super(new ResourceLocation("additionaltraits", "smelting_speed"), 4, 0, new ResourceLocation("additionaltraits", "additionaltraits"),
			1, new String[]{"reskillable:attack|2", "reskillable:defense|2", "reskillable:agility|2"});
		}	
	
	
	

	
	  
	    public void onPlayerTick(PlayerTickEvent event) {
		    EntityPlayer player = event.player;
		   if (!player.world.isRemote && player.ticksExisted % 20 == 0 && event.phase == Phase.END) {
	    
	        BlockPos pos = player.getPosition();
	        int rad = 7;
         
           
            
            for(int a = -rad; a < rad; ++a)
            	for(int b = -rad; b < rad; ++b)
    				for(int c = -rad; c < rad; ++c)		
    				{
    					int x = pos.getX() + a;        
    					int y = pos.getY() + b;
    					int z = pos.getZ() + c;
    					BlockPos offPos = new BlockPos(x, y, z);
    				
                    if (player.world.isAirBlock(offPos)) {continue;}
    				
    					if (isBrewingStand(player.world, offPos)){
    						
    					System.out.println("Attempting Buff");
	                	TileEntity TE = player.world.getTileEntity(offPos);
	                	TileEntityFurnace stand = (TileEntityFurnace) TE;
	                	
	                	
	                	int progress = stand.getField(0);
	                	int buff = 15;
	                	if (progress > 0) {
	                		stand.setField(0, Math.max(1, progress-buff));
	                		System.out.println("Time Remaining: " +progress);
	                		
	                	}
    					}
    				}
		   }
	   }
	            
	            
	            

	   
	   
	   
	   
	   private boolean isBrewingStand(World world, BlockPos offPos) {
		   
	        IBlockState state = world.getBlockState(offPos);
	        
	        Block block = state.getBlock();
	        if (block != Blocks.FURNACE || block != Blocks.LIT_FURNACE) {
	            return false;
	        }
	       
	        Block hit = state.getBlock();
	        System.out.println("Furnace at " + offPos);
	        return (hit == Blocks.FURNACE && !world.isRemote || hit == Blocks.LIT_FURNACE && !world.isRemote );
	        
	    }
	
	   
	   
	   
	   
}
