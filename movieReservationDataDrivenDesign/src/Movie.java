import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {
	// 기존 코드에서도 존재했던 부분
	private String title;
	private Duration runningTime;
	private Money fee;
	// 데이터 중심 설계로 인해 추가된 부분
	private List<DiscountCondition> discountConditions;
	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;


	public Money getFee() {
		return fee;
	}

	public List<DiscountCondition> getDiscountConditions() {
		return discountConditions;
	}

	public MovieType getMovieType() {
		return movieType;
	}

	public Money calculateAmountDiscountedFee() {
		if (movieType != MovieType.AMOUNT_DISCOUNT) {
			throw new IllegalArgumentException();
		}

		return fee.minus(discountAmount);
	}

	public Money calculatePercentDiscountedFee() {
		if (movieType != MovieType.PERCENT_DISCOUNT) {
			throw new IllegalArgumentException();
		}

		return fee.minus(fee.times(discountPercent));
	}

	public Money calculateNoneDiscountedFee() {
		if (movieType != MovieType.NONE_DISCOUNT) {
			throw new IllegalArgumentException();
		}

		return fee;
	}

	public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
		for (DiscountCondition condition: discountConditions) {
			if (condition.getType() == DiscountConditionType.PERIOD) {
				if (condition.isDiscountable(whenScreened.getDayOfWeek(),
						whenScreened.toLocalTime())) {
					return true;
				}
			} else {
				if (condition.isDiscountable(sequence)) {
					return true;
				}
			}
		}
		return false;
	}

	public Money getDiscountAmount() {
		return discountAmount;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setFee(Money fee) {
		this.fee = fee;
	}

	public void setDiscountConditions(List<DiscountCondition> discountConditions) {
		this.discountConditions = discountConditions;
	}

	public void setMovieType(MovieType movieType) {
		this.movieType = movieType;
	}

	public void setDiscountAmount(Money discountAmount) {
		this.discountAmount = discountAmount;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
}
