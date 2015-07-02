//package lightningmats.biome;
//
//import lightningmats.LightningMaterials;
//import net.minecraft.block.Block;
//import net.minecraft.entity.passive.EntityMooshroom;    
//import net.minecraft.entity.passive.EntityPig;
//import net.minecraft.entity.passive.EntityWolf;
//import net.minecraft.init.Blocks;
//import net.minecraft.world.biome.BiomeGenBase;
//import net.minecraft.world.SpawnerAnimals;
//
//public class MyBiome extends BiomeGenBase
//{
//    public MyBiome(int p_i1986_1_)
//    {
//        super(p_i1986_1_);
//        
//        
//        this.setBiomeName("Overgrown Hills");
//        
//        this.topBlock = (Block)Blocks.grass;
//        this.fillerBlock = (Block)Blocks.dirt;
//        
//        this.theBiomeDecorator.bigMushroomsPerChunk = 13;
//        this.theBiomeDecorator.treesPerChunk = 7;
//
//       
//        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 25, 4, 8));
//        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 12, 3, 5));
//        
//        this.setHeight(height_HighPlateaus);
//        this.setTemperatureRainfall(1.0F, 0.2F);
//   
//    }
//}
