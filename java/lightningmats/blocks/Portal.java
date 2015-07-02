package lightningmats.blocks;
//package mymod.blocks;
//
//import java.util.Random;
//
//import mymod.blocks.MyDimension1;
//
//import com.example.examplemod.copy.Main;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockPortal;
//import net.minecraft.block.material.Material;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.entity.Entity;
//import net.minecraft.entity.player.EntityPlayerMP;
//import net.minecraft.init.Blocks;
//import net.minecraft.item.ItemMonsterPlacer;
//import net.minecraft.util.ChunkCoordinates;
//import net.minecraft.util.Direction;
//import net.minecraft.world.World;
//
//public class Portal extends BlockPortal {
//
//    private String texturePath = "mymod:";  
//    private int thisBlockID;
//    private World field_150867_a;
//    public Portal(int id, String texture) {
//        
//        super();
//        this.setBlockName(textureName);
//        texturePath += textureName;
//        thisBlockID = id;
//    }
//
//    public int idDropped(int par1, Random par2Random, int par3)
//    {
//        return thisBlockID;
//    }
//    
//    public int quantityDropped(Random random)
//    {
//        return 0;
//    }
//
//    public void registerIcons(IIconRegister iconRegister)
//    {
//        this.blockIcon = iconRegister.registerIcon(texturePath);}
//    
//    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
//    {
//        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
//
//        if (p_149674_1_.provider.isSurfaceWorld() && p_149674_1_.getGameRules().getGameRuleBooleanValue("doMobSpawning") && p_149674_5_.nextInt(2000) < p_149674_1_.difficultySetting.getDifficultyId())
//        {
//            int l;
//
//            for (l = p_149674_3_; !World.doesBlockHaveSolidTopSurface(p_149674_1_, p_149674_2_, l, p_149674_4_) && l > 0; --l)
//            {
//                ;
//            }
//
//            if (l > 0 && !p_149674_1_.getBlock(p_149674_2_, l + 1, p_149674_4_).isNormalCube())
//            {
//                Entity entity = ItemMonsterPlacer.spawnCreature(p_149674_1_, 57, (double)p_149674_2_ + 0.5D, (double)l + 1.1D, (double)p_149674_4_ + 0.5D);
//
//                if (entity != null)
//                {
//                    entity.timeUntilPortal = entity.getPortalCooldown();
//                }
//            }
//        }
//    }
//    private int field_150864_e = 0;
//    
//    
//    private  int field_150865_b;
//    private  int field_150866_c;
//    private  int field_150863_d;
//    
//    private ChunkCoordinates field_150861_f;
//    private int field_150862_g;
//    private int field_150868_h;
//    private static final String __OBFID = "CL_00000285";
//    protected boolean func_150857_a(Block p_150857_1_)
//    {
//        return p_150857_1_.getMaterial() == Material.air || p_150857_1_ == Blocks.fire || p_150857_1_ == Blocks.portal;
//    }
//    protected int func_150858_a()
//    {
//        int i;
//        int j;
//        int k;
//        int l;
//        label56:
//
//        for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g)
//        {
//            i = this.field_150861_f.posY + this.field_150862_g;
//
//            for (j = 0; j < this.field_150868_h; ++j)
//            {
//                k = this.field_150861_f.posX + j * Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]];
//                l = this.field_150861_f.posZ + j * Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]];
//                Block block = this.field_150867_a.getBlock(k, i, l);
//
//                if (!this.func_150857_a(block))
//                {
//                    break label56;
//                }
//
//                if (block == Blocks.portal)
//                {
//                    ++this.field_150864_e;
//                }
//
//                if (j == 0)
//                {
//                    block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][0]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][0]]);
//
//                    if (block != Blocks.obsidian)
//                    {
//                        break label56;
//                    }
//                }
//                else if (j == this.field_150868_h - 1)
//                {
//                    block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]], i, l + Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]]);
//                
//                    if (block != Blocks.obsidian)
//                
//                    {
//                        break label56;
//                    }
//                }
//            }
//        }for (i = 0; i < this.field_150868_h; ++i)
//        {
//            j = this.field_150861_f.posX + i * Direction.offsetX[BlockPortal.field_150001_a[this.field_150865_b][1]];
//            k = this.field_150861_f.posY + this.field_150862_g;
//            l = this.field_150861_f.posZ + i * Direction.offsetZ[BlockPortal.field_150001_a[this.field_150865_b][1]];
//
//            if (this.field_150867_a.getBlock(j, k, l) != Blocks.obsidian)
//            {
//                this.field_150862_g = 0;
//                break;
//            }
//        }
//
//        if (this.field_150862_g <= 21 && this.field_150862_g >= 3)
//        {
//            return this.field_150862_g;
//        }
//        else
//        {
//            this.field_150861_f = null;
//            this.field_150868_h = 0;
//            this.field_150862_g = 0;
//            return 0;
//        }
//    }
//
//    /**
//     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
//     * their own) Args: x, y, z, neighbor blockID
//     */
//    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
//    {
//        byte b0 = 0;
//        byte b1 = 1;
//
//        if (par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this)
//        {
//            b0 = 1;
//            b1 = 0;
//        }
//
//        int i1;
//        
//
//            
//
//        for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1)
//        {
//            ;
//        }
//if (par1World.getBlock(par2, i1 - 1, par4) != Blocks.gold_block)
//        {
//            par1World.setBlockToAir(par2, par3, par4);
//        }
//        else
//        {
//            int j1;
//
//            for (j1 = 1; j1 < 4 && par1World.getBlock(par2, i1 + j1, par4) == this; ++j1)
//            {
//                ;
//            }
//
//            if (j1 == 3 && par1World.getBlock(par2, i1 + j1, par4) == Blocks.gold_block)
//            {
//                boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this || par1World.getBlock(par2 + 1, par3, par4) == this;
//                boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == this || par1World.getBlock(par2, par3, par4 + 1) == this;
//
//                if (flag && flag1)
//                {
//                    par1World.setBlockToAir(par2, par3, par4);
//                }
//                else
//                {
//                    if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != Blocks.gold_block || par1World.getBlock(par2 - b0, par3, par4 - b1) != this) && (par1World.getBlock(par2 - b0, par3, par4 - b1) != Blocks.gold_block || par1World.getBlock(par2 + b0, par3, par4 + b1) != this))
//                    {
//                        par1World.setBlockToAir(par2, par3, par4);
//                    }
//                }
//            }
//            else
//            {
//                par1World.setBlockToAir(par2, par3, par4);
//            }}
//       
//        }
//        
//        
//     public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
//    {
//    	 
//        if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
//        {
//            if(par5Entity instanceof EntityPlayerMP)
//            {
//            EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
//            if(par5Entity.dimension != 5)
//            {
//            thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 5, new MyDimension1(thePlayer.mcServer.worldServerForDimension(5)));
//            }
//            else
//            {
//            thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new MyDimension1(thePlayer.mcServer.worldServerForDimension(0)));
//           
//}}}}public void Size(World p_i45415_1_, int p_i45415_2_, int p_i45415_3_, int p_i45415_4_, int p_i45415_5_)
//{
//    this.field_150867_a = p_i45415_1_;
//    this.field_150865_b = p_i45415_5_;
//    this.field_150863_d = BlockPortal.field_150001_a[p_i45415_5_][0];
//    this.field_150866_c = BlockPortal.field_150001_a[p_i45415_5_][1];
//
//    for (int i1 = p_i45415_3_; p_i45415_3_ > i1 - 21 && p_i45415_3_ > 0 && this.func_150857_a(p_i45415_1_.getBlock(p_i45415_2_, p_i45415_3_ - 1, p_i45415_4_)); --p_i45415_3_)
//    {
//        ;
//    }
//
//    int j1 = this.func_150853_a(p_i45415_2_, p_i45415_3_, p_i45415_4_, this.field_150863_d) - 1;
//
//    if (j1 >= 0)
//    {
//        this.field_150861_f = new ChunkCoordinates(p_i45415_2_ + j1 * Direction.offsetX[this.field_150863_d], p_i45415_3_, p_i45415_4_ + j1 * Direction.offsetZ[this.field_150863_d]);
//        this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY, this.field_150861_f.posZ, this.field_150866_c);
//
//        if (this.field_150868_h < 2 || this.field_150868_h > 21)
//        {
//            this.field_150861_f = null;
//            this.field_150868_h = 0;
//        }
//    }
//
//    if (this.field_150861_f != null)
//    {
//        this.field_150862_g = this.func_150858_a();
//    }
//}
//
// protected int func_150853_a(int p_150853_1_, int p_150853_2_, int p_150853_3_, int p_150853_4_)
//            {
//                int j1 = Direction.offsetX[p_150853_4_];
//                int k1 = Direction.offsetZ[p_150853_4_];
//                int i1;
//                Block block;
//
//                for (i1 = 0; i1 < 22; ++i1)
//                {
//                    block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);
//
//                    if (!this.func_150857_a(block))
//                    {
//                        break;
//                    }
//
//                    Block block1 = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_ - 1, p_150853_3_ + k1 * i1);
//
//                    if (block1 != Blocks.obsidian)
//                    {
//                        break;
//                    }
//                }
//
//                block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);
//                return block == Blocks.obsidian ? i1 : 0;
//            }
//}