package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
	private static final int MAX_RANGE = 9;

	private static final int MIN_RANGE = 1;

	private static final int PROPER_LENGTH = 3;

	private boolean[] usedNumber;

	public int makeThreeDigitRandomNumber() {
		usedNumber = new boolean[MAX_RANGE + 1];
		int randomNumber = 0;
		while(Integer.toString(randomNumber).length() != PROPER_LENGTH) {
			final int pickedNumber = pickUnusedRandomNumber();
			randomNumber *= 10;
			randomNumber += pickedNumber;
			usedNumber[pickedNumber] = true;
		}
		return randomNumber;
	}

	private int pickUnusedRandomNumber() {
		while(true) {
			final int pickedNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
			if(usedNumber[pickedNumber]) {
				continue;
			}
			usedNumber[pickedNumber] = true;
			return pickedNumber;
		}
	}
}
