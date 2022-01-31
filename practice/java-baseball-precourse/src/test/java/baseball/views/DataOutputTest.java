package baseball.views;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("DataOutput 클래스")
@ExtendWith(MockitoExtension.class)
class DataOutputTest {
	@Mock
	DataOutput output;

	@DisplayName("결과를 출력한다")
	@ParameterizedTest(name = "{displayName} result={0}")
	@ValueSource(strings = {"1볼 1스트라이크", "1볼", "2스트라이크", "3스트라이크"})
	void printResult(final String result) {
		output.printResult(result);
		verify(output, times(1)).printResult(result);
	}
}