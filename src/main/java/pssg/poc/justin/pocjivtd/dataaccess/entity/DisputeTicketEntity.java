package pssg.poc.justin.pocjivtd.dataaccess.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class DisputeTicketEntity.
 */
@Entity
//@Getter @Setter @NoArgsConstructor // <--- THIS is it
@Table(name = "VT_DISPUTES")
public class DisputeTicketEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
    @GeneratedValue
    @Column(name = "DISPUTE_ID")
	private Long id;
	
	/** The ticket NO. */
	@Column(name = "TICKET_NO")
	private String ticketNO;
	
	/** The violation date. */
	@Column(name = "VIOLATION_DT")
    @Temporal(TemporalType.TIMESTAMP)
	private String violationDate;
	
	/** The violation TM. */
	@Column(name = "VIOLATION_TM")
    private String violationTM;
	
	/** The dispute date. */
	@Column(name = "DISPUTE_DT")
    @Temporal(TemporalType.TIMESTAMP)
	private String disputeDate;
	
	/** The evt XML. */
	@Column(name = "TICKET_xml")
	private String evtXML;
	
	/** The dispute status. */
	@Column(name = "DISPUTE_STATUS")
	private String disputeStatus;
	
	
	/**
	 * Instantiates a new dispute ticket entity.
	 *
	 * @param ticketNO the ticket NO
	 * @param violationDate the violation date
	 * @param violationTM the violation TM
	 * @param disputeDate the dispute date
	 * @param evtXML the evt XML
	 * @param disputeStatus the dispute status
	 */
	public DisputeTicketEntity(String ticketNO, String violationDate, String violationTM, String disputeDate, String evtXML, String disputeStatus) {
		this.ticketNO = ticketNO;
		this.violationDate = violationDate;
		this.violationTM = violationTM;
		this.disputeDate = disputeDate;
		this.evtXML = evtXML;
		this.disputeStatus = disputeStatus;
		
	}


	public DisputeTicketEntity() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
