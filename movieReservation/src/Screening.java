import java.time.LocalDateTime;

/** 사용자들이 예매하는 대상인 '상영'을 구현한다 */
public class Screening {
	/** 상영할 영화 */
	private Movie movie;
	/** 영화 순번 */
	private int sequence;
	/** 상영 시작 시간 */
	private LocalDateTime whenScreened;

	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}

	private Money calculateFee(int audienceCount) {
		/* Movie 객체의 calculateMovieFee()는 한명에 대한 비용만 계산하기 때문에 인원수를 곱해야 한다 */
		return movie.calculateMovieFee(this).times(audienceCount);
	}

	/**
	 * 영화를 예매 후 예매 정보를 담고 있는 Reservation의 인스턴스를 생성해 반환한다
	 * @param customer 예매자에 대한 정보
	 * @param audienceCount 인원수
	 */
	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(custormer, this, calculateFee(audienceCount),
			audienceCount);
	}

	public Movie getMovie() {
		return movie;
	}

	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}

	public LocalDateTime getWhenScreened() {
		return whenScreened;
	}
}
