/**
 * 
 */
package com.helpdesk.model.services.ticketservice;

import com.helpdesk.model.domain.Ticket;

/**
 * @author sendgrid1
 *
 */
public interface ITicketService {
	
	/**
	 * @param ticket
	 */
	public void storeTicket(Ticket ticket);

	/**
	 * @param ticket
	 * @return true
	 */
	public boolean update(Ticket ticket);
	
	/**
	 * @param ticketNumber
	 * @return true
	 */
	public Ticket getTicket(int ticketNumber);
	
	/**
	 * @param ticket
	 * @return true
	 */
	public boolean remove(Ticket ticket);
}
