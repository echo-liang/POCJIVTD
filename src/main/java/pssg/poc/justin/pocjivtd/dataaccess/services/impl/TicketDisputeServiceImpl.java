package pssg.poc.justin.pocjivtd.dataaccess.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pssg.poc.justin.pocjivtd.dataaccess.entity.DisputeTicketEntity;
import pssg.poc.justin.pocjivtd.dataaccess.repository.DisputeTicketRepository;

/**
 * The Class TicketDisputeServiceImpl.
 * @author HLiang
 */
@Component
public class TicketDisputeServiceImpl {
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/** The dispute ticket repository. */
	@Autowired
    private DisputeTicketRepository disputeTicketRepository;
	
	/**
	 * Save dispute ticket.
	 *
	 * @param disputeTicketEntity the dispute ticket entity
	 * @return the dispute ticket entity
	 */
	@Transactional(propagation = Propagation.REQUIRED)
    public DisputeTicketEntity saveDisputeTicket(final DisputeTicketEntity disputeTicketEntity) {
		logger.info("saveDisputTicket service impl call starts.");
        // save DisputeTicketEntity
		DisputeTicketEntity dbUP = disputeTicketRepository.save(disputeTicketEntity);
		
		logger.info("saveDisputTicket service impl call ends: {}", dbUP.getId());
        return dbUP;
	}
	
	/**
	 * Find by id.
	 *
	 * @param Id the id
	 * @return the optional
	 */
	public Optional<DisputeTicketEntity> findById (final Long Id) {
		return disputeTicketRepository.findByDisputeId(Id);
	}
}
