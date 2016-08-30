package mhfc.net.common.weapon;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.Multimap;

import mhfc.net.MHFCMain;
import mhfc.net.common.system.ColorSystem;
import mhfc.net.common.util.NBTUtils;
import mhfc.net.common.weapon.stats.CombatEffect;
import mhfc.net.common.weapon.stats.WeaponStats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Our own version of {@link ItemSword} but without the destruction of strings for example.
 *
 * @author WorldSEnder
 *
 */
public abstract class ItemWeapon<W extends WeaponStats> extends Item {
	protected static final String COOLDOWN_NBT = "mhfc:cooldown";

	protected final W stats;

	public ItemWeapon(W stats) {
		this.stats = Objects.requireNonNull(stats);
		setFull3D();
		setCreativeTab(MHFCMain.mhfctabs);
		setUnlocalizedName(stats.getUnlocalizedName());
		setMaxStackSize(1);
	}

	protected boolean isOffCooldown(ItemStack stack) {
		return NBTUtils.getNBTChecked(stack).getInteger(COOLDOWN_NBT) == 0;
	}

	protected void triggerCooldown(ItemStack stack) {
		NBTUtils.getNBTChecked(stack).setInteger(COOLDOWN_NBT, stats.getCooldownTicks());
	}

	protected void decreaseCooldown(ItemStack stack) {
		NBTUtils.decreaseIntUnsigned(NBTUtils.getNBTChecked(stack), COOLDOWN_NBT);
	}

	/**
	 * Call this addInformation() in your Item
	 *
	 * @param iStack
	 *            stack to update
	 * @param info
	 *            cooldown text
	 */
	@SideOnly(Side.CLIENT)
	protected void addCooldownToInformation(ItemStack iStack, List<String> info) {
		int cooldown = NBTUtils.getNBTChecked(iStack).getInteger(COOLDOWN_NBT);
		info.add(cooldown > 0 ? "Cooldown Time: " + cooldown : "Cooldown Time: Ready to Use");
	}

	@SideOnly(Side.CLIENT)
	protected static void displayAttackDelay(ItemStack iStack, List<String> info) {
		int cooldown = NBTUtils.getNBTChecked(iStack).getInteger(COOLDOWN_NBT);
		info.add(cooldown > 0 ? "Attack Time: " + cooldown : "Attack Time: Ready");
	}

	public abstract String getWeaponClassUnlocalized();

	@Override
	public void addInformation(ItemStack stack, EntityPlayer holder, List<String> infos, boolean advanced) {
		infos.add(ColorSystem.gold + I18n.format(getWeaponClassUnlocalized() + ".name"));
		infos.add(ColorSystem.yellow + "Rarity: " + stats.getRarity().toString());
		for (CombatEffect effect : stats.getCombatEffects()) {
			String formattedAmount = String.format("%+.0f", effect.getAmount());
			infos.add(
					ColorSystem.light_purple + formattedAmount + " "
							+ I18n.format(effect.getType().getUnlocalizedName() + ".name"));
		}
		if (!advanced) {
			return;
		}
		addCooldownToInformation(stack, infos);
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity holder, int slot, boolean isHoldItem) {
		decreaseCooldown(stack);
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		for (CombatEffect effect : stats.getCombatEffects()) {
			effect.getType().onEntitySwing(entityLiving, stack, itemRand);
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}

	public W getWeaponStats() {
		return stats;
	}

	@Override
	public int getItemEnchantability() {
		return 0;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);
		multimap.put(
				SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(),
				new AttributeModifier(Item.ATTACK_DAMAGE_MODIFIER, "Weapon Attack", stats.getAttack(), 0));
		return multimap;
	}
}
