import java.time.LocalDateTime;

public class Screening {
	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Reservation reserve(Custormer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}

	private Money calculateFee(int audienceCount) {
		// Movie에 전송하느 메시지의 시그니처를 calculateMovieFee(Screening screening)으로 선언했다.
		// 이 메시지는 수신자인 Movie가 아니라 송신자인 Screening의 의도를 표현한다.
		return movie.calculateMovieFee(this);
	}

	public int getSequence() {
		return sequence;
	}

	public LocalDateTime getWhenScreened() {
		return whenScreened;
	}
}
