package baseball.utils;

import java.util.Arrays;

public enum GameCondition {
	RESTART_GAME(1),
	TERMINATE_GAME(2),
	INVALID_CONDITION(3);

	final int condition;

	GameCondition(int condition) {
		this.condition = condition;
	}

	public int getCondition() {
		return condition;
	}

	public static GameCondition getMatchedCondition(final int selectedCondition) {
		return Arrays.stream(GameCondition.values())
			.filter(condition -> condition.getCondition() == selectedCondition)
			.findAny()
			.orElse(GameCondition.INVALID_CONDITION);
	}

	public static boolean isValidGameCondition(GameCondition gameCondition) {
		return gameCondition == RESTART_GAME || gameCondition == TERMINATE_GAME;
	}
}
