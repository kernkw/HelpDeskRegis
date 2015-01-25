package com.helpdesk.model.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.helpdesk.model.domain.Ticket.TicketStatus;

/**
 * @author Kyle Kern
 *
 */
public class TicketQueueTest {

	private Account account;
	private List<Account> accountList;
	private Subscriber subscriber;
	private Ticket ticket1, ticket2;
	private List<Ticket> ticketList;
	private List<Ticket.TicketStatus> ticketStatusList;
	private TicketQueue ticketQueue1, ticketQueue2, ticketQueue;
	private List<TicketQueue> ticketQueueList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		subscriber = new Subscriber("Firstname", "Lastname", "PhoneNumber",
				"username", "password", "email@address.com");

		account = new Account(1, true, subscriber, ticket1, ticketQueue1,
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

		ticketQueue1 = new TicketQueue(1,"Newly Created", ticketList,
				ticketStatusList);

		ticketQueue2 = new TicketQueue(2, "Newly Created", ticketList,
				ticketStatusList);

	}

	/**
	 * Test method for {@link com.helpdesk.model.domain.Ticket#validate()}.
	 * Tests with a valid ticket passed in
	 */
	@Test
	public final void testValidateTicketQueue() {
		System.out.println("starting testValidateTicketQueue()");
		// ticket1.validate should assert to True since all variables
		// being passed to create a new Ticket are all valid.
		assertTrue("ticket validates", ticketQueue1.validate());
		System.out.println("testValidate PASSED");
	}

	/**
	 * Tests with an invalid ticket passed in
	 */
	@Test
	public final void testNotValidateTicketQueue() {
		ticketQueue = new TicketQueue();
		System.out.println("starting testNotValidateTicket()");
		// ticket.validate should assert to False since not enough
		// variables being passed to Ticket.
		assertFalse("ticket does not validates", ticketQueue.validate());
		System.out.println("testNotValidate PASSED");
	}

	/**
	 * Test method for
	 * {@link com.helpdesk.model.domain.Ticket#equals(com.helpdesk.model.domain.Ticket)}
	 * . Tests if two tickets are equal
	 */
	@SuppressWarnings("javadoc")
	@Test
	public final void testEqualsTicketQueue() {
		System.out.println("starting testEqualsTicketQueue()");
		// this should assert to true since the contents of
		// ticketQueue1 and ticketQueue2 class variables are identical.
		assertTrue("ticketQueue1 equals ticketQueue2",
				ticketQueue1.equals(ticketQueue2));
		System.out.println("testEqualsTicketQueue PASSED");

	}

	/**
	 * Tests if two tickets are not equal
	 */
	@Test
	public void testNotEqualsTicketQueue() {
		System.out.println("starting testNotEqualsTicketQueue()");
		ticketQueue = new TicketQueue(3, "Closed", ticketList, ticketStatusList);
		// this should assert to false since the contents of
		// ticketQueue and ticketQueue1 class variables are NOT identical.
		assertFalse("ticketQueue does NOT equal ticketQueue1",
				ticketQueue.equals(ticket1));
		System.out.println("testNotEqualsTicketQueue PASSED");
	}

}
