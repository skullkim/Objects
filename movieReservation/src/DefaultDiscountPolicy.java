import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* discount policy 구현을 위한 추상 클래스 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy{
	private List<DiscountCondition> conditions = new ArrayList<>();

	public DefaultDiscountPolicy(DiscountCondition ... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	@Override
	public Money calculateDiscountAmount(Screening screening) {

		for(DiscountCondition each : conditions) {
			if(each.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}

		return Money.ZERO;
	}

	abstract protected Money getDiscountAmount(Screening screening);
}
