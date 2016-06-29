package mhfc.net.client.render.weapon.hammer;

import org.lwjgl.opengl.GL11;

import mhfc.net.client.model.weapon.hammer.ModelHKirinSpark;
import mhfc.net.client.render.weapon.RenderMelee;
import mhfc.net.common.util.lib.MHFCReference;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;

public class RenderHKirinSpark extends RenderMelee<ModelHKirinSpark> {

	public RenderHKirinSpark() {
		super(new ModelHKirinSpark(), MHFCReference.weapon_hm_kirin_tex, 1.5f);
	}

	@Override
	public void preEquipped(RenderBlocks render, EntityLivingBase entityLiving) {
		super.preEquipped(render, entityLiving);
		GL11.glTranslatef(0.45F, -0.65F, -0.1F);
	}

	@Override
	public void preFirstPerson(RenderBlocks render, EntityLivingBase entityLiving) {
		super.preFirstPerson(render, entityLiving);
		GL11.glTranslatef(0.35F, -0.45F, -0.1F);
	}

	@Override
	public void preEntityItem(RenderBlocks render, EntityItem entityItem) {
		super.preEntityItem(render, entityItem);
		GL11.glTranslatef(0, -0.1F, 0F);
	}

	@Override
	public void preInventory(RenderBlocks render) {
		super.preInventory(render);
		GL11.glTranslatef(0, -0.5F, -0.1F);
	}

}
