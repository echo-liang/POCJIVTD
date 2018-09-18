package pssg.poc.justin.pocjivtd.dataaccess.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
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
		logger.info("saveDisputTicket service call starts.");
		ticketDisputeServiceImpl.saveDisputeTicket(DisputeTicketMapper.mapToEntity(disputeTicket));
		logger.info("saveDisputTicket service call ends.");
		return disputeTicket;
	}
	
	/**
	 * Find by id.
	 *
	 * @param disputeID the dispute ID
	 * @return the dispute ticket
	 */
	public DisputeTicket findById (final Long disputeID) {
		return DisputeTicketMapper.mapToObject(ticketDisputeServiceImpl.findById(disputeID));
	}
	
	
}
