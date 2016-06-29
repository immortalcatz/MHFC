package mhfc.net.client.render.weapon.longsword;

import org.lwjgl.opengl.GL11;

import mhfc.net.client.model.weapon.longsword.ModelLSIKGrace;
import mhfc.net.client.render.weapon.RenderMelee;
import mhfc.net.common.util.lib.MHFCReference;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.EntityLivingBase;

public class RenderLSIKGrace extends RenderMelee<ModelLSIKGrace> {

	public RenderLSIKGrace() {
		super(new ModelLSIKGrace(), MHFCReference.weapon_ls_ikgrace_tex, 1.3f);
	}

	@Override
	public void preEquipped(RenderBlocks render, EntityLivingBase entityLiving) {
		super.preEquipped(render, entityLiving);
		GL11.glTranslatef(0.45F, -0.65F, 0.0F);
	}

	@Override
	public void preFirstPerson(RenderBlocks render, EntityLivingBase entityLiving) {
		super.preFirstPerson(render, entityLiving);
		GL11.glTranslatef(0.35F, -0.45F, 0.0F);
	}

	@Override
	public void preInventory(RenderBlocks render) {
		super.preInventory(render);
		GL11.glTranslatef(0, -0.5F, -0.1F);
	}

}
