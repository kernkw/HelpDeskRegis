package com.helpdesk.model.services.ticketservice;

import com.helpdesk.model.domain.Ticket;

/**
 * @author sendgrid1
 *
 */
public class ITicketServiceImpl implements ITicketService{

	public void storeTicket(Ticket ticket) {
		System.out.println ("Entering method TicketServiceImpl::save");
	}

	public boolean update(Ticket ticket) {
		System.out.println ("Entering method TicketServiceImpl::update");
		return true;
	}

	public Ticket getTicket(int ticketNumber) {
		System.out.println ("Entering method TicketServiceImpl::findByTicketNumber");
		return new Ticket();
	}

	public boolean remove(Ticket ticket) {
		System.out.println ("Entering method TicketServiceImpl::remove");
		return true;
	}

}
