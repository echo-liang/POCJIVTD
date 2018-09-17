package pssg.poc.justin.pocjivtd.dataaccess.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pssg.poc.justin.pocjivtd.controller.DisputeTicket;
import pssg.poc.justin.pocjivtd.dataaccess.mapper.DisputeTicketMapper;
import pssg.poc.justin.pocjivtd.dataaccess.services.impl.TicketDisputeServiceImpl;


/**
 * The Class TicketDisputeService.
 * @author HLiang
 */
@Service
public class TicketDisputeService {
	
	/** The ticket dispute service impl. */
	@Autowired
	TicketDisputeServiceImpl ticketDisputeServiceImpl;
	
	/**
	 * Save dispute ticket.
	 *
	 * @param disputeTicket the dispute ticket
	 * @return the dispute ticket
	 */
	public DisputeTicket saveDisputeTicket(final DisputeTicket disputeTicket) {
		ticketDisputeServiceImpl.saveDisputeTicket(DisputeTicketMapper.mapToEntity(disputeTicket));
		return disputeTicket;
	}
	
	public Optional<DisputeTicket> findById (final Long disputeID) {
		return DisputeTicketMapper.mapToObject(ticketDisputeServiceImpl.findById(disputeID));
	}
	
	
}
