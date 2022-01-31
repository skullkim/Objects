package baseball.models;

import baseball.utils.GameCondition;

public interface Player {
	void selectValidNumber();
	String getSelectedNumber();
	default GameCondition selectGameCondition(){
		return GameCondition.INVALID_CONDITION;
	}
}
