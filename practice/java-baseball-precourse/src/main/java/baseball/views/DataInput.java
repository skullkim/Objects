package baseball.views;

import baseball.utils.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class DataInput {

	public String selectNumber() {
		GameMessage.printSelectNumber();
		return readLine();
	}

	public String selectGameCondition() {
		GameMessage.printSelectGameCondition();
		return readLine();
	}

	private String readLine() {
		return Console.readLine();
	}
}
