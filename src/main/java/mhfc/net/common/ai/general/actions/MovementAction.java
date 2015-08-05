package mhfc.net.common.ai.general.actions;

import java.util.Objects;

import mhfc.net.common.ai.ActionAdapter;
import mhfc.net.common.ai.IExecutableAction;
import mhfc.net.common.ai.general.provider.*;
import mhfc.net.common.entity.type.EntityMHFCBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class MovementAction<EntityT extends EntityMHFCBase<? super EntityT>>
	extends
		ActionAdapter<EntityT> {

	public static interface MovementActionProvider<EntityT extends EntityMHFCBase<? super EntityT>>
		extends
			IAnimationProvider,
			ISelectionPredicate<EntityT>,
			IContinuationPredicate<EntityT>,
			IWeightProvider<EntityT>,
			IMovementProvider<EntityT> {
	}

	protected MovementActionProvider<EntityT> movementProvider;

	public MovementAction(MovementActionProvider<EntityT> movementActionProvider) {
		this.movementProvider = Objects.requireNonNull(movementActionProvider);
	}

	@Override
	protected void beginExecution() {
		super.beginExecution();
		movementProvider.initialize(getEntity());
	}

	@Override
	protected void update() {
		EntityT actor = getEntity();
		if (movementProvider.hasWaypointReached()) {
			movementProvider.onWaypointReached();
		} else {
			Vec3 checkPoint = movementProvider.getCurrentWaypoint();
			actor.getTurnHelper().updateTurnSpeed(
				movementProvider.getTurnRate());
			actor.getTurnHelper().updateTargetPoint(checkPoint);
			actor.moveForward(movementProvider.getMoveSpeed());
		}
	}

	@Override
	public float getWeight() {
		return movementProvider.getWeight(getEntity(), getEntity()
			.getAITarget());
	}

	@Override
	public boolean shouldContinue() {
		return movementProvider.shouldContinueAction(this, getEntity());
	}

	public static class MovementActionAdapter<EntityT extends EntityMHFCBase<? super EntityT>>
		implements
			MovementActionProvider<EntityT> {
		private IAnimationProvider animationProvider;
		private ISelectionPredicate<EntityT> selectionPredicate;
		private IContinuationPredicate<EntityT> continuationPredicate;
		private IWeightProvider<EntityT> weightProvider;
		private IMovementProvider<EntityT> movementProvider;

		public MovementActionAdapter(IAnimationProvider animationProvider,
			ISelectionPredicate<EntityT> selectionPredicate,
			IContinuationPredicate<EntityT> continuationPredicate,
			IWeightProvider<EntityT> weightProvider,
			IMovementProvider<EntityT> movementProvider) {
			this.animationProvider = Objects.requireNonNull(animationProvider);
			this.selectionPredicate = Objects
				.requireNonNull(selectionPredicate);
			this.continuationPredicate = Objects
				.requireNonNull(continuationPredicate);
			this.weightProvider = Objects.requireNonNull(weightProvider);
			this.movementProvider = Objects.requireNonNull(movementProvider);
		}

		@Override
		public String getAnimationLocation() {
			return animationProvider.getAnimationLocation();
		}

		@Override
		public int getAnimationLength() {
			return animationProvider.getAnimationLength();
		}

		@Override
		public boolean shouldSelectAttack(IExecutableAction<EntityT> attack,
			EntityT actor, Entity target) {
			return selectionPredicate.shouldSelectAttack(attack, actor, target);
		}

		@Override
		public boolean shouldContinueAction(IExecutableAction<EntityT> attack,
			EntityT actor) {
			return continuationPredicate.shouldContinueAction(attack, actor);
		}

		@Override
		public float getWeight(EntityT entity, Entity target) {
			return weightProvider.getWeight(entity, target);
		}

		@Override
		public float getTurnRate() {
			return movementProvider.getTurnRate();
		}

		@Override
		public float getMoveSpeed() {
			return movementProvider.getMoveSpeed();
		}

		@Override
		public void initialize(EntityT actor) {
			movementProvider.initialize(actor);
		}

		@Override
		public Vec3 getCurrentWaypoint() {
			return movementProvider.getCurrentWaypoint();
		}

		@Override
		public boolean hasWaypointReached() {
			return movementProvider.hasWaypointReached();
		}

		@Override
		public void onWaypointReached() {
			movementProvider.onWaypointReached();
		}

	}

}
