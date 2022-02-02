package baseball.controllers;

import baseball.models.Player;
import baseball.utils.GameCondition;
import baseball.utils.GameMessage;
import baseball.views.DataOutput;

public class NumberBaseballGame {
	private static final String CORRECT_ANSWER = "3스트라이크";
	private final Player human;
	private final Player computer;
	private final DataOutput output;

	public NumberBaseballGame(Player human, Player computer, DataOutput output) {
		this.human = human;
		this.computer = computer;
		this.output = output;
	}

	public void startGame() {
		GameCondition gameCondition;
		computer.selectValidNumber();
		while (true) {
			human.selectValidNumber();
			final String result = makeResult();
			output.printResult(result);
			if(result.equals(CORRECT_ANSWER)) {
				gameCondition = human.selectGameCondition();
				break;
			}
		}
		if (gameCondition == GameCondition.RESTART_GAME) {
			startGame();
		}
	}

	private String makeResult() {
		final int balls = countBall(human.getSelectedNumber(),
			computer.getSelectedNumber());
		final int strikes = countStrike(human.getSelectedNumber(),
			computer.getSelectedNumber());
		return makeOutputString(balls, strikes);
	}

	private int countBall(final String humanSelectedNumber,
			final String computerSelectedNumber) {
		int balls = 0;
		for (int i = 0; i < humanSelectedNumber.length(); i++) {
			final char numberElement = humanSelectedNumber.charAt(i);
			final int indexOfNumberElement = computerSelectedNumber.indexOf(numberElement);
			if (indexOfNumberElement >= 0 && indexOfNumberElement != i) {
				balls++;
			}
		}
		return balls;
	}

	private int countStrike(final String humanSelectedNumber,
			final String computerSelectedNumber) {
		int strikes = 0;
		for (int i = 0; i < humanSelectedNumber.length(); i++) {
			final char numberElement = humanSelectedNumber.charAt(i);
			final int indexOfNumberElement = computerSelectedNumber.indexOf(numberElement);
			if (indexOfNumberElement >= 0 && indexOfNumberElement == i) {
				strikes++;
			}
		}

		return strikes;
	}

	private String makeOutputString(final int balls, final int strikes) {
		String result = GameMessage.getBallsResult(balls) +
			GameMessage.getStrikesResult(strikes, balls);
		if (result.isEmpty()) {
			return GameMessage.getNoMatchedNumber();
		}
		return result;
	}
}
