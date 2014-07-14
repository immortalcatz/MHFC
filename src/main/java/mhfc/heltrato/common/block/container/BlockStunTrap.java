package mhfc.heltrato.common.block.container;

import java.util.Random;

import mhfc.heltrato.MHFCMain;
import mhfc.heltrato.common.core.registry.MHFCRegPotion;
import mhfc.heltrato.common.item.block.ItemBlockWyverniaDefault;
import mhfc.heltrato.common.tile.TileStunTrap;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStunTrap extends BlockContainer{
	
	private ItemBlockWyverniaDefault block;
	private TileStunTrap trap;
	public BlockStunTrap() {
		super(Material.rock);
		setBlockBounds(1F/16F*5F, 0, 1F/16F*5F, 1F-1F/16F*5F, 1F-1F/16F*12F, 1F-1F/16F*5F);
		setBlockName("trapstun");
		setHardness(0.8F);
		disableStats();
		setCreativeTab(MHFCMain.mhfctabs);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		float f1 = (float)x + 0.5F;
		float f2 = (float)y + 1.1F;
		float f3 = (float)z + 0.5F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;
		float f5 = random.nextFloat() * -0.6F - -0.3F;
		world.spawnParticle("largesmoke", (double)(f1 + f4),(double) f2, (double)f3+f5, 0D, 0D, 0D);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        return null;
    }

	public TileEntity createNewTileEntity(World world, int var1) {
		return new TileStunTrap();
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
    	int metadata = par1World.getBlockMetadata(par2, par3, par4);
		if(metadata == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
	    	return true;
		}
    	return false;
    }
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        boolean flag = false;

        if (!par1World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && !BlockFence.func_149825_a(par1World.getBlock(par2, par3 - 1, par4)))
        {
            flag = true;
        }
        
        

        if (flag)
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlockToAir(par2, par3, par4);
        }
    }
	
	public int getRenderType(){
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}

	public void registerBlockIcons(IIconRegister par1IconRegister){
		blockIcon = par1IconRegister.registerIcon("mhfc:trapstun");
	}
	
	public boolean renderAsNormalBlock() {
        return false;
	}
	
	
	@Override
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity) {
        if ((entity instanceof EntityPlayer) || !(entity instanceof EntityLiving)) {
            return;
        }
        
        world.setBlockToAir(i, j, k);
        EntityLivingBase entityliving = (EntityLivingBase)entity;
        world.setBlockMetadataWithNotify(i, j, k, 1, 3);
        TileStunTrap tileentitystuntrap = (TileStunTrap)world.getTileEntity(i, j, k);
      entityliving.addPotionEffect(new PotionEffect(MHFCRegPotion.mhfcpotionshock.id, 500, 10));
        return;
            
        }
	
}
