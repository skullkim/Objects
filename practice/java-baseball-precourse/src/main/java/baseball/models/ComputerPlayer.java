package baseball.models;

import baseball.utils.RandomNumber;

public class ComputerPlayer implements Player {
	private int selectedNumber;
	private final RandomNumber randomNumber;

	public ComputerPlayer(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public void selectValidNumber() {
		selectedNumber = randomNumber.makeThreeDigitRandomNumber();
	}

	@Override
	public int getSelectedNumber() {
		return selectedNumber;
	}
}
