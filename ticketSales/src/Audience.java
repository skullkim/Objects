/** 관객 정보 */
public class Audience {
	private Bag bag;

	public Audience(Bag bag) {
		this.bag = bag;
	}

	/* Bag 클래스의 hold 메서드로 이동
	public Long buy(Ticket ticket) {
		if (bag.hasInvitation()) {
			bag.setTicket(ticket);
			return 0L;
		} else {
			bag.setTicket(ticket);
			bag.minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}
	*/

	//
	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}
	//
}
