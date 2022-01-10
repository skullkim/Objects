import java.sql.SQLOutput;
import java.time.Duration;

/** 영화 정보를 담는다 */
public class Movie {

	private String title;
	private Duration runningTime;
	private Money fee;
	private DiscountPolicy discountPolicy;

	public Movie(String title, Duration runningTime, Money fee,
			DefaultDiscountPolicy defaultDiscountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = defaultDiscountPolicy;
	}

	public Money getFee() {
		return fee;
	}

	public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
		this.discountPolicy = discountPolicy;
	}

	public Money calculateMovieFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}
}
