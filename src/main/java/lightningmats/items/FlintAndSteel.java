package lightningmats.items;

import lightningmats.LightningMaterials;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FlintAndSteel extends Item
{
private String texturePath = "mymod:";

    public FlintAndSteel(int ItemID, String textureName)
    
     
     {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(64);
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setUnlocalizedName(textureName);
        texturePath += textureName;
        
    }
    

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
//    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
//    {
//        if (par7 == 0)
//        {
//            --par5;
//        }
//
//        if (par7 == 1)
//        {
//            ++par5;
//        }
//
//        if (par7 == 2)
//        {
//            --par6;
//        }
//
//        if (par7 == 3)
//        {
//            ++par6;
//        }
//
//        if (par7 == 4)
//        {
//            --par4;
//        }
//
//        if (par7 == 5)
//        {
//            ++par4;
//        }
//
//        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
//        {
//            return false;
//        }
//        else
//        {
//            if (par3World.isAirBlock(par4, par5, par6))
//            {
//                par3World.playSoundEffect((double)par4 + 0.5D, (double)par5 + 0.5D, (double)par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
//                par3World.setBlock(par4, par5, par6, Main.PortalPlacer);
//            }
//
//            par1ItemStack.damageItem(1, par2EntityPlayer);
//            return true;
//        }
//    }
     public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }  
}
