package pssg.poc.justin.pocjivtd.controller;

public class DisputeTicketNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisputeTicketNotFoundException(Long id) {
		super("Could not find dispute ticket: " + id);
	}
}
