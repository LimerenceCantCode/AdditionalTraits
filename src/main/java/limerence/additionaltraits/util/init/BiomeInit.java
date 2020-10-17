package limerence.additionaltraits.util.init;



import limerence.additionaltraits.world.biomes.BiomeFiller;
import net.minecraft.world.biome.Biome;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Deprecated
public class BiomeInit 
{
	public static final Biome FILLER_BIOME = new BiomeFiller();
	
	public static void registerBiomes()
	{
		initBiome(FILLER_BIOME, "Filler00", BiomeType.DESERT, Type.HILLS);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType bType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(bType, new BiomeEntry(biome, 100));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Biom Registration Complete!");
		return biome;
		
	}
	
	
	public static void unregisterBiomes()
	{
		//deinitBiome(FILLER_BIOME, "Filler00", BiomeType.DESERT, Type.HILLS);
	}

	
	
	
	
	
	
	
	//private static void removebiom(Biome biome, String name, BiomeType bType, Type... types)
	//{
	
	//}
	
	
	
	

	
	
	//@SuppressWarnings("rawtypes")
	//private static void deinitBiome(Biome biome, String name, BiomeType bType, Type... types) 
	//{

		

		//ForgeRegistries.BIOMES.register(biome);
		//BiomeDictionary.addTypes(biome, types);
		//BiomeManager.removeBiome(bType, new BiomeEntry(biome, 100));
		//BiomeManager.removeSpawnBiome(biome);
		//((ForgeRegistry) ForgeRegistries.BIOMES).clear();
		
		//BiomeDictionary.registerBiomeType(biome, Type .FOREST)
		
		
		//ForgeRegistries.BIOMES.getKey(biome);

		
		
		//if repINT > 150 
		
		
		
		//System.out.println("Biom DERegistration Complete!");

		
		//else set repINT = repINT + 1 
		
		//repeat
		
	//}
    
}
