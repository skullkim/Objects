import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
	private String subject;
	private LocalDateTime from;
	private Duration duration;

	public Event(String subject, LocalDateTime from, Duration duration) {
		this.subject = subject;
		this.from = from;
		this.duration = duration;
	}

	public boolean isSatisfied(RecurringSchedule schedule) {
		if (from.getDayOfWeek() != schedule.getDayOfWeek()
				|| !from.toLocalTime().equals(schedule.getFrom())
				|| !duration.equals(schedule.getDuration())) {
			// reschedule 호출 부분 삭제
			return false;
		}
		return true;
	}

	// private 에서 public 으로 변경
	public void reschedule(RecurringSchedule schedule) {
		from = LocalDateTime.of(from.toLocalDate()
			.plusDays(daysDistance(schedule)), schedule.getFrom());
		duration = schedule.getDuration();
	}

	private long daysDistance(RecurringSchedule schedule) {
		return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
	}

}
