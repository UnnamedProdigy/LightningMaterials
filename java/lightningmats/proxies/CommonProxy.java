/**
 * 	Used to register sounds and textures that we want to load before our Mod is initialized
 */

package lightningmats.proxies;

import com.jadarstudios.developercapes.DevCapes;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import lightningmats.LightningMaterials;
import lightningmats.entity.chest.ChestRenderer;
import lightningmats.entity.chest.ItemLightningChestRender;
import lightningmats.entity.chest.TileEntityLightningChest;
import lightningmats.items.render.GunRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CommonProxy {
	@SideOnly(Side.CLIENT)
	public void registerRenderThings(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightningChest.class, new ChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(LightningMaterials.Chest), (IItemRenderer)new ItemLightningChestRender());
		if (LightningMaterials.config.get("Client Side", "Render The Gun In 3D", true).getBoolean()==true){
			MinecraftForgeClient.registerItemRenderer(LightningMaterials.Gun_1, (IItemRenderer)new GunRenderer());
		}
		}
}