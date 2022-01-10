import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
	private DiscountConditionType type;

	// 순번 조건(type이 SEQUENCE)에만 사용되는 상태들
	private int sequence;
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public DiscountConditionType getType() {
		return type;
	}

	public void setType(DiscountConditionType type) {
		this.type = type;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
}
