package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("RandomNumber 클래스")
class RandomNumberTest {
	int pickedNumber;

	@DisplayName("3자리 난수 생성 확인")
	@Test
	void isThreeDigitsNumber() {
		final int numberLength = Integer.toString(pickedNumber).length();

		assertEquals(numberLength, 3);
	}

	@DisplayName("각 자리수가 서로 다른 수인지 확인")
	@RepeatedTest(value = 10, name="{displayName}, {currentRepetition}/{totalRepetitions}")
	void checkDuplicatedNumber() {
		assertFalse(hasDuplicatedNumber());
	}

	@BeforeEach
	void makeRandomNumber() {
		final RandomNumber randomNumber = new RandomNumber();
		pickedNumber = randomNumber.makeThreeDigitRandomNumber();
	}

	boolean hasDuplicatedNumber() {
		final String pickedNumberStr = Integer.toString(pickedNumber);
		final int numberLength = pickedNumberStr.length() - 1;
		final String reversedPickedNumber = (new StringBuffer(pickedNumberStr)).reverse()
			.toString();
		for (int i = 0; i < pickedNumberStr.length(); i++) {
			final char currentCharacter = pickedNumberStr.charAt(i);
			if(numberLength - reversedPickedNumber.indexOf(currentCharacter) != i) {
				return true;
			}
		}
		return false;
	}
}