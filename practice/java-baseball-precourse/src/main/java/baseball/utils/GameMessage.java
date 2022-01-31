package baseball.utils;

public class GameMessage {

	private static final String NumberSelection = "숫자를 입력해주세요 : ";

	private static final String gameConditionSelection = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private static final String NOT_THREE_DIGIT_NUMBER = ", 입력한 숫자가 3자리 숫자가 아닙니다";

	private static final String INPUT_INVOLVES_CHARACTER = ", 숫자만 입력해야 합니다";

	private static final String INVALID_GAME_CONDITION = ", 게임 컨디션은 1(새로 시작) 또는 2(종료)여야 합니다";

	public static void printSelectNumber() {
		System.out.print(NumberSelection);
	}

	public static void printSelectGameCondition() {
		System.out.println(gameConditionSelection);
	}

	public static String getNumberLengthError(final String inputtedData) {
		return inputtedData + NOT_THREE_DIGIT_NUMBER;
	}

	public static String getInputInvolvesCharacterError(final String inputtedData) {
		return inputtedData + INPUT_INVOLVES_CHARACTER;
	}

	public static String getInvalidGameConditionError(final String invalidGameCondition) {
		return invalidGameCondition + INVALID_GAME_CONDITION;
	}
}
