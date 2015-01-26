package com.helpdesk.model.services.ticketservice;

import com.helpdesk.model.domain.Ticket;

/**
 * @author Kyle Kern
 *
 */
public class TicketServiceImpl implements ITicketService{

	public void storeTicket(Ticket ticket) {
		System.out.println ("Entering method TicketServiceImpl::save");
	}

	public boolean updateTicket(Ticket ticket) {
		System.out.println ("Entering method TicketServiceImpl::update");
		return true;
	}

	public Ticket getTicket(int ticketNumber) {
		System.out.println ("Entering method TicketServiceImpl::findByTicketNumber");
		return new Ticket();
	}

	public boolean removeTicket(Ticket ticket) {
		System.out.println ("Entering method TicketServiceImpl::remove");
		return true;
	}

}
