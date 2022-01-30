package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("DataInputValidation 클래스")
class DataInputValidationTest {
	DataInputValidation validation = new DataInputValidation();

	@Nested
	@DisplayName("사용자가 입력한 숫자가")
	class GuessNumber {
		@DisplayName("올바른 형식의 데이터이면 true를 반환")
		@ParameterizedTest(name = "{displayName} validData={0}")
		@ValueSource(strings = {"111", "234"})
		void validInput(final String validData) {
			final boolean result = validation.isValidNumber(validData);
			assertTrue(result);
		}

		@DisplayName("길이가 3이 아니면 IllegalArgumentException을 던진다")
		@ParameterizedTest(name = "{displayName} invalidLengthData={0}")
		@ValueSource(strings = {"1", "12", "1234"})
		void invalidDataLength(final String invalidLengthData) {
			IllegalArgumentException invalidLength = assertThrows(IllegalArgumentException.class,
				() -> validation.isValidNumber(invalidLengthData));
			final String expectedMessage = invalidLengthData + ", 입력한 숫자가 3자리 숫자가 아닙니다";
			assertEquals(expectedMessage, invalidLength.getMessage());
		}

		@DisplayName("1~9사이의 수가 아닌 다른 문자가 포함되 있으면 IllegalArguemntException을 던진다")
		@ParameterizedTest(name = "{displayName} invalidLengthData={0}")
		@ValueSource(strings = {"-123", "ab3", "1d5"})
		void involvesNotNumberCharacter(final String invalidLengthData) {
			IllegalArgumentException invalidLength = assertThrows(IllegalArgumentException.class,
				() -> validation.isValidNumber(invalidLengthData));
			final String expectedMessage = invalidLengthData + ", 숫자만 입력해야 합니다";
			assertEquals(expectedMessage, invalidLength.getMessage());
		}

	}
}