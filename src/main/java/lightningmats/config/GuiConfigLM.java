package lightningmats.config;

import java.util.ArrayList;
import java.util.List;

import lightningmats.LightningMaterials;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.ConfigGuiType;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.DummyConfigElement.DummyListElement;
import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries.NumberSliderEntry;
import cpw.mods.fml.client.config.IConfigElement;

public class GuiConfigLM extends GuiConfig{

	private static String[] ClientConfig = {"client side"};
	private static String[] ServerConfig = {"server side"};
	private static String[] ModCompConfig = {"mod compatability"};
	private static String[] OreGenConfig = {"ore generation"};
	
	public GuiConfigLM(GuiScreen parent){
		
		super(parent, getElements(parent), LightningMaterials.modid, false, false, "�6Options For Lightning Materials");
		titleLine2 = "�9Lightning Materials";
	}
	@Override
	public void initGui(){
		
		super.initGui();
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		
	}
	
	@Override
	public void actionPerformed(GuiButton button){
		
		super.actionPerformed(button);
		LightningMaterials.config.save();
		LightningMaterials.proxy.registerRenderThings();
	}
	 private static List<IConfigElement> getElements(GuiScreen parent){
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		 
		list.add(new DummyCategoryElement("Client Side", "clientctg", getClientElements()));
		list.add(new DummyCategoryElement("Server Side", "serverctg", getServerElements()));
		list.add(new DummyCategoryElement("Mod Compatability", "modcompctg", getModCompElements()));
		
		 
		 return list;
		 
	 }
	 
	 private static List<IConfigElement> getClientElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < ClientConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("client side")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getServerElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < ServerConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("server side")).getChildElements()); 
		  			list.add(new DummyCategoryElement("Ore Generation", "oregenctg", getOreGenElements()));
		  			list.add(new DummyCategoryElement("Machines", "machinesctg", getMachinesElements()));
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getMachinesElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		 
		 for (int i = 0; i< ServerConfig.length; i++)
		 {
			 list.add(new DummyCategoryElement("Crusher", "crusherctg", getCrusherElements()));
			 list.add(new DummyCategoryElement("Nickel Furnace", "furnacectg", getFurnaceElements()));
		 }
		 return list;
	 }
	 
	 private static List<IConfigElement> getModCompElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < ModCompConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("mod compatability")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getOreGenElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.add(new DummyCategoryElement("Lightning Ore", "lightningctg", getLightningElements())); 
		  			list.add(new DummyCategoryElement("Nickel Ore", "nickelctg", getNickelElements()));
		  			list.add(new DummyCategoryElement("Zinc Ore", "zincctg", getZincElements())); 
		  			list.add(new DummyCategoryElement("Platinum Ore", "platinumctg", getPlatinumElements())); 
		  			list.add(new DummyCategoryElement("Ruby Ore", "rubyctg", getRubyElements()));
		  			list.add(new DummyCategoryElement("Sapphire Ore", "sapphirectg", getSapphireElements())); 
		  			list.add(new DummyCategoryElement("Amethyst Ore", "amethystctg", getAmethystElements())); 
		  			if (LightningMaterials.NetherOres == true){
		  			list.add(new DummyCategoryElement("Nether Ores", "netherctg", getNetherElements())); }
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNetherElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.add(new DummyCategoryElement("Nether Lightning Ore", "netherlightningctg", getNetherLightningElements() ));
		  			list.add(new DummyCategoryElement("Nether Diamond Ore", "netherdiamondctg", getNetherDiamondElements() ));
		  			list.add(new DummyCategoryElement("Nether Gold Ore", "nethergold", getNetherGoldElements() ));
		  			list.add(new DummyCategoryElement("Nether Iron Ore", "netherironctg", getNetherIronElements() ));
		  			list.add(new DummyCategoryElement("Nether Emerald Ore", "netheremeraldctg", getNetherEmeraldElements() ));
		  			list.add(new DummyCategoryElement("Nether Coal Ore", "nethercoalctg", getNetherCoalElements() ));
		  			list.add(new DummyCategoryElement("Nether Redstone Ore", "netherredstonectg", getNetherRedstoneElements() ));
		  			
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getLightningElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("lightning ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNickelElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nickel ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getZincElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("zinc ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getPlatinumElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("platinum ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getRubyElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("ruby ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getSapphireElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("sapphire ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getAmethystElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("amethyst ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }

	 private static List<IConfigElement> getNetherLightningElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nether lightning ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNetherDiamondElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nether diamond ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNetherGoldElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nether gold ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNetherRedstoneElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nether redstone ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNetherIronElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nether iron ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNetherCoalElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nether coal ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getNetherEmeraldElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < OreGenConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nether emerald ore generation")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getCrusherElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < ServerConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("crusher")).getChildElements()); 
		  		} 
		 		return list; 

	 }
	 
	 private static List<IConfigElement> getFurnaceElements(){
		 List<IConfigElement> list = new ArrayList<IConfigElement>(); 
		  
		  
		  		for (int i = 0; i < ServerConfig.length; i++) { 
		  			list.addAll(new ConfigElement(LightningMaterials.config.getCategory("nickel furnace")).getChildElements()); 
		  		} 
		 		return list; 

	 }

	 
	 
}
