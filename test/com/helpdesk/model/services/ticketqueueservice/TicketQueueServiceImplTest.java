/**
 * 
 */
package com.helpdesk.model.services.ticketqueueservice;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;
import com.helpdesk.model.domain.Ticket.TicketStatus;
import com.helpdesk.model.services.factory.ServiceFactory;

/**
 * @author Kyle Kern
 *
 */
public class TicketQueueServiceImplTest extends TestCase {
	private ServiceFactory serviceFactory;
	private Account account;
	private List<Account> accountList;
	private Subscriber subscriber;
	private Ticket ticket1, ticket2;
	private List<Ticket> ticketList;
	private List<Ticket.TicketStatus> ticketStatusList;
	private TicketQueue ticketQueue;
	private List<TicketQueue> ticketQueueList;
	
	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();

		serviceFactory = new ServiceFactory();
		
		subscriber = new Subscriber("Firstname", "Lastname", "PhoneNumber",
				"username", "password", "email@address.com");

		account = new Account(1, true, subscriber, ticket1, ticketQueue,
				ticketList, ticketQueueList);

		ticket1 = new Ticket(1,"Subject of Ticket", "The body of the ticket", 1,
				"1/15/2015-8:00am", "1/15/2015-9:00am", account, accountList,
				TicketStatus.OPEN);

		ticket2 = new Ticket(2,"Subject of Ticket 2", "The body of this ticket",
				1, "1/15/2015-8:30am", "1/15/2015-9:30am", account,
				accountList, TicketStatus.NEW);

		ticketList = new ArrayList<Ticket>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);

		ticketStatusList = new ArrayList<Ticket.TicketStatus>();
		ticketStatusList.add(ticket1.getStatus());
		ticketStatusList.add(ticket2.getStatus());

		ticketQueue = new TicketQueue(1,"Newly Created", ticketList,
				ticketStatusList);
	}
	
	/**
	 * Test method for {@link com.helpdesk.model.services.ticketqueueservice.TicketQueueServiceImpl#storeTicketQueue(com.helpdesk.model.domain.TicketQueue)}.
	 */
	public final void testStoreTicketQueue() {
		ITicketQueueService ticketQueueService = (ITicketQueueService)serviceFactory.getTicketQueueService();
		ticketQueueService.storeTicketQueue(ticketQueue);
        System.out.println("testStoreTicketQueue PASSED");
	}

	/**
	 * Test method for {@link com.helpdesk.model.services.ticketqueueservice.TicketQueueServiceImpl#updateTicketQueue(com.helpdesk.model.domain.TicketQueue)}.
	 */
	public final void testUpdateTicketQueue() {
		ITicketQueueService ticketQueueService = (ITicketQueueService)serviceFactory.getTicketQueueService();
		assertTrue(ticketQueueService.updateTicketQueue(ticketQueue));
        System.out.println("testUpdateTicketQueue PASSED");
	}
	
	/**
	 * Test method for {@link com.helpdesk.model.services.ticketqueueservice.TicketQueueServiceImpl#addToTicketQueue(com.helpdesk.model.domain.Ticket)}.
	 */
	public final void testAddToTicketQueue() {
		ITicketQueueService ticketQueueService = (ITicketQueueService)serviceFactory.getTicketQueueService();
		assertTrue(ticketQueueService.addToTicketQueue(ticket1));
        System.out.println("testUpdateTicketQueue PASSED");
	}
	
	/**
	 * Test method for {@link com.helpdesk.model.services.ticketqueueservice.TicketQueueServiceImpl#getTicketQueue(int)}.
	 */
	public final void testGetTicketQueue() {
		ITicketQueueService ticketQueueService = (ITicketQueueService)serviceFactory.getTicketQueueService();
		assertNotNull(ticketQueueService.getTicketQueue(1));
        System.out.println("testStoreTicketQueue PASSED");
	}

	/**
	 * Test method for {@link com.helpdesk.model.services.ticketqueueservice.TicketQueueServiceImpl#removeTicketQueue(com.helpdesk.model.domain.TicketQueue)}.
	 */
	public final void testRemoveTicketQueue() {
		ITicketQueueService ticketQueueService = (ITicketQueueService)serviceFactory.getTicketQueueService();
		ticketQueueService.removeTicketQueue(ticketQueue);
        System.out.println("testStoreTicketQueue PASSED");
	}


}
