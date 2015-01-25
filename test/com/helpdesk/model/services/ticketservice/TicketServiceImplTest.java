package com.helpdesk.model.services.ticketservice;

import java.util.List;

import junit.framework.TestCase;

import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;
import com.helpdesk.model.domain.Ticket.TicketStatus;
import com.helpdesk.model.services.factory.ServiceFactory;

/**
 * @author sendgrid1
 *
 */
public class TicketServiceImplTest extends TestCase {
	private ServiceFactory serviceFactory;
	private Ticket ticket;
	private Integer ticketNumber;
	private Account account;
	private List<Account> accountList;
	private Subscriber subscriber;
	private List<Ticket> ticketList;
	private TicketQueue ticketQueue1;
	private List<TicketQueue> ticketQueueList;

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();

		serviceFactory = new ServiceFactory();
		
		account = new Account(1, true, subscriber, ticket, ticketQueue1,
				ticketList, ticketQueueList);
		ticketNumber = 1;

		ticket = new Ticket(ticketNumber, "Subject of Ticket", "The body of the ticket", 1,
				"1/15/2015-8:00am", "1/15/2015-9:00am", account, accountList,
				TicketStatus.OPEN);
	}
	
	/**
	 * 
	 */
	public final void testStoreTicket() {
		ITicketService ticketService = (ITicketService)serviceFactory.getTicketService();
		ticketService.storeTicket(ticket);
        System.out.println("testStoreTicket PASSED");
	}

	/**
	 * 
	 */
	public final void testUpdateTicket() {
		ITicketService ticketService = (ITicketService)serviceFactory.getTicketService();
		assertTrue(ticketService.updateTicket(ticket));
        System.out.println("testUpdate Ticket PASSED");
	}

	/**
	 * 
	 */
	public final void testGetTicket() {
		ITicketService ticketService = (ITicketService)serviceFactory.getTicketService();
		assertNotNull(ticketService.getTicket(ticketNumber));
        System.out.println("testGetTicket PASSED");
	}

	/**
	 * 
	 */
	public final void testRemoveTicket() {
		ITicketService ticketService = (ITicketService)serviceFactory.getTicketService();
		assertTrue(ticketService.removeTicket(ticket));
        System.out.println("testRemoveTicket PASSED");
	}

}
