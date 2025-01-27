package lightningmats.handlers;

import lightningmats.LightningMaterials;
import net.minecraftforge.client.event.GuiOpenEvent;
import cpw.mods.fml.client.GuiIngameModOptions;
import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IngameOptions extends Event {
@SideOnly(Side.CLIENT)
@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
public void onEvent(GuiOpenEvent gui){
	if (LightningMaterials.config.get("Mod Compatability", "Ingame Mod Options", true, "May Cause Problems With Other Mods").getBoolean()==true){
	if (gui.gui instanceof GuiIngameModOptions)
	{
		gui.gui = new GuiModList(null);
	}
	}
}
}
