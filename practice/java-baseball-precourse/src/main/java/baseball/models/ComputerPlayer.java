package baseball.models;

import baseball.utils.RandomNumber;

public class ComputerPlayer implements Player {
	private String selectedNumber;
	private final RandomNumber randomNumber;

	public ComputerPlayer(RandomNumber randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public void selectValidNumber() {
		selectedNumber = Integer.toString(randomNumber
			.makeThreeDigitRandomNumber());
	}

	@Override
	public String getSelectedNumber() {
		return selectedNumber;
	}
}
