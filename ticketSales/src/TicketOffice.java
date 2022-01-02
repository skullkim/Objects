import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 티켓 판매소 */
public class TicketOffice {

	/** 티켓의 판매 금액 */
	private Long amount;

	/** 관객에게 판매할 티켓 */
	private List<Ticket> tickets = new ArrayList<>();

	public TicketOffice(Long amount, Ticket ... tickets) {
		this.amount = amount;
		this.tickets.addAll(Arrays.asList(tickets));
	}

	// public -> private 으로 변경
	private Ticket getTicket() {
		return tickets.remove(0);
	}

	// public -> private으로 변경
	private void plusAmount(Long amount) {
		this.amount += amount;
	}

	public void sellTicketTo(Audience audience) {
		plusAmount(audience.buy(getTicket()));
	}


	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

}
