package com.helpdesk.model.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.helpdesk.model.domain.Ticket.TicketStatus;

/**
 * @author Kyle Kern
 *
 */
public class TicketTest {

	private Ticket ticket1, ticket2, ticket;
	private int ticketNumber1, ticketNumber2, ticketNumber3;
	private Account account1;
	private List<Account> accountList;
	private Subscriber subscriber;
	private List<Ticket> ticketList;
	private TicketQueue ticketQueue1;
	private List<TicketQueue> ticketQueueList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		account1 = new Account(1, true, subscriber, ticket1, ticketQueue1,
				ticketList, ticketQueueList);
		ticketNumber1 = 1;
		ticketNumber2 = 2;
		ticketNumber3 = 3;

		ticket1 = new Ticket(ticketNumber1, "Subject of Ticket", "The body of the ticket", 1,
				"1/15/2015-8:00am", "1/15/2015-9:00am", account1, accountList,
				TicketStatus.OPEN);

		ticket2 = new Ticket(ticketNumber2, "Subject of Ticket", "The body of the ticket", 1,
				"1/15/2015-8:00am", "1/15/2015-9:00am", account1, accountList,
				TicketStatus.OPEN);
	}

	/**
	 * Test method for {@link com.helpdesk.model.domain.Ticket#validate()}.
	 * Tests with a valid ticket passed in
	 */
	@Test
	public final void testValidateTicket() {
		System.out.println("starting testValidateTicket()");
		// ticket1.validate should assert to True since all variables
		// being passed to create a new Ticket are all valid.
		assertTrue("ticket validates", ticket1.validate());
		System.out.println("testValidate PASSED");
	}

	/**
	 * Tests with an invalid ticket passed in
	 */
	@Test
	public final void testNotValidateTicket() {
		ticket = new Ticket();
		System.out.println("starting testNotValidateTicket()");
		// ticket.validate should assert to False since not enough
		// variables being passed to Ticket.
		assertFalse("ticket does not validates", ticket.validate());
		System.out.println("testNotValidate PASSED");
	}

	/**
	 * Test method for
	 * {@link com.helpdesk.model.domain.Ticket#equals(com.helpdesk.model.domain.Ticket)}
	 * . Tests if two tickets are equal
	 */
	@SuppressWarnings("javadoc")
	@Test
	public final void testEqualsTicket() {
		System.out.println("starting testEqualsTicket()");
		// this should assert to true since the contents of
		// ticket1 and ticket2 class variables are identical.
		assertTrue("ticket1 equals ticket2", ticket1.equals(ticket2));
		System.out.println("testEqualsTicket PASSED");

	}

	/**
	 * Tests if two tickets are not equal
	 */
	@Test
	public void testNotEqualsTicket() {
		System.out.println("starting testNotEqualsTicket()");
		ticket = new Ticket(ticketNumber3, "Foo", "Body bar", 1, "1/15/2015-8:30am",
				"1/15/2015-9:30am", account1, accountList, TicketStatus.NEW);
		// this should assert to false since the contents of
		// ticket and ticket1 class variables are NOT identical.
		assertFalse("ticket does NOT equal ticket1", ticket.equals(ticket1));
		System.out.println("testNotEqualsTicket PASSED");
	}

}
