package com.helpdesk.model.services.ticketservice;

import com.helpdesk.model.domain.Ticket;

/**
 * Performs actions associated with ticket management
 * @author Kyle Kern
 *
 */
public interface ITicketService {
	
	/**
	 * Adds a new ticket object to the database
	 * 
	 * @param ticket
	 */
	public void storeTicket(Ticket ticket);

	/**
	 * Edits an existing ticket object to the database
	 * 
	 * @param ticket
	 * @return true
	 */
	public boolean updateTicket(Ticket ticket);
	
	/**
	 * Retrieves a ticket object from the database
	 * 
	 * @param ticketNumber
	 * @return true
	 */
	public Ticket getTicket(int ticketNumber);
	
	/**
	 * Deletes a ticket object from the database
	 * 
	 * @param ticket
	 * @return true
	 */
	public boolean removeTicket(Ticket ticket);
}
