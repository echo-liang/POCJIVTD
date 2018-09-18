package pssg.poc.justin.pocjivtd.controller;

import lombok.Data;

/**
 * The Class DisputeTicket.
 * @author HLiang
 */
//@Data
public class DisputeTicket {
	
	/** The dispute ID. */
	private Long disputeID;
	
	/** The ticket NO. */
	private String ticketNO;
	
	/** The violation date. */
	private String violationDate;
	
	/** The violation TM. */
	private String violationTM;
	
	/** The dispute date. */
	private String disputeDate;
	
	/** The evt XML. */
	private String evtXML;

	/** The dispute status. */
	private String disputeStatus;
	
	
	/**
	 * Gets the dispute ID.
	 *
	 * @return the dispute ID
	 */
	public Long getDisputeID() {
		return disputeID;
	}

	/**
	 * Sets the dispute ID.
	 *
	 * @param disputeID the new dispute ID
	 */
	public void setDisputeID(Long disputeID) {
		this.disputeID = disputeID;
	}

	/**
	 * Gets the ticket NO.
	 *
	 * @return the ticket NO
	 */
	public String getTicketNO() {
		return ticketNO;
	}

	/**
	 * Sets the ticket NO.
	 *
	 * @param ticketNO the new ticket NO
	 */
	public void setTicketNO(String ticketNO) {
		this.ticketNO = ticketNO;
	}

	/**
	 * Gets the violation date.
	 *
	 * @return the violation date
	 */
	public String getViolationDate() {
		return violationDate;
	}

	/**
	 * Sets the violation date.
	 *
	 * @param violationDate the new violation date
	 */
	public void setViolationDate(String violationDate) {
		this.violationDate = violationDate;
	}

	/**
	 * Gets the violation TM.
	 *
	 * @return the violation TM
	 */
	public String getViolationTM() {
		return violationTM;
	}

	/**
	 * Sets the violation TM.
	 *
	 * @param violationTM the new violation TM
	 */
	public void setViolationTM(String violationTM) {
		this.violationTM = violationTM;
	}

	/**
	 * Gets the dispute date.
	 *
	 * @return the dispute date
	 */
	public String getDisputeDate() {
		return disputeDate;
	}

	/**
	 * Sets the dispute date.
	 *
	 * @param disputeDate the new dispute date
	 */
	public void setDisputeDate(String disputeDate) {
		this.disputeDate = disputeDate;
	}

	/**
	 * Gets the evt XML.
	 *
	 * @return the evt XML
	 */
	public String getEvtXML() {
		return evtXML;
	}

	/**
	 * Sets the evt XML.
	 *
	 * @param evtXML the new evt XML
	 */
	public void setEvtXML(String evtXML) {
		this.evtXML = evtXML;
	}

	/**
	 * Gets the dispute status.
	 *
	 * @return the dispute status
	 */
	public String getDisputeStatus() {
		return disputeStatus;
	}

	/**
	 * Sets the dispute status.
	 *
	 * @param disputeStatus the new dispute status
	 */
	public void setDisputeStatus(String disputeStatus) {
		this.disputeStatus = disputeStatus;
	}
		
	
}
