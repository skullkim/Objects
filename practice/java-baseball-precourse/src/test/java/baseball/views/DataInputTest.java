package baseball.views;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("DataInput 클래스")
class DataInputTest {

	DataInput dataInput = new DataInput();

	@DisplayName("입력한 데이터를 반환한다")
	@ParameterizedTest(name = "{index} {displayName} inputtedNumber={0}")
	@ValueSource(strings = {"123", "-456", "ad3"})
	void inputNumber(final String inputtedNumber) {
		inputDataToConsole(inputtedNumber);

		assertEquals(inputtedNumber, dataInput.selectNumber());
	}

	@DisplayName("입력된 게임 상태를 반환한다")
	@ParameterizedTest(name = "{index} {displayName} gameCondition={0}")
	@ValueSource(strings = {"1", "2", "a"})
	void selectGameCondition(final String gameCondition) {
		inputDataToConsole(gameCondition);

		assertEquals(gameCondition, dataInput.selectGameCondition());
	}

	private void inputDataToConsole(final String data) {
		InputStream input = new ByteArrayInputStream(data.getBytes());
		System.setIn(input);
	}
}