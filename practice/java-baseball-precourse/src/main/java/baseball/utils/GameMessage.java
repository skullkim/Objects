package baseball.utils;

public class GameMessage {

	private static final String NumberSelection = "숫자를 입력해주세요 : ";

	private static final String gameConditionSelection = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public static void printSelectNumber() {
		System.out.print(NumberSelection);
	}

	public static void printSelectGameCondition() {
		System.out.println(gameConditionSelection);
	}
}
