package com.helpdesk.model.services.ticketqueueservice;

import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;
import com.helpdesk.model.services.IService;
import com.helpdesk.model.services.exception.TicketQueueException;

/**
 * Performs actions involved with ticket queue management
 * 
 * @author Kyle Kern
 *
 */
public interface ITicketQueueService extends IService {

	/**
	 * 
	 */
	public final String NAME = "ITicketQueueService";

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
	 * @throws TicketQueueException 
	 */
	public boolean updateTicketQueue(TicketQueue ticketQueue) throws TicketQueueException;

	/**
	 * Stores a ticket in an existing ticket queue
	 * @param ticketQueue 
	 * 
	 * @param ticket
	 * @return true
	 * @throws TicketQueueException 
	 */
	public boolean addToTicketQueue(TicketQueue ticketQueue, Ticket ticket) throws TicketQueueException;

	/**
	 * Retrieves a ticket queue object from database
	 * 
	 * @param ticketQueueNumber
	 * @return new TicketQueue()
	 */
	public TicketQueue getTicketQueue(int ticketQueueNumber);

	/**
	 * Deletes a ticket queue from the databases
	 * @param ticketQueueNumber 
	 * 
	 * @return true
	 */
	public boolean removeTicketQueue(int ticketQueueNumber);


}
