package pssg.poc.justin.pocjivtd.dataaccess.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pssg.poc.justin.pocjivtd.dataaccess.entity.DisputeTicketEntity;

/**
 * The Interface DisputeTicketRepository.
 * @author HLiang
 */

@Repository
public interface DisputeTicketRepository extends JpaRepository<DisputeTicketEntity, Long> {
	
	/**
	 * Find by dispute id.
	 *
	 * @param disputeID the dispute ID
	 * @return the optional
	 */
	//Optional<DisputeTicketEntity> findByDisputeId(Long disputeID);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(S)
	 */
	//DisputeTicketEntity save(DisputeTicketEntity affiliationEntity);
}
