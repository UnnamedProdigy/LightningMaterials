package lightningmats;

import lightningmats.armor.LightningArmor;
//import lightningmats.biome.MyBiome;
import lightningmats.blocks.BasicBlock;
import lightningmats.blocks.C4;
import lightningmats.blocks.GemOre;
import lightningmats.blocks.LightningLadder;
import lightningmats.blocks.OreGen;
import lightningmats.blocks.Ores.GemOreGen;
import lightningmats.blocks.Ores.OreGen1;
import lightningmats.commands.Command3;
import lightningmats.commands.Command4;
import lightningmats.entity.chest.LightningChest;
import lightningmats.entity.chest.TileEntityLightningChest;
import lightningmats.handlers.GuiHandler;
import lightningmats.handlers.IngameOptions;
import lightningmats.handlers.PickupHandler;
import lightningmats.items.BasicAxe;
import lightningmats.items.BasicItem;
import lightningmats.items.BasicPickaxe;
import lightningmats.items.BasicSpade;
import lightningmats.items.BasicSword;
import lightningmats.items.Bullet;
import lightningmats.items.Detonater;
import lightningmats.items.Grenade;
import lightningmats.items.Gun;
import lightningmats.items.LightningLoaf;
import lightningmats.items.LightningSword;
import lightningmats.items.MultiTool;
import lightningmats.items.MyItem2;
import lightningmats.power.Battery;
import lightningmats.power.Recipes;
import lightningmats.power.bronzefurnace.BFurnace;
import lightningmats.power.bronzefurnace.TileEntityBFurnace;
import lightningmats.power.charger.TileEntityCharger;
import lightningmats.power.energycell.TileEntityEnergyCell;
import lightningmats.power.lightningrod.LightningRod;
import lightningmats.power.lightningrod.TileEntityLightningRod;
import lightningmats.power.macerator.Macerator;
import lightningmats.power.macerator.TileEntityMacerator;
import lightningmats.power.solar.TileEntitySolar;
import lightningmats.power.solar.TileEntitySolar2;
import lightningmats.projectile.GrenadeEntity;
import lightningmats.projectile.LightningEntity;
import lightningmats.projectile.RenderGrenade;
import lightningmats.projectile.RenderLightning;
import lightningmats.proxies.ClientProxy;
import lightningmats.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

import com.jadarstudios.developercapes.DevCapes;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
//import mymod.blocks.Portal;
//import mymod.dimension.MyDimension;


/* 	MOD INFO */
@Mod( modid = "LightningMaterials", name = "Lightning Materials", version = "1.3", dependencies="required-after:CoFHCore@[1.7.10R3.0.0,)", canBeDeactivated = false, useMetadata = true, guiFactory = "lightningmats.config.LMGuiFactory")	

public class LightningMaterials {

	/*	PROXY INFO */
	@SidedProxy(clientSide = "lightningmats.proxies.ClientProxy", serverSide = "lightningmats.proxies.CommonProxy")
	public static CommonProxy proxy;
	public static ClientProxy proxy2;


	public static final String modid = "LightningMaterials";
	/**	
	 * TODO DECLARATION SECTION 
	 * *********************************************************** */
	public static String side = "client";
	public static boolean HDTextures;
	public static boolean NetherOres;
	public static boolean LightningRods;
	public static boolean RenderGun;
	public static boolean DisableZinc;
	public static boolean TFRecipes;
	public static boolean isTFLoaded=false;
	public static boolean IngameModOptions;
	public static int maceratorSpeed = 101;
	public static int maceratorOutput = 2;
	public static int maceratorMaxPower = 40000;
	public static int maceratorPowerUsage = 40;
	public static int lightningPerChunk = 1;
	public static int lightningPerGroup = 3;
	public static int lightningHeight = 23;
	public static int nickelPerChunk = 3;
	public static int nickelPerGroup = 5;
	public static int nickelHeight = 31;
	public static int platinumPerChunk = 1;
	public static int platinumPerGroup = 3;
	public static int platinumHeight = 23;
	public static int zincPerChunk = 3;
	public static int zincPerGroup = 5;
	public static int zincHeight = 31;
	public static int rubyPerChunk = 3;
	public static int rubyPerGroup = 5;
	public static int rubyHeight = 31;
	public static int sapphirePerChunk = 1;
	public static int sapphirePerGroup = 3;
	public static int sapphireHeight = 23;
	public static int amethystPerChunk = 3;
	public static int amethystPerGroup = 5;
	public static int amethystHeight = 31;
	public static int netherlightningPerChunk = 2;
	public static int netherlightningPerGroup = 3;
	public static int netherlightningHeight = 41;
	public static int netherdiamondPerChunk = 4;
	public static int netherdiamondPerGroup = 3;
	public static int netherdiamondHeight = 38;
	public static int nethergoldPerChunk = 5;
	public static int nethergoldPerGroup = 5;
	public static int nethergoldHeight = 46;
	public static int netherironPerChunk = 9;
	public static int netherironPerGroup = 6;
	public static int netherironHeight = 72;
	public static int netheremeraldPerChunk = 2;
	public static int netheremeraldPerGroup = 2;
	public static int netheremeraldHeight = 33;
	public static int nethercoalPerChunk = 16;
	public static int nethercoalPerGroup = 13;
	public static int nethercoalHeight = 127;
	public static int netherredstonePerChunk = 4;
	public static int netherredstonePerGroup = 6;
	public static int netherredstoneHeight = 46;
	//  DECLARE A NEW CREATIVE TAB  
	public static CreativeTabs BlocksTab;
	public static CreativeTabs MachinesTab;
	public static CreativeTabs WeaponsTab;
	public static CreativeTabs ToolsTab;
	public static CreativeTabs ArmorTab;
	public static CreativeTabs ValuablesTab;
	public static Block blockMaceratorIdle;
	public static Block blockMaceratorActive;
	public static Block ChargerIdle;
	public static Block ChargerActive;
	public static Block SolarIdle;
	public static Block SolarActive;
	public static Block Solar2Idle;
	public static Block Solar2Active;
	public static Block LightningRod;
	public static Block Scaffolding;
	public static Item Lightning; 
	public static Block EnergyCell;
	public static Block BFurnace;
	public static Block BFurnaceActive;
	public static Block LightningLadder;



	@Instance(modid)

	public static LightningMaterials instance;



	public static final int guiIdBFurnace = 103;
	public static final int guiIdMacerator = 8;
	public static final int guiIdCharger = 100;
	public static final int guiIdSolar = 101;
	public static final int guiIdSolar2 = 102;




