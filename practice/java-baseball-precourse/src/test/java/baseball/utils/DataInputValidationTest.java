package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.GenericArrayType;

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

	@Nested
	@DisplayName("사용자가 입력한 게임 컨디션이")
	class CheckGameCondition {
		@DisplayName("자연수가 아닌 다른 문자라면 IllegalArgumentException을 던진다")
		@ParameterizedTest(name = "{displayName} invalidGameCondition={0}")
		@ValueSource(strings = {"-1", "2de"})
		void inputIsNotNaturalNumber(final String selectedGameCondition) {
			IllegalArgumentException invalidCondition = assertThrows(IllegalArgumentException.class,
				() -> validation.isValidGameCondition(selectedGameCondition));
			final String expectedMessage = selectedGameCondition + ", 숫자만 입력해야 합니다";
			assertEquals(expectedMessage, invalidCondition.getMessage());
		}

		@DisplayName("유효하지 않은 컨디션을 선택했다면 IllegalArgumentException을 던진다")
		@ParameterizedTest(name = "{displayName} invalidGameCondition={0}")
		@ValueSource(strings = {"4", "63"})
		void inputIsInvalidGameCondition(final String selectedGameCondition) {
			IllegalArgumentException invalidCondition = assertThrows(IllegalArgumentException.class,
				() -> validation.isValidGameCondition(selectedGameCondition));
			final String expectedMessage = selectedGameCondition + ", 게임 컨디션은 1(새로 시작) 또는 2(종료)여야 합니다";
			assertEquals(expectedMessage, invalidCondition.getMessage());
		}

		@DisplayName("유효한 컨디션을 선택했다면 해당 컨디션을 반환한다")
		@ParameterizedTest(name = "{displayName} selectedGameCondition={0}")
		@ValueSource(strings = {"1", "2"})
		void inputIsValidGameCondition(final String selectedGameCondition) {
			GameCondition gameCondition = validation.isValidGameCondition(selectedGameCondition);
			assertTrue(gameCondition == GameCondition.RESTART_GAME
				|| gameCondition == GameCondition.TERMINATE_GAME);
		}
	}
}