package mhfc.net.common.item.armor;

import mhfc.net.common.helper.ArmorMaterialHelper;
import mhfc.net.common.helper.ArmorModelHelper;
import mhfc.net.common.item.ItemRarity;
import mhfc.net.common.util.lib.MHFCReference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeviljhoArmor extends ItemArmorMHFC {
	private static final String[] names = { MHFCReference.armor_deviljho_helm_name,
			MHFCReference.armor_deviljho_chest_name, MHFCReference.armor_deviljho_legs_name,
			MHFCReference.armor_deviljho_boots_name };

	public DeviljhoArmor(EntityEquipmentSlot type) {
		super(
				ArmorMaterialHelper.ArmorBarroth,
				ItemRarity.R04,
				type,
				makeDefaultSlotToTex(MHFCReference.armor_deviljho_tex1, MHFCReference.armor_deviljho_tex2));
		setUnlocalizedName(names[3 - type.getIndex()]);
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected ModelBiped getBipedModel(EntityEquipmentSlot armorSlot) {
		return ArmorModelHelper.deviljho;
	}
}
