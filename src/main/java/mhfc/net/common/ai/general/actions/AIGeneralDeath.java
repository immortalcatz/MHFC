package mhfc.net.common.ai.general.actions;

import mhfc.net.common.ai.ActionAdapter;
import mhfc.net.common.entity.type.EntityMHFCBase;

public abstract class AIGeneralDeath<EntityT extends EntityMHFCBase<? super EntityT>> extends ActionAdapter<EntityT> {

	public static final int deathLingeringTicks = 30 * 30;
	protected String deathsoundlocation;

	public AIGeneralDeath(String dyingLocation) {
		setAnimation(dyingLocation);
	}

	@Override
	public void beginExecution() {
		super.beginExecution();
	}

	@Override
	protected void update() {}

	@Override
	public boolean shouldContinue() {
		return true; // Indefinitely, we are dead
	}

	@Override
	public boolean forceSelection() {
		EntityT entity = getEntity();
		return entity == null ? false : entity.isDead;
	}

	@Override
	public float getWeight() {
		return 0; // but is being forced ya know
	}
}
