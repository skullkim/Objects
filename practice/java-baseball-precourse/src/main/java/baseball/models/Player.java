package baseball.models;

import baseball.utils.GameCondition;

public interface Player {
	void selectValidNumber();
	int getSelectedNumber();
	default GameCondition selectGameCondition(){
		return GameCondition.INVALID_CONDITION;
	}
}
