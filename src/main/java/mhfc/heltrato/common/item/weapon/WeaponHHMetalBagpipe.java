package mhfc.heltrato.common.item.weapon;

import java.util.List;

import mhfc.heltrato.common.entity.mob.EntityKirin;
import mhfc.heltrato.common.entity.mob.EntityTigrex;
import mhfc.heltrato.common.item.weapon.type.SiegeClass;
import mhfc.heltrato.common.util.Cooldown;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class WeaponHHMetalBagpipe extends SiegeClass {
	
	private float weaponDamage;
	private EntityLivingBase target;
	
	public static final int COOLDOWN = 2400; //200 - cooldown in ticks. 1 sec - 20 ticks.
	public WeaponHHMetalBagpipe(ToolMaterial getType) {
		super(getType);
		setUnlocalizedName("huntinghorn_1");
		
		weaponDamage = getType.getDamageVsEntity() - 4;
		
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
		par3List.add("\u00a79No Element");
		par3List.add("\u00a72Siege Damage");
		par3List.add("\u00a72Note Type: Supportive");
		Cooldown.displayCooldown(par1ItemStack, par3List, COOLDOWN); //display current cooldown
	}
	
	public void registerIcons(IIconRegister par1IconRegister){
		itemIcon = par1IconRegister.registerIcon("mhfc:huntinghorn");
    }
	
	public void onUpdate(ItemStack iStack, World world, Entity entity, int esotericInt, boolean agravaineBoolean){
		if(!world.isRemote){
                    Cooldown.onUpdate(iStack, COOLDOWN);
               }
	}

	public float getDamageVsEntity(Entity entity)
	{
	    	
	    	return weaponDamage;
	}

		
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase ent, EntityLivingBase player){
		player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 80, 1));
		{
		if(rand.nextInt(20) == 0)
		{
			player.addPotionEffect(new PotionEffect(Potion.resistance.id, 100, 1));
		}
		if(rand.nextInt(40) == 0){
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 60, 3));
		}
		float damage = 0.0f;
		if(ent instanceof EntityKirin){
			damage = 17;
		}
		if(ent instanceof EntityTigrex) {
				damage = 15f;
		}
			
		DamageSource dmgSource = DamageSource.causePlayerDamage((EntityPlayer) player);
		ent.attackEntityFrom(dmgSource, damage);
		}
		return true;
	}
		
	
	public ItemStack onItemRightClick(ItemStack iStack, World world, EntityPlayer player){
		
		if(Cooldown.canUse(iStack, COOLDOWN)){
				List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player.getLastAttacker(), player.boundingBox.expand(12D, 8D, 12D));
				for (int i = 0; i < list.size(); i++) {
					Entity entity = (Entity)list.get(i);
				    	((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.regeneration.id, 500, 1));
				    }
				    
				}
				//player.motionY++;
		return iStack;
	}
	
 }
	
