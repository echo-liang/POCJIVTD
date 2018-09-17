package pssg.poc.justin.pocjivtd.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import pssg.poc.justin.pocjivtd.dataaccess.entity.DisputeTicketEntity;
import pssg.poc.justin.pocjivtd.dataaccess.entity.DisputeTicketNotFoundException;
import pssg.poc.justin.pocjivtd.dataaccess.repository.DisputeTicketRepository;
import pssg.poc.justin.pocjivtd.dataaccess.services.TicketDisputeService;

@RestController
public class PocjivtdRestController {
	
	@Autowired
	TicketDisputeService dispuateTicketService;
	
	@GetMapping("/disputeTickets/{id}")
	DisputeTicketEntity one(@PathVariable Long id) {
		return dispuateTicketService.findById(id).orElseThrow(() -> new DisputeTicketNotFoundException(id));
	}
	
	@PostMapping("/vtdispute")
	DisputeTicket newEmployee(@RequestBody String newDisputeTicketStr) {
		//convert String to object
		ObjectMapper mapper = new ObjectMapper();
		DisputeTicket newDisputeTicket = null;
		try {
			newDisputeTicket = mapper.readValue(newDisputeTicketStr, DisputeTicket.class);
			return dispuateTicketService.saveDisputeTicket(newDisputeTicket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    
		return null;
	}
	
}
