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
public class TicketQueueServiceImpl implements ITicketQueueService {

	public void storeTicketQueue(TicketQueue ticketQueue) {
		System.out.println ("Entering method TicketQueueServiceImpl::storeTicketQueue");
		
	}

	public boolean updateTicketQueue(TicketQueue ticketQueue) {
		System.out.println ("Entering method TicketQueueServiceImpl::updateTicketQueue");
		return true;
	}

	public boolean addToTicketQueue(Ticket ticket) {
		System.out.println ("Entering method TicketQueueServiceImpl::addToTicketQueue");
		return true;
	}

	public TicketQueue getTicketQueue(int ticketQueueNumber) {
		System.out.println ("Entering method TicketQueueServiceImpl::getTicketQueue");
		return new TicketQueue();
	}

	public boolean removeTicketQueue(TicketQueue ticketQueue) {
		System.out.println ("Entering method TicketQueueServiceImpl::removeTicketQueue");
		return true;
	}

}
