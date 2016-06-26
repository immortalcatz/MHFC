package mhfc.net.common.entity.monster;

import mhfc.net.common.ai.AIStancedActionManager;
import mhfc.net.common.ai.IExecutableAction;
import mhfc.net.common.ai.IStancedActionManager;
import mhfc.net.common.ai.IStancedManagedActions;
import mhfc.net.common.ai.entity.rathalos.BiteAttack;
import mhfc.net.common.ai.entity.rathalos.ChargeAttack;
import mhfc.net.common.ai.entity.rathalos.FireballAttack;
import mhfc.net.common.ai.entity.rathalos.FlyLand;
import mhfc.net.common.ai.entity.rathalos.FlyStart;
import mhfc.net.common.ai.entity.rathalos.JumpFireball;
import mhfc.net.common.ai.entity.rathalos.TailSpin;
import mhfc.net.common.entity.type.EntityMHFCBase;
import mhfc.net.common.entity.type.EntityMHFCPart;
import mhfc.net.common.entity.type.IConfusable;
import mhfc.net.common.item.materials.ItemDeviljho.DeviljhoSubType;
import mhfc.net.common.item.materials.ItemRathalos.RathalosSubType;
import mhfc.net.common.util.SubTypedItem;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityRathalos extends EntityMHFCBase<EntityRathalos>
	implements
		IStancedManagedActions<EntityRathalos, EntityRathalos.Stances>,
		IConfusable {

	public static enum Stances
		implements
			IStancedActionManager.Stance<EntityRathalos, Stances> {
		GROUND,
		FLYING,
		FALLING,
		BLINDED {
			@Override
			public void onAttackStart(
				IExecutableAction<? super EntityRathalos> attack,
				EntityRathalos entity) {
				entity.confusedAttacks++;
			}

			@Override
			public void onAttackEnd(
				IExecutableAction<? super EntityRathalos> attack,
				EntityRathalos entity) {
				if (entity.getNumberOfConfusedAttacks() == 3) {
					entity.getAttackManager().setNextStance(GROUND);
				}
			}
		};

		@Override
		public void onAttackEnd(
			IExecutableAction<? super EntityRathalos> attack,
			EntityRathalos entity) {
		}

		@Override
		public void onAttackStart(
			IExecutableAction<? super EntityRathalos> attack,
			EntityRathalos entity) {
		}

		@Override
		public void onStanceStart() {
		}

		@Override
		public void onStanceEnd() {
		}

	}

	private final AIStancedActionManager<EntityRathalos, Stances> stancedAttackManager;
	private int confusedAttacks;

	public EntityRathalos(World world) {
		super(world);
		AIStancedActionManager<EntityRathalos, Stances> stancedAttackManager = new AIStancedActionManager<EntityRathalos, Stances>(
			this, Stances.GROUND);
		stancedAttackManager.registerAttack(new BiteAttack());
		stancedAttackManager.registerAttack(new ChargeAttack());
		stancedAttackManager.registerAttack(new FireballAttack());
		stancedAttackManager.registerAttack(new FlyStart());
		stancedAttackManager.registerAttack(new JumpFireball());
		stancedAttackManager.registerAttack(new TailSpin());
		stancedAttackManager.registerAttack(new FlyLand());
		setAIActionManager(stancedAttackManager);
		this.stancedAttackManager = stancedAttackManager;
	}

	@Override
	protected void applyEntityAttributes() {

		super.applyEntityAttributes();

		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
			healthbaseHP(4500D, 9000D, 18000D));

	}

	@Override
	public EntityMHFCPart[] getParts() {
		return null;
	}

	@Override
	public AIStancedActionManager<EntityRathalos, Stances> getAttackManager() {
		return stancedAttackManager;
	}

	@Override
	public void confuse() {
		confusedAttacks = 0;
		stancedAttackManager.setNextStance(Stances.BLINDED);
	}

	@Override
	public int getNumberOfConfusedAttacks() {
		return confusedAttacks;
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		//
	}

	/**
	 * FIXME This should disable falling during flying but it also makes
	 * collision weird I don't know if it disables AI movement as well
	 */
	@Override
	protected void updateFallState(double par1, boolean par3) {

		if (stancedAttackManager.getCurrentStance() == Stances.FLYING) {
			this.motionY = 0;
			this.fallDistance = 0;
			par1 = 0;
		}

		super.updateFallState(par1, par3);
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
		int var4;
		for (var4 = 0; var4 < 13; ++var4) {
			dropItemRand(SubTypedItem.fromSubItem(RathalosSubType.SHELL, 1));
		}
		for (var4 = 0; var4 < 8; ++var4) {
			dropItemRand(SubTypedItem.fromSubItem(RathalosSubType.WEBBING, 1));
			dropItemRand(SubTypedItem.fromSubItem(RathalosSubType.MARROW, 1));
			
		}
		for (var4 = 0; var4 < 1; ++var4) {
			dropItemRand(SubTypedItem.fromSubItem(RathalosSubType.WING, 1));
			
		}
		dropItemRand(SubTypedItem.fromSubItem(RathalosSubType.PLATE, 1));
	}
}
