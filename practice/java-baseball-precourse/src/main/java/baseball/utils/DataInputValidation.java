package baseball.utils;

import java.util.regex.Pattern;

public class DataInputValidation {
	private static final String NUMBER_PATTERN = "^[1-9]*$";

	private static final int PROPER_NUMBER_LENGTH = 3;

	public boolean isValidNumber(final String selectedData) {
		doesDataContainCharacter(selectedData);
		if(selectedData.length() != PROPER_NUMBER_LENGTH) {
			throw new IllegalArgumentException(
				GameMessage.getNumberLengthError(selectedData));
		}
		return true;
	}

	public GameCondition isValidGameCondition(final String selectedGameCondition) {
		doesDataContainCharacter(selectedGameCondition);
		final GameCondition gameCondition = GameCondition.getMatchedCondition(
			Integer.parseInt(selectedGameCondition));
		if (!GameCondition.isValidGameCondition(gameCondition)) {
			throw new IllegalArgumentException(
				GameMessage.getInvalidGameConditionError(selectedGameCondition));
		}
		return gameCondition;
	}

	private void doesDataContainCharacter(final String selectedData) {
		if (!Pattern.matches(NUMBER_PATTERN, selectedData)) {
			throw new IllegalArgumentException(
				GameMessage.getInputInvolvesCharacterError(selectedData));
		}
	}
}
