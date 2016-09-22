package mhfc.net.common.item.materials;

import mhfc.net.MHFCMain;
import mhfc.net.common.core.registry.MHFCItemRegistry;
import mhfc.net.common.index.ResourceInterface;
import mhfc.net.common.item.AbstractSubTypedItem;
import mhfc.net.common.item.ItemColor;
import mhfc.net.common.item.materials.ItemIngot.IngotsSubType;
import mhfc.net.common.util.SubTypedItem;
import net.minecraft.item.Item;

public class ItemIngot extends AbstractSubTypedItem<IngotsSubType> {
	public static enum IngotsSubType implements SubTypedItem.SubTypeEnum<Item> {
		CARBALITE(ResourceInterface.item_ingot0_name, ItemColor.PURPLE),
		DRAGONITE(ResourceInterface.item_ingot1_name, ItemColor.GREEN),
		ELTALITE(ResourceInterface.item_ingot2_name, ItemColor.RED),
		MACHALITE(ResourceInterface.item_ingot3_name, ItemColor.CYAN);

		public final String name;
		public final ItemColor color;

		private IngotsSubType(String name, ItemColor color) {
			this.name = name;
			this.color = color;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public Item getBaseItem() {
			return MHFCItemRegistry.getRegistry().ingot;
		}

		@Override
		public ItemColor getColor() {
			return color;
		}
	}

	public ItemIngot() {
		super(IngotsSubType.class);
		setUnlocalizedName(ResourceInterface.item_ingot_basename);
		setCreativeTab(MHFCMain.mhfctabs);
	}

}
