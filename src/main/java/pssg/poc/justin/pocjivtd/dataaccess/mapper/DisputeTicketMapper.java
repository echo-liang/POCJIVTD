package pssg.poc.justin.pocjivtd.dataaccess.mapper;

import pssg.poc.justin.pocjivtd.controller.DisputeTicket;
import pssg.poc.justin.pocjivtd.dataaccess.entity.DisputeTicketEntity;


/**
 * The Class DisputeTicketMapper.
 * @author HLiang
 */
public class DisputeTicketMapper {

	/**
	 * Map to entity.
	 *
	 * @param disputeTicket the dispute ticket
	 * @return the dispute ticket entity
	 */
	public static DisputeTicketEntity mapToEntity(final DisputeTicket disputeTicket) {
		if (disputeTicket == null) {
			return null;
		}
		DisputeTicketEntity disputeTicketEntity = new DisputeTicketEntity();
		disputeTicketEntity.setDisputeDate(disputeTicket.getDisputeDate());
		disputeTicketEntity.setDisputeStatus(disputeTicket.getDisputeStatus());
		disputeTicketEntity.setEvtXML(disputeTicket.getEvtXML());
		disputeTicketEntity.setTicketNO(disputeTicket.getTicketNO());
		disputeTicketEntity.setViolationDate(disputeTicket.getViolationDate());
		disputeTicketEntity.setViolationTM(disputeTicket.getViolationTM());
		return disputeTicketEntity;
	}
	
	/**
	 * Map to object.
	 *
	 * @param disputeTicketEntity the dispute ticket entity
	 * @return the dispute ticket
	 */
	public static DisputeTicket mapToObject (final DisputeTicketEntity disputeTicketEntity ) {
		if (disputeTicketEntity == null) {
			return null;
		}
		DisputeTicket disputeTicket = new DisputeTicket();
		
		return disputeTicket;
	}
}