	@EventHandler
	public void load(FMLInitializationEvent e){		


		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());


	}		

	public static Item Battery;
	public static Item Grenade;
	//  DECLARE THE SWORD 
	public static Item LightningSword;

	//  DECLARE THE PICKAXE 
	public static Item LightningPickaxe;

	//  DECLARE THE AXE 
	public static Item LightningAxe;

	//  DECLARE THE SPADE 
	public static Item LightningSpade;

	//  DECLARE THE TOOL 
	public static Item MultiTool;

	//  DECLARE THE ITEM
	public static Item LightningIngot;

	//  DECLARE THE ITEM
	public static Item LightningNugget;

	//  DECLARE THE FOOD
	public static Item LightningLoaf;

	public static Block LightningOre;

	public static Block C4_1;

	public static Item Detonater;
	//  DECLARE THE ARMOR
	public static Item MyHelmet_1;
	public static Item MyChest_1;
	public static Item MyLeggings_1;
	public static Item MyBoots_1;
	public static Item Gun_1;
	//        public static Block Portal;
	//        public static final int dimensionId = 5;
	public static Item FlintAndSteel;
	//        public static Block Fire;
	public static  IWorldGenerator MyBiome_1;
	public static Block Pipe;      
	//        public static Item Backpack;
	public static Block PortalPlacer;

	//        public static Item DustD;
	//        public static Item DustC;
	//        public static Item DustG;
	//        public static Item DustI;
	//        public static Item DustE;
	//        public static Item DustL;
	//        //  DECLARE THE MOB ID
	//        static int MyEntityID = 300;
	//    
	//    //  SEARCH FOR UNIQUE ID    
	//        public static int getUniqueEntityId() {
	//            do {
	//                MyEntityID++;
	//            }
	//            while (EntityList.getStringFromID(MyEntityID) != null);
	//            return MyEntityID++;
	//        
	//   
	//		
	//		
	//	}








	public static ArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("Lightning", 62, new int[]{4, 9, 7, 4}, 30);

	//  DECLARE NEW TOOL MATERIAL
	public static ToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Lightning", 3, 2341, 45.0F, 4.0F, 10);
	//  DECLARE NEW TOOL MATERIAL
	public static ToolMaterial MyToolMaterial3 = EnumHelper.addToolMaterial("LightningMultiTool", 3, 15000, 55.0F, 6.0F, 10);

	public static ToolMaterial Gems = EnumHelper.addToolMaterial("Gems", 2, 1026, 6F, 2F, 14);

	public static ToolMaterial Nickel = EnumHelper.addToolMaterial("Nickel", 2, 795, 5.5F, 2F, 10);

	public static ToolMaterial Platinum = EnumHelper.addToolMaterial("Platinum", 3, 1582, 7F, 3F, 10);

	public static ToolMaterial Zinc = EnumHelper.addToolMaterial("Zinc", 2, 473, 4.5F, 1.5F, 10);

	public static Achievement NickelAch;
	public static Achievement PlatinumAch;
	public static Achievement SolarAch;
	public static Achievement SwordAch;
	public static Achievement AllInOne;
	public static Achievement LightningAch;
	public static AchievementPage LightningMaterialsAch;
	public static Configuration config;
	/**
		Instantiate All New Ores And Tools

	 */
	public static Block NetherLightning;
	public static Block NetherDiamond;
	public static Block NetherCoal;
	public static Block NetherGold;
	public static Block NetherEmerald;
	public static Block NetherIron;
	public static Block NetherRedstone;
	public static Item Bullet;
	public static Block NickelOre;
	public static Block ZincOre;
	public static Block PlatinumOre;
	public static Block AmethystOre;
	public static Block RubyOre;
	public static Block SapphireOre;
	public static Block NickelBlock;
	public static Block ZincBlock;
	public static Block PlatinumBlock;
	public static Block AmethystBlock;
	public static Block RubyBlock;
	public static Block SapphireBlock;
	public static Block LightningBlock;
	public static Item NickelIngot;
	public static Item ZincIngot;
	public static Item PlatinumIngot;
	public static Item Amethyst;
	public static Item Ruby;
	public static Item Sapphire;
	public static Item NickelSword;
	public static Item PlatinumSword;
	public static Item ZincSword;
	public static Item RubySword;
	public static Item AmethystSword;
	public static Item SapphireSword;
	public static Item EmeraldSword;
	public static Item NickelPick;
	public static Item PlatinumPick;
	public static Item ZincPick;
	public static Item RubyPick;
	public static Item AmethystPick;
	public static Item SapphirePick;
	public static Item EmeraldPick;
	public static Item NickelAxe;
	public static Item PlatinumAxe;
	public static Item ZincAxe;
	public static Item RubyAxe;
	public static Item AmethystAxe;
	public static Item SapphireAxe;
	public static Item EmeraldAxe;
	public static Item NickelSpade;
	public static Item PlatinumSpade;
	public static Item ZincSpade;
	public static Item RubySpade;
	public static Item AmethystSpade;
	public static Item SapphireSpade;
	public static Item EmeraldSpade;
	public static Item NickelNugget;
	public static Item PlatinumNugget;
	public static Item ZincNugget;
	public static Item dustNickel;
	public static Item dustPlatinum;
	public static Item dustZinc;
	public static Item dustRuby;
	public static Item dustAmethyst;
	public static Item dustSapphire;
	public static Item dustEmerald;
	public static Item dustDiamond;
	public static Item dustIron;
	public static Item dustGold;
	public static Item dustCoal;
	public static Item GodBoots;
	public static Block Chest;
	/*TODO ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	




	@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
		
		if (Loader.isModLoaded("ThermalFoundation"))
		{
			isTFLoaded=true;
		}else{
			isTFLoaded=false;
		}
		
		
		/**	
		 * LOAD SECTION 
		 * *********************************************************** */ 

		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		HDTextures = config.get("Client Side", "HD Textures", false).getBoolean(false);
		NetherOres = config.get("Server Side", "Enable Nether Ores", true).getBoolean(true);
		LightningRods = config.get("Server Side", "Allow Lightning Rods", true).getBoolean(true);
		RenderGun = config.get("Client Side", "Render The Gun In 3D", true).getBoolean(true);
		DisableZinc = config.get("Server Side", "Disable Zinc Tools", false).getBoolean(false);
		TFRecipes = config.get("Mod Compatability", "TF Ores Work In The Macerator", false).getBoolean(false);
		IngameModOptions = config.get("Mod Compatability", "Ingame Mod Options", true, "May Cause Problems With Other Mods").getBoolean(true);
		lightningPerChunk = config.get("Lightning Ore Generation", "Veins Per Chunk", 1, null, 0, 16).getInt(1);
		lightningPerGroup = config.get("Lightning Ore Generation", "Average Ore Per Vein", 3, null, 0, 32).getInt(3);
		lightningHeight = config.get("Lightning Ore Generation", "Maximum Generation Height", 23, null, 0, 255).getInt(23);
		nickelPerChunk = config.get("Nickel Ore Generation", "Veins Per Chunk", 3, null, 0, 16).getInt(3);
		nickelPerGroup = config.get("Nickel Ore Generation", "Average Ore Per Vein", 5, null, 0, 32).getInt(5);
		nickelHeight = config.get("Nickel Ore Generation", "Maximum Generation Height", 31, null, 0, 255).getInt(31);
		zincPerChunk = config.get("Zinc Ore Generation", "Veins Per Chunk", 3, null, 0, 16).getInt(3);
		zincPerGroup = config.get("Zinc Ore Generation", "Average Ore Per Vein", 5, null, 0, 32).getInt(5);
		zincHeight = config.get("Zinc Ore Generation", "Maximum Generation Height", 31, null, 0, 255).getInt(31);
		platinumPerChunk = config.get("Platinum Ore Generation", "Veins Per Chunk", 2, null, 0, 16).getInt(2);
		platinumPerGroup = config.get("Platinum Ore Generation", "Average Ore Per Vein", 3, null, 0, 32).getInt(3);
		platinumHeight = config.get("Platinum Ore Generation", "Maximum Generation Height", 21, null, 0, 255).getInt(21);
		rubyPerChunk = config.get("ruby Ore Generation", "Veins Per Chunk", 3, null, 0, 16).getInt(3);
		rubyPerGroup = config.get("ruby Ore Generation", "Average Ore Per Vein", 3, null, 0, 32).getInt(3);
		rubyHeight = config.get("ruby Ore Generation", "Maximum Generation Height", 31, null, 0, 255).getInt(31);
		amethystPerChunk = config.get("Amethyst Ore Generation", "Veins Per Chunk", 3, null, 0, 16).getInt(3);
		amethystPerGroup = config.get("Amethyst Ore Generation", "Average Ore Per Vein", 3, null, 0, 32).getInt(3);
		amethystHeight = config.get("Amethyst Ore Generation", "Maximum Generation Height", 31, null, 0, 255).getInt(31);
		sapphirePerChunk = config.get("Sapphire Ore Generation", "Veins Per Chunk", 3, null, 0, 16).getInt(3);
		sapphirePerGroup = config.get("Sapphire Ore Generation", "Average Ore Per Vein", 3, null, 0, 32).getInt(3);
		sapphireHeight = config.get("Sapphire Ore Generation", "Maximum Generation Height", 31, null, 0, 255).getInt(31);
		netherlightningPerChunk = config.get("Nether Lightning Ore Generation", "Veins Per Chunk", 2, null, 0, 16).getInt(2);
		netherlightningPerGroup = config.get("Nether Lightning Ore Generation", "Average Ore Per Vein", 3, null, 0, 32).getInt(3);
		netherlightningHeight = config.get("Nether Lightning Ore Generation", "Maximum Generation Height", 41, null, 0, 255).getInt(41);
		netherdiamondPerChunk = config.get("Nether Diamond Ore Generation", "Veins Per Chunk", 4, null, 0, 16).getInt(4);
		netherdiamondPerGroup = config.get("Nether Diamond Ore Generation", "Average Ore Per Vein", 3, null, 0, 32).getInt(3);
		netherdiamondHeight = config.get("Nether Diamond Ore Generation", "Maximum Generation Height", 38, null, 0, 255).getInt(38);
		netherironPerChunk = config.get("Nether Iron Ore Generation", "Veins Per Chunk", 9, null, 0, 16).getInt(9);
		netherironPerGroup = config.get("Nether Iron Ore Generation", "Average Ore Per Vein", 6, null, 0, 32).getInt(6);
		netherironHeight = config.get("Nether Iron Ore Generation", "Maximum Generation Height", 72, null, 0, 255).getInt(72);
		nethergoldPerChunk = config.get("Nether Gold Ore Generation", "Veins Per Chunk", 5, null, 0, 16).getInt(5);
		nethergoldPerGroup = config.get("Nether Gold Ore Generation", "Average Ore Per Vein", 5, null, 0, 32).getInt(5);
		nethergoldHeight = config.get("Nether Gold Ore Generation", "Maximum Generation Height", 46, null, 0, 255).getInt(46);
		netheremeraldPerChunk = config.get("Nether Emerald Ore Generation", "Veins Per Chunk", 2, null, 0, 16).getInt(2);
		netheremeraldPerGroup = config.get("Nether Emerald Ore Generation", "Average Ore Per Vein", 2, null, 0, 32).getInt(2);
		netheremeraldHeight = config.get("Nether Emerald Ore Generation", "Maximum Generation Height", 33, null, 0, 255).getInt(33);
		nethercoalPerChunk = config.get("Nether Coal Ore Generation", "Veins Per Chunk", 16, null, 0, 16).getInt(16);
		nethercoalPerGroup = config.get("Nether Coal Ore Generation", "Average Ore Per Vein", 13, null, 0, 32).getInt(13);
		nethercoalHeight = config.get("Nether Coal Ore Generation", "Maximum Generation Height", 127, null, 0, 255).getInt(127);
		netherredstonePerChunk = config.get("Nether Redstone Ore Generation", "Veins Per Chunk", 4, null, 0, 16).getInt(4);
		netherredstonePerGroup = config.get("Nether Redstone Ore Generation", "Average Ore Per Vein", 6, null, 0, 32).getInt(6);
		netherredstoneHeight = config.get("Nether Redstone Ore Generation", "Maximum Generation Height", 46, null, 0, 255).getInt(46);
		config.setCategoryRequiresWorldRestart("Server Side", true);
		config.setCategoryRequiresWorldRestart("server side", true);
		config.addCustomCategoryComment("Machines", "These Effect The Machines From Lightning Materials");
		config.addCustomCategoryComment("Mod Compatability", "These Add Things That Use Stuff From Other Mods");
		config.addCustomCategoryComment("Server Side", "These Require A World Restart");
		config.addCustomCategoryComment("Client Side", "These Can Be Upadated Instantly");
		config.save();


		BlocksTab = new CreativeTabs("MyCreativeTab_1") {
			public ItemStack getIconItemStack() {
				return new ItemStack(LightningOre, 0, 0);   // Icon, Stack Size, Tab Position
			}

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		ValuablesTab = new CreativeTabs("MyCreativeTab_6") {
			public ItemStack getIconItemStack() {
				return new ItemStack(LightningIngot, 0, 0);   // Icon, Stack Size, Tab Position
			}

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		ToolsTab = new CreativeTabs("MyCreativeTab_4") {
			public ItemStack getIconItemStack() {
				return new ItemStack(LightningPickaxe, 0, 0);   // Icon, Stack Size, Tab Position
			}

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		WeaponsTab = new CreativeTabs("MyCreativeTab_3") {
			public ItemStack getIconItemStack() {
				return new ItemStack(SapphireSword, 0, 0);   // Icon, Stack Size, Tab Position
			}

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		ArmorTab = new CreativeTabs("MyCreativeTab_5") {
			public ItemStack getIconItemStack() {
				return new ItemStack(MyChest_1, 0, 0);   // Icon, Stack Size, Tab Position
			}

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		MachinesTab = new CreativeTabs("MyCreativeTab_2") {
			public ItemStack getIconItemStack() {
				return new ItemStack(Battery, 0, 0);   // Icon, Stack Size, Tab Position
			}

			@Override
			public Item getTabIconItem() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		

		
		
		LightningLadder = new LightningLadder().setBlockName("LightingLadder").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(2);
		GameRegistry.registerBlock(LightningLadder, "LightningLadder");
		
		/**
		 * Register Ores
		 */
		NickelOre = new BasicBlock(3007, Material.rock, "NickelOre").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(2);
		GameRegistry.registerBlock(NickelOre, "NickelOre");

		PlatinumOre = new BasicBlock(3009, Material.rock, "PlatinumOre").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
		GameRegistry.registerBlock(PlatinumOre, "PlatinumOre");

		ZincOre = new BasicBlock(3010, Material.rock, "ZincOre").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
		GameRegistry.registerBlock(ZincOre, "ZincOre");
		
		RubyOre = new GemOre(3011, Material.rock, "RubyOre", Ruby, 1, 2).setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(1.75F);
		GameRegistry.registerBlock(RubyOre, "RubyOre");

		SapphireOre = new GemOre(3012, Material.rock, "SapphireOre", Sapphire, 1, 2).setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(1.75F);
		GameRegistry.registerBlock(SapphireOre, "SapphireOre");

		AmethystOre = new GemOre(3008, Material.rock, "AmethystOre", Amethyst, 1, 2).setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(1.75F);
		GameRegistry.registerBlock(AmethystOre, "AmethystOre");
		
		LightningOre = new BasicBlock(2501, Material.iron, "LightningOre").setCreativeTab(BlocksTab).setLightLevel(0.5F).setResistance(20.0F).setHardness(3.25F);
		GameRegistry.registerBlock(LightningOre, "LightningOre");


		/**
		 * Register Blocks
		 */ 

		NickelBlock = new BasicBlock(3007, Material.rock, "NickelBlock").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(2);
		GameRegistry.registerBlock(NickelBlock, "NickelBlock");

		AmethystBlock = new BasicBlock(3008, Material.rock, "AmethystBlock").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(1.75F);
		GameRegistry.registerBlock(AmethystBlock, "AmethystBlock");

		PlatinumBlock = new BasicBlock(3009, Material.rock, "PlatinumBlock").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
		GameRegistry.registerBlock(PlatinumBlock, "PlatinumBlock");

		ZincBlock = new BasicBlock(3010, Material.rock, "ZincBlock").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
		GameRegistry.registerBlock(ZincBlock, "ZincBlock");

		RubyBlock = new BasicBlock(3011, Material.rock, "RubyBlock").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(1.75F);
		GameRegistry.registerBlock(RubyBlock, "RubyBlock");

		SapphireBlock = new BasicBlock(3012, Material.rock, "SapphireBlock").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(1.75F);
		GameRegistry.registerBlock(SapphireBlock, "SapphireBlock");	
		/**
		 * Register Ingots/ Gems 	
		 */
		NickelIngot = new BasicItem(2030, "NickelIngot").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(NickelIngot, "NickelIngot");

		PlatinumIngot = new BasicItem(2030, "PlatinumIngot").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(PlatinumIngot, "PlatinumIngot");

		ZincIngot = new BasicItem(2030, "ZincIngot").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(ZincIngot, "ZincIngot");

		NickelNugget = new BasicItem(2030, "NickelNugget").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(NickelNugget, "NickelNugget");

		PlatinumNugget = new BasicItem(2030, "PlatinumNugget").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(PlatinumNugget, "PlatinumNugget");

		ZincNugget = new BasicItem(2030, "ZincNugget").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(ZincNugget, "ZincNugget");
		
		LightningNugget = new MyItem2(2031, "LightningNugget").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(LightningNugget, "LightningNugget");

		Amethyst = new BasicItem(2030, "Amethyst").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(Amethyst, "Amethyst");

		Ruby = new BasicItem(2030, "Ruby").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(Ruby, "Ruby");

		Sapphire = new BasicItem(2030, "Sapphire").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(Sapphire, "Sapphire");
		
		LightningIngot = new BasicItem(2030, "LightningIngot").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(LightningIngot, "LightningIngot");

		NickelSword = new BasicSword(2021, Nickel, "NickelSword").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(NickelSword, "NickelSword");

		PlatinumSword = new BasicSword(2021, Platinum, "PlatinumSword").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(PlatinumSword, "PlatinumSword");
		if (this.DisableZinc==false){
			ZincSword = new BasicSword(2021, Zinc, "ZincSword").setCreativeTab(WeaponsTab);
			GameRegistry.registerItem(ZincSword, "ZincSword");
		}
		RubySword = new BasicSword(2021, Gems, "RubySword").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(RubySword, "RubySword");

		AmethystSword = new BasicSword(2021, Gems, "AmethystSword").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(AmethystSword, "AmethystSword");

		SapphireSword = new BasicSword(2021, Gems, "SapphireSword").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(SapphireSword, "SapphireSword");

		EmeraldSword = new BasicSword(2021, Gems, "EmeraldSword").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(EmeraldSword, "EmeraldSword");
		
		LightningSword = new LightningSword(2021, MyToolMaterial, "LightningSword").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(LightningSword, "LightningSword");

		NickelPick = new BasicPickaxe(2022, Nickel, "NickelPick").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(NickelPick, "NickelPick");

		PlatinumPick = new BasicPickaxe(2022, Platinum, "PlatinumPick").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(PlatinumPick, "PlatinumPick");
		if (this.DisableZinc==false){
			ZincPick = new BasicPickaxe(2022, Zinc, "ZincPick").setCreativeTab(ToolsTab);
			GameRegistry.registerItem(ZincPick, "ZincPick");
		}
		RubyPick = new BasicPickaxe(2022, Gems, "RubyPick").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(RubyPick, "RubyPick");

		AmethystPick = new BasicPickaxe(2022, Gems, "AmethystPick").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(AmethystPick, "AmethystPick");

		SapphirePick = new BasicPickaxe(2022, Gems, "SapphirePick").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(SapphirePick, "SapphirePick");

		EmeraldPick = new BasicPickaxe(2022, Gems, "EmeraldPick").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(EmeraldPick, "EmeraldPick");
		
		LightningPickaxe = new BasicPickaxe(2022, MyToolMaterial, "LightningPickaxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(LightningPickaxe, "LightningPickaxe");

		NickelAxe = new BasicAxe(2222, Nickel, "NickelAxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(NickelAxe, "NickelAxe");

		PlatinumAxe = new BasicAxe(2222, Platinum, "PlatinumAxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(PlatinumAxe, "PlatinumAxe");
		if (this.DisableZinc==false){
			ZincAxe = new BasicAxe(2222, Zinc, "ZincAxe").setCreativeTab(ToolsTab);
			GameRegistry.registerItem(ZincAxe, "ZincAxe");
		}
		RubyAxe = new BasicAxe(2222, Gems, "RubyAxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(RubyAxe, "RubyAxe");

		AmethystAxe = new BasicAxe(2222, Gems, "AmethystAxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(AmethystAxe, "AmethystAxe");

		SapphireAxe = new BasicAxe(2222, Gems, "SapphireAxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(SapphireAxe, "SapphireAxe");

		EmeraldAxe = new BasicAxe(2222, Gems, "EmeraldAxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(EmeraldAxe, "EmeraldAxe");
		
		LightningAxe = new BasicAxe(2222, MyToolMaterial, "LightningAxe").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(LightningAxe, "LightningAxe");

		NickelSpade = new BasicSpade(2223, Nickel, "NickelSpade").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(NickelSpade, "NickelSpade");

		PlatinumSpade = new BasicSpade(2223, Platinum, "PlatinumSpade").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(PlatinumSpade, "PlatinumSpade");
		if (this.DisableZinc==false){
			ZincSpade = new BasicSpade(2223, Zinc, "ZincSpade").setCreativeTab(ToolsTab);
			GameRegistry.registerItem(ZincSpade, "ZincSpade");
		}
		RubySpade = new BasicSpade(2223, Gems, "RubySpade").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(RubySpade, "RubySpade");

		AmethystSpade = new BasicSpade(2223, Gems, "AmethystSpade").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(AmethystSpade, "AmethystSpade");

		SapphireSpade = new BasicSpade(2223, Gems, "SapphireSpade").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(SapphireSpade, "SapphireSpade");

		EmeraldSpade = new BasicSpade(2223, Gems, "EmeraldSpade").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(EmeraldSpade, "EmeraldSpade");
		
		LightningSpade = new BasicSpade(2223, MyToolMaterial, "LightningSpade").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(LightningSpade, "LightningSpade");

		dustNickel = new BasicItem(2030, "NickelDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustNickel, "dustNickel");

		dustPlatinum = new BasicItem(2030, "PlatinumDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustPlatinum, "dustPlatinum");

		dustZinc = new BasicItem(2030, "ZincDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustZinc, "dustZinc");

		dustRuby = new BasicItem(2030, "RubyDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustRuby, "dustRuby");

		dustAmethyst = new BasicItem(2030, "AmethystDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustAmethyst, "dustAmethyst");

		dustSapphire = new BasicItem(2030, "SapphireDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustSapphire, "dustSapphire");

		dustEmerald = new BasicItem(2030, "EmeraldDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustEmerald, "dustEmerald");

		dustDiamond = new BasicItem(2030, "DiamondDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustDiamond, "dustDiamond");

		dustIron = new BasicItem(2030, "IronDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustIron, "dustIron");

		dustGold = new BasicItem(2030, "GoldDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustGold, "dustGold");

		dustCoal = new BasicItem(2030, "CoalDust").setCreativeTab(ValuablesTab).setMaxStackSize(64);
		GameRegistry.registerItem(dustCoal, "dustCoal");

		MultiTool = new MultiTool(5000, MyToolMaterial3, "MultiTool").setCreativeTab(ToolsTab);
		GameRegistry.registerItem(MultiTool, "LightningMultiTool");

		LightningLoaf = new LightningLoaf(2040, 20, 5.0F, true, "LightningLoaf").setPotionEffect(Potion.resistance.id, 30, 2, 1.0F).setAlwaysEdible().setCreativeTab(ValuablesTab);
		GameRegistry.registerItem(LightningLoaf, "LightningLoaf");


		//  LOAD THE BLOCK 
		


		Lightning = new BasicItem(2471, "Lightning");
		GameRegistry.registerItem(Lightning, "Lightning");



		C4_1 = new C4().setCreativeTab(WeaponsTab).setStepSound(Block.soundTypeGrass).setBlockName("C4_1");
		GameRegistry.registerBlock(C4_1, "C4");

		//		MinecraftForge.setBlockHarvestLevel(C4_1, "fist", 0);

		Detonater = new Detonater(5001, "Detonater").setCreativeTab(WeaponsTab).setMaxStackSize(1);
		GameRegistry.registerItem(Detonater, "Detonater");

		//  LOAD HELMET 
		MyHelmet_1 = new LightningArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor").setCreativeTab(ArmorTab);
		GameRegistry.registerItem(MyHelmet_1, "LightningHelm");

		//  LOAD CHESTPLATE
		MyChest_1 = new LightningArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor").setCreativeTab(ArmorTab);
		GameRegistry.registerItem(MyChest_1, "LightningChestplate");

		//  LOAD LEGGINGS    
		MyLeggings_1 = new LightningArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor").setCreativeTab(ArmorTab);
		GameRegistry.registerItem(MyLeggings_1, "LightningLegs");


		//  LOAD BOOTS   
		MyBoots_1 = new LightningArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor").setCreativeTab(ArmorTab);
		GameRegistry.registerItem(MyBoots_1, "LightningBoots");


		


		//        Portal = new Portal(2500, "Portal").setLightLevel(0.75F).setResistance(2000000.0F).setHardness(.25F);
		//        GameRegistry.registerBlock(Portal, "Portal");
		//        (Portal, "Portal"); 
		//		MinecraftForge.setBlockHarvestLevel(Portal, "pickaxe", 3);





		//		MinecraftForge.setBlockHarvestLevel(blockMaceratorIdle, "pickaxe", 2);


		//		MinecraftForge.setBlockHarvestLevel(Pipe, "pickaxe", 2);

		blockMaceratorActive = new Macerator(1042, true).setHardness(3.7F).setLightLevel(0.9F).setBlockName("Macerator");
		GameRegistry.registerBlock(blockMaceratorActive, "blockMaceratorActive");

		if (LightningRods == true){    
			LightningRod = new LightningRod(1050, false).setCreativeTab(MachinesTab).setHardness(3.7F).setLightLevel(0.9F).setBlockName("Lightning Rod");
			GameRegistry.registerBlock(LightningRod, "LightningRod");
		}
		//		MinecraftForge.setBlockHarvestLevel(blockMaceratorActive, "pickaxe", 2);


		//		MinecraftForge.setBlockHarvestLevel(ChargerIdle, "pickaxe", 2);

		//ChargerActive = new Charger(1044, true).setHardness(3.7F).setLightLevel(0.9F).setBlockName("Charger");
		//GameRegistry.registerBlock(ChargerActive, "ChargerActive");

		//		MinecraftForge.setBlockHarvestLevel(ChargerActive, "pickaxe", 2);

		//SolarIdle = new Solar(1045, false).setHardness(3.7F).setCreativeTab(MachinesTab).setBlockName("Solar Generator");
		//GameRegistry.registerBlock(SolarIdle, "SolarIdle");

		//		MinecraftForge.setBlockHarvestLevel(SolarIdle, "pickaxe", 2);

		//SolarActive = new Solar(1046, true).setHardness(3.7F).setLightLevel(0.9F).setBlockName("Solar Generator");
		//GameRegistry.registerBlock(SolarActive, "SolarActive");

		//		MinecraftForge.setBlockHarvestLevel(SolarActive, "pickaxe", 2);

		//Solar2Idle = new Solar2(1047, false).setHardness(3.7F).setCreativeTab(MachinesTab).setBlockName("Solar Generator");
		//GameRegistry.registerBlock(Solar2Idle, "Solar2Idle");

		//		MinecraftForge.setBlockHarvestLevel(Solar2Idle, "pickaxe", 2);

		//Solar2Active = new Solar2(1048, true).setHardness(3.7F).setLightLevel(0.9F).setBlockName("Solar Generator");
		//GameRegistry.registerBlock(Solar2Active, "Solar2Active");

		//		MinecraftForge.setBlockHarvestLevel(Solar2Active, "pickaxe", 2);


		Battery = new Battery(6000, "Battery").setCreativeTab(MachinesTab).setMaxStackSize(1);
		GameRegistry.registerItem(Battery, "Battery");


		//        DimensionManager.registerProviderType(Main.dimensionId, MyDimension.class, false);

		//        DimensionManager.registerDimension(Main.dimensionId, Main.dimensionId);



		Grenade = new Grenade(2091, "Grenade").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(Grenade, "Grenade");


		Bullet = new Bullet(2092, "Bullet").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(Bullet, "Bullet");


		//   REGISTER THE PROJECTILE ENTITY
		EntityRegistry.registerGlobalEntityID(GrenadeEntity.class, "Grenade", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(GrenadeEntity.class, "Grenade", 1, this, 256, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.modid.MyProjectile_1.name", "Grenade");

		EntityRegistry.registerGlobalEntityID(LightningEntity.class, "Lightning Orb", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(LightningEntity.class, "Lightning Orb", 2, this, 256, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity.modid.MyProjectile_2.name", "Lightning Orb");



		//         this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball(Items.snowball));



		//		MinecraftForge.setBlockHarvestLevel(Chest, "pickaxe", 0);

		//		PortalPlacer = new PortalPlacer(2561, Material.rock, "PortalPlacer").setLightLevel(0.5F).setResistance(20.0F).setHardness(3.25F);
		//        GameRegistry.registerBlock(PortalPlacer, "PortalPlacer");
		//        (PortalPlacer, "PortalPlacer"); 
		//MinecraftForge.setBlockHarvestLevel(PortalPlacer, "pickaxe", 9);
		if (NetherOres == true){	
			NetherLightning = new BasicBlock(3000, Material.rock, "NetherLightning").setCreativeTab(BlocksTab).setLightLevel(0.5F).setResistance(20.0F).setHardness(3.25F);
			GameRegistry.registerBlock(NetherLightning, "NetherLightning");

			//		MinecraftForge.setBlockHarvestLevel(NetherLightning, "pickaxe", 3);

			NetherDiamond = new BasicBlock(3001, Material.rock, "NetherDiamond").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
			GameRegistry.registerBlock(NetherDiamond, "NetherDiamond");

			//		MinecraftForge.setBlockHarvestLevel(NetherDiamond, "pickaxe", 3);

			NetherCoal = new BasicBlock(3002, Material.rock, "NetherCoal").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(1.25F);
			GameRegistry.registerBlock(NetherCoal, "NetherCoal");

			//		MinecraftForge.setBlockHarvestLevel(NetherCoal, "pickaxe", 2);

			NetherIron = new BasicBlock(3003, Material.rock, "NetherIron").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(2.25F);
			GameRegistry.registerBlock(NetherIron, "NetherIron");

			//		MinecraftForge.setBlockHarvestLevel(NetherIron, "pickaxe", 2);

			NetherGold = new BasicBlock(3004, Material.rock, "NetherGold").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
			GameRegistry.registerBlock(NetherGold, "NetherGold");

			//		MinecraftForge.setBlockHarvestLevel(NetherGold, "pickaxe", 2);

			NetherEmerald = new BasicBlock(3005, Material.rock, "NetherEmerald").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
			GameRegistry.registerBlock(NetherEmerald, "NetherEmerald");

			//		MinecraftForge.setBlockHarvestLevel(NetherEmerald, "pickaxe", 2);

			NetherRedstone = new BasicBlock(3006, Material.rock, "NetherRedstone").setCreativeTab(BlocksTab).setResistance(20.0F).setHardness(3.25F);
			GameRegistry.registerBlock(NetherRedstone, "NetherRedstone");
		}
		//		MinecraftForge.setHarvestLevel(NetherRedstone, "pickaxe", 2);

		GameRegistry.registerTileEntity(TileEntityLightningChest.class, "lightningmats:tileEntityLightningChest");
		GameRegistry.registerTileEntity(TileEntityMacerator.class, "lightningmats:Macerator");
		GameRegistry.registerTileEntity(TileEntityCharger.class, "lightningmats:Charger");
		GameRegistry.registerTileEntity(TileEntitySolar.class, "lightningmats:Solar");
		GameRegistry.registerTileEntity(TileEntitySolar2.class, "lightningmats:Solar2");
		GameRegistry.registerTileEntity(TileEntityLightningRod.class, "lightningmats:LightningRod");
		GameRegistry.registerTileEntity(TileEntityEnergyCell.class, "lightningmats:EnergyCell");
		GameRegistry.registerTileEntity(TileEntityBFurnace.class, "lightningmats:BFurnace");




		Gun_1 = new Gun(300, "Gun").setCreativeTab(WeaponsTab);
		GameRegistry.registerItem(Gun_1, "Gun");



		blockMaceratorIdle = new Macerator(1041, false).setHardness(3.7F).setCreativeTab(MachinesTab).setBlockName("Macerator");
		GameRegistry.registerBlock(blockMaceratorIdle, "blockMaceratorIdle");
		
		BFurnace = new BFurnace(1041, false).setHardness(3.7F).setCreativeTab(MachinesTab).setBlockName("BFurnace");
		GameRegistry.registerBlock(BFurnace, "BFurnace");
		
		BFurnaceActive = new BFurnace(1041, true).setHardness(3.7F).setBlockName("BFurnace");
		GameRegistry.registerBlock(BFurnaceActive, "BFurnaceActive");
		
		Chest = new LightningChest(2).setLightLevel(0.5F).setResistance(20.0F).setHardness(3.25F).setBlockName("Lightning Chest").setCreativeTab(BlocksTab);
		GameRegistry.registerBlock(Chest, "Chest");


		//ChargerIdle = new Charger(1043, false).setHardness(3.8F).setCreativeTab(MachinesTab).setBlockName("Charger");
		//GameRegistry.registerBlock(ChargerIdle, "ChargerIdle");


		/** Achievement Registry*/
		NickelAch = new Achievement("Nickel", "NickelAch", 0, 0, NickelOre, null).registerStat();
		PlatinumAch = new Achievement("Platinum", "PlatinumAch", -1, -2, PlatinumOre, NickelAch).registerStat();
		LightningAch = new Achievement("Lightning", "LightningAch", -3, -3, LightningOre, NickelAch).registerStat();
		SolarAch = new Achievement("Solar", "SolarAch", -2, -1, SolarIdle, LightningAch).registerStat();
		SwordAch = new Achievement("Sword", "SwordAch", -4, -0, LightningSword, LightningAch).registerStat();
		AllInOne = new Achievement("AllInOne", "AllInOne", -1, 1, MultiTool, SwordAch).registerStat();
		AchievementPage.registerAchievementPage(new AchievementPage("Lightning Materials", new Achievement[] {NickelAch, PlatinumAch, LightningAch, AllInOne, SolarAch, SwordAch}));
		/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}
	@EventHandler
	@SideOnly(Side.CLIENT)
	public void dothings(FMLInitializationEvent event){
		proxy.registerRenderThings();
		RenderingRegistry.registerEntityRenderingHandler(GrenadeEntity.class, new RenderGrenade(Grenade));
		RenderingRegistry.registerEntityRenderingHandler(LightningEntity.class, new RenderLightning(Lightning));

	}
	@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{

		String $CAPES_JSON = "https://raw.githubusercontent.com/UnnamedProdigy/LightningMaterials/master/capes.json";
            DevCapes.getInstance().registerConfig($CAPES_JSON);
		
		/**	
		 * RECIPES SECTION 
		 * *********************************************************** */
		//TODO




		GameRegistry.addRecipe(new ItemStack(Bullet, 4), new Object[]
				{

			"X",
			"s",
			's', Items.arrow,
			'X', Items.iron_ingot,
				});GameRegistry.addRecipe(new ItemStack(Battery, 1, Battery.getMaxDamage()), new Object[]
						{
					" s ",
					"sXs",
					" s ",
					'X', LightningNugget,
					's', Items.iron_ingot,
						});
				GameRegistry.addRecipe(new ItemStack(LightningRod, 1), new Object[]
						{
					"X",
					"s",
					"s",
					'X', LightningNugget,
					's', Items.iron_ingot,
						});
				GameRegistry.addRecipe(new ItemStack(blockMaceratorIdle, 1), new Object[]
						{
					"XXX",
					"XsX",
					"XXX",
					's', Blocks.furnace,
					'X', LightningNugget,
						});
				
				GameRegistry.addRecipe(new ItemStack(BFurnace, 1), new Object[]
						{
					"XXX",
					"XsX",
					"XXX",
					's', Blocks.furnace,
					'X', NickelIngot,
						});
				
				GameRegistry.addRecipe(new ItemStack(LightningSword, 1), new Object[]
						{
					" X ",
					" X ",
					" S ",
					'S', Items.stick,
					'X', LightningIngot,
						});

				GameRegistry.addRecipe(new ItemStack(NickelSword, 1), new Object[]
						{
					" X ",
					" X ",
					" S ",
					'S', Items.stick,
					'X', NickelSword,
						});

				GameRegistry.addRecipe(new ItemStack(PlatinumSword, 1), new Object[]
						{
					" X ",
					" X ",
					" S ",
					'S', Items.stick,
					'X', PlatinumSword,
						});
				if (DisableZinc==false){
					GameRegistry.addRecipe(new ItemStack(ZincSword, 1), new Object[]
							{
						" X ",
						" X ",
						" S ",
						'S', Items.stick,
						'X', ZincIngot,
							});
				}
				GameRegistry.addRecipe(new ItemStack(RubySword, 1), new Object[]
						{
					" X ",
					" X ",
					" S ",
					'S', Items.stick,
					'X', Ruby,
						});

				GameRegistry.addRecipe(new ItemStack(AmethystSword, 1), new Object[]
						{
					" X ",
					" X ",
					" S ",
					'S', Items.stick,
					'X', Amethyst,
						});

				GameRegistry.addRecipe(new ItemStack(SapphireSword, 1), new Object[]
						{
					" X ",
					" X ",
					" S ",
					'S', Items.stick,
					'X', Sapphire,
						});

				GameRegistry.addRecipe(new ItemStack(EmeraldSword, 1), new Object[]
						{
					" X ",
					" X ",
					" S ",
					'S', Items.stick,
					'X', Items.emerald,
						});

				//  PICKAXE RECIPE  
				GameRegistry.addRecipe(new ItemStack(LightningPickaxe, 1), new Object[]
						{
					"XXX",
					" S ",
					" S ",
					'S', Items.stick,
					'X', LightningIngot,
						});
				if (DisableZinc==false){
					GameRegistry.addRecipe(new ItemStack(NickelPick, 1), new Object[]
							{
						"XXX",
						" S ",
						" S ",
						'S', Items.stick,
						'X', NickelIngot,
							});
				}
				GameRegistry.addRecipe(new ItemStack(PlatinumPick, 1), new Object[]
						{
					"XXX",
					" S ",
					" S ",
					'S', Items.stick,
					'X', PlatinumIngot,
						});

				GameRegistry.addRecipe(new ItemStack(ZincPick, 1), new Object[]
						{
					"XXX",
					" S ",
					" S ",
					'S', Items.stick,
					'X', ZincIngot,
						});

				GameRegistry.addRecipe(new ItemStack(RubyPick, 1), new Object[]
						{
					"XXX",
					" S ",
					" S ",
					'S', Items.stick,
					'X', Ruby,
						});

				GameRegistry.addRecipe(new ItemStack(AmethystPick, 1), new Object[]
						{
					"XXX",
					" S ",
					" S ",
					'S', Items.stick,
					'X', Amethyst,
						});

				GameRegistry.addRecipe(new ItemStack(SapphirePick, 1), new Object[]
						{
					"XXX",
					" S ",
					" S ",
					'S', Items.stick,
					'X', Sapphire,
						});

				GameRegistry.addRecipe(new ItemStack(EmeraldPick, 1), new Object[]
						{
					"XXX",
					" S ",
					" S ",
					'S', Items.stick,
					'X', Items.emerald,
						});

				//  AXE RECIPE  
				GameRegistry.addRecipe(new ItemStack(LightningAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', LightningIngot,
						});
				
				GameRegistry.addRecipe(new ItemStack(NickelAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', NickelIngot,
						});
				
				GameRegistry.addRecipe(new ItemStack(PlatinumAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', PlatinumIngot,
						});
				if (DisableZinc==false){
				GameRegistry.addRecipe(new ItemStack(ZincAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', ZincIngot,
						});}
				
				GameRegistry.addRecipe(new ItemStack(RubyAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', Ruby,
						});
				
				GameRegistry.addRecipe(new ItemStack(SapphireAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', Sapphire,
						});
				
				GameRegistry.addRecipe(new ItemStack(AmethystAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', Amethyst,
						});
				
				GameRegistry.addRecipe(new ItemStack(EmeraldAxe, 1), new Object[]
						{
					"XX ",
					"XS ",
					" S ",
					'S', Items.stick,
					'X', Items.emerald,
						});
				
				GameRegistry.addRecipe(new ItemStack(LightningAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', LightningIngot,
						});
				
				GameRegistry.addRecipe(new ItemStack(NickelAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', NickelIngot,
						});
				
				GameRegistry.addRecipe(new ItemStack(PlatinumAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', PlatinumIngot,
						});
				if (DisableZinc==false){
				GameRegistry.addRecipe(new ItemStack(ZincAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', ZincIngot,
						});}
				
				GameRegistry.addRecipe(new ItemStack(RubyAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', Ruby,
						});
				
				GameRegistry.addRecipe(new ItemStack(SapphireAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', Sapphire,
						});
				
				GameRegistry.addRecipe(new ItemStack(AmethystAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', Amethyst,
						});
				
				GameRegistry.addRecipe(new ItemStack(EmeraldAxe, 1), new Object[]
						{
					" XX",
					" SX",
					" S ",
					'S', Items.stick,
					'X', Items.emerald,
						});

				//  SPADE RECIPE  
				GameRegistry.addRecipe(new ItemStack(LightningSpade, 1), new Object[]
						{
					" X ",
					" S ",
					" S ",
					'S', Items.stick,
					'X', LightningIngot,
						});
				GameRegistry.addRecipe(new ItemStack(NickelSpade, 1), new Object[]
						{
					" X ",
					" S ",
					" S ",
					'S', Items.stick,
					'X', NickelIngot,
						});
				GameRegistry.addRecipe(new ItemStack(PlatinumAxe, 1), new Object[]
						{
					" X ",
					" S ",
					" S ",
					'S', Items.stick,
					'X', PlatinumIngot,
						});
				if(DisableZinc==false){
				GameRegistry.addRecipe(new ItemStack(ZincAxe, 1), new Object[]
						{
					" X ",
					" S ",
					" S ",
					'S', Items.stick,
					'X', ZincIngot,
						});}
				GameRegistry.addRecipe(new ItemStack(RubyAxe, 1), new Object[]
						{
					" X ",
					" S ",
					" S ",
					'S', Items.stick,
					'X', Ruby,
						});
				GameRegistry.addRecipe(new ItemStack(SapphireAxe, 1), new Object[]
						{
					" X ",
					" S ",
					" S ",
					'S', Items.stick,
					'X', Sapphire,
						});
				GameRegistry.addRecipe(new ItemStack(AmethystAxe, 1), new Object[]
						{
					" X ",
					" S ",
					" S ",
					'S', Items.stick,
					'X', Amethyst,
						});
				

				//  SPADE RECIPE  
				GameRegistry.addRecipe(new ItemStack(MultiTool, 1), new Object[]
						{
					"XTF",
					" Z ",
					" S ",
					'S', Items.stick,
					'X', new ItemStack(LightningAxe, 1, OreDictionary.WILDCARD_VALUE),
					'F', new ItemStack(LightningPickaxe, 1, OreDictionary.WILDCARD_VALUE), 
					'T', new ItemStack(LightningSpade, 1, OreDictionary.WILDCARD_VALUE),
					'Z', new ItemStack(LightningSword, 1, OreDictionary.WILDCARD_VALUE),										});

				//  ITEM RECIPE         
				GameRegistry.addRecipe(new ItemStack(LightningIngot, 1), new Object[]
						{
					"SSS",
					"SSS",
					"SSS",
					'S', LightningNugget,
						});

				GameRegistry.addRecipe(new ItemStack(LightningNugget, 9), new Object[]
						{

					"S",

					'S', LightningIngot,
						});

				//  FOOD RECIPE         
				GameRegistry.addRecipe(new ItemStack(LightningLoaf, 1), new Object[]
						{
					"SSS",
					"SBS",
					"SSS",
					'S', LightningNugget,
					'B', Items.bread,
						});

				GameRegistry.addRecipe(new ItemStack(C4_1, 6), new Object[]
						{
					"sss",
					"sss",
					"sss",
					's', Blocks.tnt,
						});

				GameRegistry.addRecipe(new ItemStack(Detonater, 1), new Object[]
						{
					"s",
					"x",
					"z",
					's', Items.redstone,
					'x', Items.flint_and_steel,
					'z', Items.iron_ingot,
						});
				//  SMELTING RECIPE
				
				//  HELMET RECIPE   
				GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
						{
					"XXX",
					"X X",
					'X', LightningIngot,
						});         

				//  CHESTPLATE RECIPE   
				GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
						{
					"X X",
					"XXX",
					"XXX",
					'X', LightningIngot,
						});         

				//  LEGGINGS RECIPE 
				GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
						{
					"XXX",
					"X X",
					"X X",
					'X', LightningIngot,
						});         

				//  BOOTS RECIPE    
				GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
						{
					"X X",
					"X X",
					'X', LightningIngot,
						});	
				GameRegistry.addRecipe(new ItemStack(Gun_1, 1), new Object[]
						{
					"   ",
					"XXS",
					"  X",
					'S', Items.redstone,
					'X', LightningNugget,
						});
				GameRegistry.addRecipe(new ItemStack(Grenade, 4), new Object[]
						{
					" Z ",
					"XVX",
					"XXX",
					'V', C4_1,
					'X', Items.iron_ingot,
					'Z', Items.redstone,
						});

				GameRegistry.addRecipe(new ItemStack(Chest, 1), new Object[]
						{
					"XXX",
					"XSX",
					"XXX",
					'S', Blocks.chest,
					'X', LightningNugget,
						});

				GameRegistry.addRecipe(new ItemStack(FlintAndSteel, 1), new Object[]
						{
					"X",
					"S",

					'S', Items.flint_and_steel,
					'X', LightningNugget,
						});
				if (NetherOres==true){
					GameRegistry.addRecipe(new ItemStack(Blocks.emerald_ore, 2), new Object[]
							{

						"X",
						'X', NetherEmerald,
							});

					GameRegistry.addRecipe(new ItemStack(Blocks.diamond_ore, 2), new Object[]
							{
						"X",
						'X', NetherDiamond,
							});

					GameRegistry.addRecipe(new ItemStack(Blocks.coal_ore, 2), new Object[]
							{
						"X",
						'X', NetherCoal,
							});

					GameRegistry.addRecipe(new ItemStack(Blocks.redstone_ore, 2), new Object[]
							{
						"X",
						'X', NetherRedstone,
							});}
				if (NetherOres==true){
					GameRegistry.addSmelting(NetherLightning, (new ItemStack(LightningIngot, 2)), 10);}
				GameRegistry.addSmelting(Blocks.coal_ore, (new ItemStack(Items.coal, 1)), 10);
				if (NetherOres==true){GameRegistry.addSmelting(NetherIron, (new ItemStack(Items.iron_ingot, 2)), 10);
				GameRegistry.addSmelting(NetherGold, (new ItemStack(Items.gold_ingot, 2)), 10);}
				GameRegistry.addSmelting(LightningOre, (new ItemStack(LightningIngot, 1)), 10);
				GameRegistry.addSmelting(NickelOre, (new ItemStack(NickelIngot, 1)), 10);
				GameRegistry.addSmelting(PlatinumOre, (new ItemStack(PlatinumIngot, 1)), 10);
				GameRegistry.addSmelting(ZincOre, (new ItemStack(ZincIngot, 1)), 10);
				GameRegistry.addSmelting(RubyOre, (new ItemStack(Ruby, 1)), 10);
				GameRegistry.addSmelting(AmethystOre, (new ItemStack(Amethyst, 1)), 10);
				GameRegistry.addSmelting(SapphireOre, (new ItemStack(Sapphire, 1)), 10);
				//Dust
				GameRegistry.addSmelting(dustNickel, (new ItemStack(NickelIngot, 1)), 10);
				GameRegistry.addSmelting(dustPlatinum, (new ItemStack(PlatinumIngot, 1)), 10);
				GameRegistry.addSmelting(dustZinc, (new ItemStack(ZincIngot, 1)), 10);
				GameRegistry.addSmelting(dustRuby, (new ItemStack(Ruby, 1)), 10);
				GameRegistry.addSmelting(dustSapphire, (new ItemStack(Sapphire, 1)), 10);
				GameRegistry.addSmelting(dustAmethyst, (new ItemStack(Amethyst, 1)), 10);
				GameRegistry.addSmelting(dustEmerald, (new ItemStack(Items.emerald, 1)), 10);
				GameRegistry.addSmelting(dustDiamond, (new ItemStack(Items.diamond, 1)), 10);
				GameRegistry.addSmelting(dustGold, (new ItemStack(Items.gold_ingot, 1)), 10);
				GameRegistry.addSmelting(dustIron, (new ItemStack(Items.iron_ingot, 1)), 10);
				GameRegistry.addSmelting(dustCoal, (new ItemStack(Items.coal, 1)), 10);
				Recipes.addSmelting(NickelOre, (new ItemStack(dustNickel, 1)), 10);
				Recipes.addSmelting(PlatinumOre, (new ItemStack(dustPlatinum, 1)), 10);
				Recipes.addSmelting(ZincOre, (new ItemStack(dustZinc, 1)), 10);
				Recipes.addSmelting(RubyOre, (new ItemStack(dustRuby, 1)), 10);
				Recipes.addSmelting(AmethystOre, (new ItemStack(dustAmethyst, 1)), 10);
				Recipes.addSmelting(SapphireOre, (new ItemStack(dustSapphire, 1)), 10);
				Recipes.addSmelting(Blocks.coal_ore, new ItemStack(dustCoal, 1),  10);
				Recipes.addSmelting(Blocks.iron_ore, new ItemStack(dustIron, 1),  10);
				Recipes.addSmelting(Blocks.gold_ore, new ItemStack(dustGold, 1),  10);
				Recipes.addSmelting(Blocks.diamond_ore, new ItemStack(dustDiamond, 1),  10);
				Recipes.addSmelting(Blocks.emerald_ore, new ItemStack(dustEmerald, 1),  10);
				if (isTFLoaded==true){
					Recipes.addSmelting(Blocks.obsidian, new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 4), 10);
				}
				if (isTFLoaded==true && TFRecipes==true){
					Recipes.addSmelting(new ItemStack(GameRegistry.findBlock("ThermalFoundation", "Ore"), 1, 1), new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 33), 10);
					Recipes.addSmelting(new ItemStack(GameRegistry.findBlock("ThermalFoundation", "Ore"), 1, 0), new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 32), 10);
					Recipes.addSmelting(new ItemStack(GameRegistry.findBlock("ThermalFoundation", "Ore"), 1, 2), new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 34), 10);
					Recipes.addSmelting(new ItemStack(GameRegistry.findBlock("ThermalFoundation", "Ore"), 1, 3), new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 35), 10);
					Recipes.addSmelting(new ItemStack(GameRegistry.findBlock("ThermalFoundation", "Ore"), 1, 4), new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 36), 10);
					Recipes.addSmelting(new ItemStack(GameRegistry.findBlock("ThermalFoundation", "Ore"), 1, 5), new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 37), 10);
					Recipes.addSmelting(new ItemStack(GameRegistry.findBlock("ThermalFoundation", "Ore"), 1, 6), new ItemStack(GameRegistry.findItem("ThermalFoundation", "material"), 1, 38), 10);
				}
System.out.println("Thermal Foundation Loaded Status: " + isTFLoaded);
				/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


				/**	
				 * EXTRA METHODS SECTION 
				 * *********************************************************** */


				//  CHANGE TAB NAME



				//								 MyBiome_1 = new MyBiome(300);
				//								GameRegistry.registerWorldGenerator((IWorldGenerator)MyBiome_1, 300);
				PickupHandler PickupHandler = new PickupHandler();
				FMLCommonHandler.instance().bus().register(new PickupHandler());
				if (IngameModOptions == true){
					MinecraftForge.EVENT_BUS.register(new IngameOptions());}
				GameRegistry.registerWorldGenerator(new GemOreGen(), 3);
				GameRegistry.registerWorldGenerator(new OreGen(), 2);
				GameRegistry.registerWorldGenerator(new OreGen1(), 0);



				/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


	}
	


	@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	@EventHandler
	public void server(FMLServerStartingEvent event){
		event.registerServerCommand(new Command3());	
		event.registerServerCommand(new Command4());
	}
	@EventHandler 
	public void serverinit(FMLServerStartedEvent event){
		this.side = "server";
	}





}
