package pssg.poc.justin.pocjivtd.dataaccess.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pssg.poc.justin.pocjivtd.dataaccess.entity.DisputeTicketEntity;
import pssg.poc.justin.pocjivtd.dataaccess.repository.DisputeTicketRepository;

@Component
public class TicketDisputeServiceImpl {
	@Autowired
    private DisputeTicketRepository disputeTicketRepository;
	
	@Transactional(propagation = Propagation.REQUIRED)
    public DisputeTicketEntity saveDisputeTicket(final DisputeTicketEntity disputeTicketEntity) {
        
        // save DisputeTicketEntity
		DisputeTicketEntity dbUP = disputeTicketRepository.save(disputeTicketEntity);
        return dbUP;
	}
	
	public Optional<DisputeTicketEntity> findById (final Long Id) {
		return disputeTicketRepository.findById(Id);
	}
}
