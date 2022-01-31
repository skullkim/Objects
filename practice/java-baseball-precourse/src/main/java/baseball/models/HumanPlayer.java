package baseball.models;

import baseball.utils.DataInputValidation;
import baseball.utils.GameCondition;
import baseball.views.DataInput;

public class HumanPlayer implements Player {
	private String selectedNumber;
	private final DataInputValidation validation;
	private final DataInput input;

	public HumanPlayer(DataInputValidation validation, DataInput input) {
		this.validation = validation;
		this.input = input;
	}

	@Override
	public void selectValidNumber() {
		final String selectedData = input.selectNumber();
		validation.isValidNumber(selectedData);
		selectedNumber = selectedData;
	}

	@Override
	public String getSelectedNumber() {
		return this.selectedNumber;
	}

	@Override
	public GameCondition selectGameCondition() {
		final String selectedCondition = input.selectGameCondition();
		return validation
			.isValidGameCondition(selectedCondition);
	}
}
