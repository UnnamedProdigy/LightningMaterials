package lightningmats.handlers;

import lightningmats.LightningMaterials;
import lightningmats.power.charger.ContainerCharger;
import lightningmats.power.charger.GuiCharger;
import lightningmats.power.charger.TileEntityCharger;
import lightningmats.power.macerator.ContainerMacerator;
import lightningmats.power.macerator.GuiMacerator;
import lightningmats.power.macerator.TileEntityMacerator;
import lightningmats.power.solar.ContainerSolar;
import lightningmats.power.solar.ContainerSolar2;
import lightningmats.power.solar.GuiSolar;
import lightningmats.power.solar.GuiSolar2;
import lightningmats.power.solar.TileEntitySolar;
import lightningmats.power.solar.TileEntitySolar2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import lightningmats.power.nickelfurnace.ContainerNickelFurnace;
import lightningmats.power.nickelfurnace.GuiNickelFurnace;
import lightningmats.power.nickelfurnace.TileEntityNickelFurnace;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler{
		public GuiHandler() {
			NetworkRegistry.INSTANCE.registerGuiHandler(LightningMaterials.instance, this);
		}

		
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			TileEntity entity = world.getTileEntity(x, y, z);

			if(entity != null){
				switch (id) {
					case LightningMaterials.guiIdSolar:
						if (entity instanceof TileEntitySolar) {
							return new ContainerSolar(player.inventory, (TileEntitySolar) entity);
						} 
						case LightningMaterials.guiIdCharger:
						if (entity instanceof TileEntityCharger) {
							return new ContainerCharger(player.inventory, (TileEntityCharger) entity);
							
						} 
						
						case LightningMaterials.guiIdMacerator:
						if (entity instanceof TileEntityMacerator) {
							return new ContainerMacerator(player.inventory, (TileEntityMacerator) entity);
						} 
						case LightningMaterials.guiIdSolar2:
						if (entity instanceof TileEntitySolar2) {
							return new ContainerSolar2(player.inventory, (TileEntitySolar2) entity);
						} 
						
						case LightningMaterials.guiIdBFurnace:
							if (entity instanceof TileEntityNickelFurnace) {
								return new ContainerNickelFurnace(player.inventory, (TileEntityNickelFurnace) entity);
							} 
					
						return null;
					default:
						return null;
				}
			}
			
			return null;
		}

		
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			TileEntity entity = world.getTileEntity(x, y, z);

			if(entity != null){
				switch (id) {
					case LightningMaterials.guiIdSolar:
						if (entity instanceof TileEntitySolar) {
							return new GuiSolar(player.inventory, (TileEntitySolar) entity);
						} 
			case LightningMaterials.guiIdCharger:
						if (entity instanceof TileEntityCharger) {
							return new GuiCharger(player.inventory, (TileEntityCharger) entity);
						} 
						case LightningMaterials.guiIdMacerator:
						if (entity instanceof TileEntityMacerator) {
							return new GuiMacerator(player.inventory, (TileEntityMacerator) entity);
						} 
						case LightningMaterials.guiIdSolar2:
						if (entity instanceof TileEntitySolar2) {
							return new GuiSolar2(player.inventory, (TileEntitySolar2) entity);
						} 
						
						case LightningMaterials.guiIdBFurnace:
							if (entity instanceof TileEntityNickelFurnace) {
								return new GuiNickelFurnace(player.inventory, (TileEntityNickelFurnace) entity);
							}
						
						return null;
					default:
						return null;
				}
			}

			return null;
					
				
			

			
		}	
	}
