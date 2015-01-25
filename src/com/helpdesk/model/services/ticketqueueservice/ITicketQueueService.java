/**
 * 
 */
package com.helpdesk.model.services.ticketqueueservice;

import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;

/**
 * @author sendgrid1
 *
 */
public interface ITicketQueueService {
	/**
	 * @param ticketQueue
	 */
	public void storeTicketQueue(TicketQueue ticketQueue);
	
	/**
	 * @param ticketQueue
	 * @return true
	 */
	public boolean updateTicketQueue(TicketQueue ticketQueue);
	
	/**
	 * @param ticket
	 * @return true
	 */
	public boolean addToTicketQueue(Ticket ticket);
	
	/**
	 * @param ticketQueueNumber
	 * @return new TicketQueue()
	 */
	public TicketQueue getTicketQueue(int ticketQueueNumber);
	
	/**
	 * @param ticketQueue
	 * @return true
	 */
	public boolean removeTicketQueue(TicketQueue ticketQueue);
	

}
