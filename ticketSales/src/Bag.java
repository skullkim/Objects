/**
 * 이벤트 당첨 여부와 티켓 보유 여부를 판단하기 위해
 * 관객의 가방 내부 정보를 담는다
 */
public class Bag {
	/** 가방 내 돈의 양 */
	private Long amount;

	/** 이벤트 당첨 여부 */
	private Invitation invitation;

	/** 티켓 */
	private Ticket ticket;

	/**
	 * 관객은 현급이 있고 이벤트에 당첨 되었거나 당첨되지 않았다
	 */
	public Bag(long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}

	public boolean hasInvitation() {
		return invitation != null;
	}

	public boolean hasTicket() {
		return ticket != null;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}
}
