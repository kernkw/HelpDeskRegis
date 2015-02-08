package com.helpdesk.model.services.ticketservice;

import java.io.IOException;

import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.services.IService;
import com.helpdesk.model.services.exception.TicketException;

/**
 * Performs actions associated with ticket management
 * @author Kyle Kern
 *
 */
public interface ITicketService extends IService {

	/**
	 * 
	 */
	public final String NAME = "ITicketService";

	/**
	 * Adds a new ticket object to the database
	 * 
	 * @param ticket
	 * @return true
	 * @throws IOException 
	 */
	public boolean storeTicket(Ticket ticket) throws IOException;

	/**
	 * Edits an existing ticket object to the database
	 * 
	 * @param ticket
	 * @return true
	 * @throws TicketException 
	 */
	public boolean updateTicket(Ticket ticket) throws TicketException;

	/**
	 * Retrieves a ticket object from the database
	 * 
	 * @param ticketNumber
	 * @return true
	 */
	public Ticket getTicket(int ticketNumber);

	/**
	 * Deletes a ticket object from the database
	 * @param ticketNumber 
	 * 
	 * @return true
	 */
	public boolean removeTicket(int ticketNumber);
}
