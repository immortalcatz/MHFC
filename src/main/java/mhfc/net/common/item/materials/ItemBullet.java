package mhfc.net.common.item.materials;

import java.util.List;

import mhfc.net.MHFCMain;
import mhfc.net.common.core.registry.MHFCItemRegistry;
import mhfc.net.common.index.ResourceInterface;
import mhfc.net.common.item.AbstractSubTypedItem;
import mhfc.net.common.item.ItemColor;
import mhfc.net.common.item.materials.ItemBullet.BulletSubType;
import mhfc.net.common.util.SubTypedItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBullet extends AbstractSubTypedItem<BulletSubType> {
	public static enum BulletSubType implements SubTypedItem.SubTypeEnum<Item> {
		NORMALS("normalS", ResourceInterface.item_bulletnormal_name, ItemColor.WHITE), //
		PIERCES("piercingS", ResourceInterface.item_bulletpierce_name, ItemColor.WHITE), //
		CRAGS("cragS", ResourceInterface.item_bulletcrag_name, ItemColor.WHITE), //
		FLAMES("flamingS", ResourceInterface.item_bulletflame_name, ItemColor.RED); //

		public final String registryName;
		public final String name;
		public final ItemColor color;

		private BulletSubType(String registryName, String name, ItemColor color) {
			this.registryName = registryName;
			this.name = name;
			this.color = color;
		}

		@Override
		public String getName() {
			return this.registryName;
		}

		@Override
		public String getUnlocalizedName() {
			return name;
		}

		@Override
		public Item getBaseItem() {
			return MHFCItemRegistry.getRegistry().bowgunBullet;
		}

		@Override
		public ItemColor getColor() {
			return color;
		}
	}

	public ItemBullet() {
		super(BulletSubType.class);
		setUnlocalizedName(ResourceInterface.item_bullet_basename);
		setCreativeTab(MHFCMain.mhfctabs);
	}

	@Override
	public void addInformation(
			ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer,
			List<String> par3List,
			boolean par4) {
		switch (itemPerk.getSubType(par1ItemStack)) {
		case FLAMES:
			par3List.add("Bullet use for Bowguns");
			par3List.add("Deals fire damage to monsters");
			break;
		case CRAGS:
		case NORMALS:
		case PIERCES:
		default:
			par3List.add("Bullet use for Bowguns");
			break;
		}
	}
}
