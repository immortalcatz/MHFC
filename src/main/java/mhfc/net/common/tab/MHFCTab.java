package mhfc.net.common.tab;

import mhfc.net.common.core.registry.MHFCRegItem;
import mhfc.net.common.util.lib.MHFCReference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MHFCTab extends CreativeTabs {

	public MHFCTab(int par1) {
		super(par1, MHFCReference.gui_tab_name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return (MHFCRegItem.mhfcitemhkirinspark);
	}

	@Override
	public String getTranslatedTabLabel() {
		return MHFCReference.gui_tab_name;
		// The main_name of the tab ingame
	}

}
