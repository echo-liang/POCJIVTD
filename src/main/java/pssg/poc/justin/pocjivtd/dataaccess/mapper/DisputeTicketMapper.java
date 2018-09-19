package pssg.poc.justin.pocjivtd.dataaccess.mapper;

import java.util.Optional;

import com.mysql.jdbc.StringUtils;

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
		disputeTicketEntity.setDisputeStatus(StringUtils.isNullOrEmpty(disputeTicket.getDisputeStatus()) ? "NEW" : disputeTicket.getDisputeStatus());
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
	public static DisputeTicket mapToObject (final Optional<DisputeTicketEntity> disputeTicketEntity_ ) {
		if (!disputeTicketEntity_.isPresent()) {
			return null;
		}
		DisputeTicketEntity disputeTicketEntity = disputeTicketEntity_.get();
		DisputeTicket disputeTicket = new DisputeTicket();
		disputeTicket.setDisputeID(disputeTicketEntity.getId());
		disputeTicket.setDisputeDate(disputeTicketEntity.getDisputeDate());
		disputeTicket.setDisputeStatus(disputeTicketEntity.getDisputeStatus());
		disputeTicket.setEvtXML(disputeTicketEntity.getEvtXML());
		disputeTicket.setTicketNO(disputeTicketEntity.getTicketNO());
		disputeTicket.setViolationDate(disputeTicketEntity.getViolationDate());
		disputeTicket.setViolationTM(disputeTicketEntity.getViolationTM());
		return disputeTicket;
	}
}
