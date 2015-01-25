package mhfc.heltrato.common.item.weapon.huntinghorn;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import mhfc.heltrato.common.item.weapon.WeaponClass;
import mhfc.heltrato.common.item.weapon.WeaponMelee;
import mhfc.heltrato.common.item.weapon.WeaponMelee.WeaponSpecs;
import mhfc.heltrato.common.util.Cooldown;

public class HuntingHornClass extends WeaponClass {
	
	public String hhlocal = "huntinghorn_";
	public int cooldown;

	public HuntingHornClass(ToolMaterial getType, int Cooldown) {
		super(new WeaponMelee(WeaponSpecs.HUNTINGHORN, getType));
		getWeaponDescription(clazz.huntinghornname);
		getWeaponTextureloc(ref.weapon_hh_default_icon);
		getWeaponTable(-6,8,1);
		cooldown = Cooldown;
	}
	
	@Override
	public void onUpdate(ItemStack iStack, World world, Entity entity,
			int i, boolean flag) {
		if (!world.isRemote) {
			Cooldown.onUpdate(iStack, cooldown);
		}
		weapon.onUpdate(iStack, world, entity, i, flag);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target , EntityLivingBase player) {
		if(poisontype) target.addPotionEffect(new PotionEffect(Potion.poison.id, 10, amplified));
		if(firetype)  target.setFire(1);
		weapon.hitEntity(stack, target, player);
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack iStack, World world,
			EntityPlayer player) {
		weapon.onItemRightClick(iStack, world, player);
		if (Cooldown.canUse(iStack, cooldown)) {
			@SuppressWarnings("unchecked")
			List<Entity> list = player.worldObj	.getEntitiesWithinAABBExcludingEntity(player.getLastAttacker(),	player.boundingBox.expand(12D, 8D, 12D));
			for (Entity entity : list) {
				if (entity instanceof EntityLivingBase)
					((EntityLivingBase) entity)
							.addPotionEffect(new PotionEffect(
									Potion.damageBoost.id, 300, 1));
			}

		}
		// player.motionY++;
		return iStack;
	}

}
