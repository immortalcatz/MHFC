package mhfc.net.client.render.weapon.huntinghorn;

import org.lwjgl.opengl.GL11;

import mhfc.net.client.model.weapon.huntinghorn.ModelHHDarkThornTrumpet;
import mhfc.net.common.util.lib.MHFCReference;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.EntityLivingBase;

public class RenderHHDarkThornTrumpet extends RenderHuntingHorn<ModelHHDarkThornTrumpet> {

	public RenderHHDarkThornTrumpet() {
		super(new ModelHHDarkThornTrumpet(), MHFCReference.weapon_hh_darkthorntrumpet_tex, 1.7f);
	}

	@Override
	public void preEquipped(RenderBlocks render, EntityLivingBase entityLiving) {
		super.preEquipped(render, entityLiving);
		GL11.glTranslatef(0.4F, -0.62F, -0.05F);
	}

	@Override
	public void preFirstPerson(RenderBlocks render, EntityLivingBase entityLiving) {
		super.preFirstPerson(render, entityLiving);
		GL11.glTranslatef(0.3F, -0.4F, -0.1F);
	}

	@Override
	public void preInventory(RenderBlocks render) {
		super.preInventory(render);
		GL11.glTranslatef(0F, -0.3F, -0.0F);
	}

}
