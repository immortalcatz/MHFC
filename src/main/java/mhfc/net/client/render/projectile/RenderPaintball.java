package mhfc.net.client.render.projectile;

import mhfc.net.common.core.registry.MHFCItemRegistry;
import mhfc.net.common.entity.projectile.EntityPaintball;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class RenderPaintball extends RenderSnowball<EntityPaintball> {

	public RenderPaintball(RenderManager manager, RenderItem itemRender) {
		super(manager, MHFCItemRegistry.getRegistry().paintball, itemRender);
	}

}
