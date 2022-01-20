package ReservationAgencyRefactoring;

public class ReservationAgency {
	public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
		boolean discountable = checkDiscountable(screening);
		Money fee = calculateFee(screening, discoutable, audienceCount);
		return createReservation(screening, customer, audienceCount, fee);
	}

	private boolean checkDiscountable(Screening screening) {
		return screening.getMovie().getDiscountConditions().stream()
			.anyMatch(condition -> isDiscountable(condition, screening));
	}

	private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
		if (discountable) {
			return screening.getMovie().getFee()
				.minus(calculateDiscountedFee(screening.getMovie()))
				.times(audienceCount);
		}

		return screening.getMovie().getFee().times(audienceCount);
	}

	private Money calculateDiscountedFee(Movie movie) {
		switch (movie.getMovieType()) {
			case AMOUNT_DISCOUNT:
				discountAmount = movie.getDiscountAmount();
				break;
			case PERCENT_DISCOUNT:
				discountAmount = movie.getFee().times(movie.getDiscountPercent());
				break;
			case NONE_DISCOUNT:
				discountAmount = Money.ZERO;
				break;
		}

		throw new IllegalArgumentException();
	}

	private Money calculateAmountDiscountedFee(Movie movie) {
		return movie.getDiscountAmount();
	}

	private Money calculatePercentDiscountedFee(Movie movie) {
		return movie.getFee().times(movie.getDiscountPercent());
	}

	private Money calculateNoneDiscountedFee(Movie movie) {
		return Money.ZERO;
	}

	private Reservation createReservation(Screening screening, Customer customer,
			int audienceCount, Money fee) {
		return new Reservation(customer, screening, fee, audienceCount);
	}
}