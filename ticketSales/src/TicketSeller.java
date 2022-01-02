/** 티켓 판매원 */
public class TicketSeller {

	/** 티켓 판매원은 자신이 일하는 티켓 판매소를 알고 있어야 한다 */
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	/* TicketOffice의 sellTicketTo로 로직 이동
	public void sellTo(Audience audience) {
		ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
	}
	 */

	//
	public void sellTo(Audience audience) {
		ticketOffice.sellTicketTo(audience);
	}
	//

}
