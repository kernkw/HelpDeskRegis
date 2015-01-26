package com.helpdesk.model.services.ticketqueueservice;

import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;

/**
 * Performs actions involved with ticket queue management
 * 
 * @author Kyle Kern
 *
 */
public interface ITicketQueueService {
	/**
	 * Adds a new ticket queue to the database
	 * 
	 * @param ticketQueue
	 */
	public void storeTicketQueue(TicketQueue ticketQueue);
	
	/**
	 * Edits an existing ticket queue in database
	 * 
	 * @param ticketQueue
	 * @return true
	 */
	public boolean updateTicketQueue(TicketQueue ticketQueue);
	
	/**
	 * Stores a ticket in an existing ticket queue
	 * 
	 * @param ticket
	 * @return true
	 */
	public boolean addToTicketQueue(Ticket ticket);
	
	/**
	 * Retrieves a ticket queue object from database
	 * 
	 * @param ticketQueueNumber
	 * @return new TicketQueue()
	 */
	public TicketQueue getTicketQueue(int ticketQueueNumber);
	
	/**
	 * Deletes a ticket queue from the databases
	 * 
	 * @param ticketQueue
	 * @return true
	 */
	public boolean removeTicketQueue(TicketQueue ticketQueue);
	

}
