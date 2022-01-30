package baseball.utils;

import java.util.regex.Pattern;

public class DataInputValidation {
	private static final String NUMBER_PATTERN = "^[1-9]*$";

	private static final int PROPER_NUMBER_LENGTH = 3;

	public boolean isValidNumber(final String selectedData) {
		if (!Pattern.matches(NUMBER_PATTERN, selectedData)) {
			throw new IllegalArgumentException(
				GameMessage.getInputInvolvesCharacterError(selectedData));
		}
		if(selectedData.length() != PROPER_NUMBER_LENGTH) {
			throw new IllegalArgumentException(
				GameMessage.getNumberLengthError(selectedData));
		}
		return true;
	}
}
