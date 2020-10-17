package limerence.additionaltraits.world.biomes;



import net.minecraft.init.Blocks;

import net.minecraft.world.biome.Biome;


public class BiomeFiller extends Biome
{
	public BiomeFiller()
	{
		super(new BiomeProperties("Filler00").setBaseHeight(0.2f).setRainDisabled().setTemperature(2.0f).setHeightVariation(5.5f));
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = Blocks.DIRT.getDefaultState();
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		

	}
	
	
}
