package com.helpdesk.model.services.ticketservice;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import com.helpdesk.model.business.exception.ServiceLoadException;
import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;
import com.helpdesk.model.domain.Ticket.TicketStatus;
import com.helpdesk.model.services.exception.TicketException;
import com.helpdesk.model.services.factory.ServiceFactory;

/**
 * @author Kyle Kern
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

		serviceFactory = ServiceFactory.getInstance();

		account = new Account(true, subscriber, ticket, ticketQueue1,
				ticketList, ticketQueueList);
		ticketNumber = 1;

		ticket = new Ticket(ticketNumber, "Subject of Ticket", "The body of the ticket", 1,
				"1/15/2015-8:00am", "1/15/2015-9:00am", account, accountList,
				TicketStatus.OPEN);
	}


	/**
	 * Test method for {@link com.helpdesk.model.services.ticketservice.TicketServiceImpl#storeTicket(com.helpdesk.model.domain.Ticket)}.
	 * @throws IOException 
	 */
	public final void testStoreTicket() throws IOException {
		ITicketService ticketService;
		try {
			ticketService = (ITicketService) serviceFactory.getService(ITicketService.NAME);
			ticketService.storeTicket(ticket);
			System.out.println("testStoreTicket PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	/**
	 * Test method for {@link com.helpdesk.model.services.ticketservice.TicketServiceImpl#updateTicket(com.helpdesk.model.domain.Ticket)}.
	 * @throws IOException 
	 * @throws TicketException 
	 */
	public final void testUpdateTicket() throws IOException, TicketException {
		ITicketService ticketService;
		try {
			ticketService = (ITicketService) serviceFactory.getService(ITicketService.NAME);
			ticketService.storeTicket(ticket);
			assertTrue(ticketService.updateTicket(ticket));
			System.out.println("testUpdateAccount PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	/**
	 * Test method for {@link com.helpdesk.model.services.ticketservice.TicketServiceImpl#getTicket(int)}.
	 * @throws IOException 
	 */
	public final void testGetTicket() throws IOException {
		ITicketService ticketService;
		try {
			ticketService = (ITicketService) serviceFactory.getService(ITicketService.NAME);
			ticketService.storeTicket(ticket);
			assertNotNull(ticketService.getTicket(ticketNumber));
			System.out.println("testGetTicket PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	/**
	 * Test method for {@link com.helpdesk.model.services.ticketservice.TicketServiceImpl#removeTicket(int)}.
	 */
	public final void testRemoveTicket() {
		ITicketService ticketService;
		try {
			ticketService = (ITicketService) serviceFactory.getService(ITicketService.NAME);
			assertTrue(ticketService.removeTicket(ticketNumber));
			System.out.println("testRemoveTicket PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

}
