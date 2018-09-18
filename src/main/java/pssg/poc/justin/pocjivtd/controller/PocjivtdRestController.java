package pssg.poc.justin.pocjivtd.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import pssg.poc.justin.pocjivtd.dataaccess.services.TicketDisputeService;

/**
 * The Class PocjivtdRestController.
 * @author HLiang
 */
@RestController
public class PocjivtdRestController {
	
	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/** The dispuate ticket service. */
	@Autowired
	TicketDisputeService dispuateTicketService;
	
	/**
	 * One.
	 *
	 * @param id the id
	 * @return the dispute ticket
	 */
	@GetMapping("/disputeTickets/{id}")
	String getDisputeTicket(@PathVariable Long id) {
		logger.info("Get diputeTicket: {}", id);
		DisputeTicket dt = dispuateTicketService.findById(id);
		ObjectMapper mapper = new ObjectMapper();
		String dtString = "";
		try {
			dtString = mapper.writeValueAsString(dt);
			logger.info("diputeTicket: {}", dtString);
		} catch (IOException e) {
			logger.error("Exception occurred in getDisputTicket: {}", e.getMessage());
		}  
		
		return dtString;
	}
	
	/**
	 * Save dispute ticket.
	 *
	 * @param newDisputeTicketStr the new dispute ticket str
	 * @return the dispute ticket
	 */
	@PostMapping("/vtdispute")
	String saveDisputeTicket(@RequestBody String newDisputeTicketStr) {
		logger.info("Save diputeTicket: {}", newDisputeTicketStr);
		//convert String to object
		ObjectMapper mapper = new ObjectMapper();
		DisputeTicket newDisputeTicket = null;
		try {
			newDisputeTicket = mapper.readValue(newDisputeTicketStr, DisputeTicket.class);
			dispuateTicketService.saveDisputeTicket(newDisputeTicket);
			logger.info("Save disputTicket successful.");
			return newDisputeTicketStr;
		} catch (IOException e) {
			logger.error("Exception occurred in saveDisputeTicket: {}", e.getMessage());
		}  
		logger.error("Save diputeTicket failed: {}", newDisputeTicketStr);
		return null;
	}
	
}
