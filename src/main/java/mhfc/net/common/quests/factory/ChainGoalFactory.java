package mhfc.net.common.quests.factory;

import static mhfc.net.common.quests.descriptions.ChainGoalDescription.*;

import com.google.gson.*;

import mhfc.net.common.quests.api.GoalDescription;
import mhfc.net.common.quests.api.GoalReference;
import mhfc.net.common.quests.api.IGoalFactory;
import mhfc.net.common.quests.descriptions.ChainGoalDescription;

public class ChainGoalFactory implements IGoalFactory {
	@Override
	public GoalDescription buildGoalDescription(JsonObject json,
		JsonDeserializationContext context) {
		if (!json.has(ID_GOAL))
			throw new JsonParseException("A chain goal requires field "
				+ ID_GOAL);
		GoalReference goal, successor;
		goal = GoalReference.constructFromJson(json.get(ID_GOAL), context);
		successor = GoalReference.constructFromJson(json.get(ID_SUCCESSOR),
			context);
		return new ChainGoalDescription(goal, successor);
	}

	@Override
	public JsonObject serialize(GoalDescription description,
		JsonSerializationContext context) {
		ChainGoalDescription chainGoal = (ChainGoalDescription) description;
		JsonObject jsonObject = new JsonObject();
		JsonElement jsonGoal = context.serialize(chainGoal.getTrueGoal(),
			GoalReference.class);
		JsonElement jsonSuccessor = context.serialize(chainGoal
			.getSuccessorGoal(), GoalReference.class);
		jsonObject.add(ID_GOAL, jsonGoal);
		jsonObject.add(ID_SUCCESSOR, jsonSuccessor);
		return jsonObject;
	}

}
