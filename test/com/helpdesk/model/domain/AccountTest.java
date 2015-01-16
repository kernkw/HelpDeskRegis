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
public class AccountTest {

	private Account account1, account2, account;
	private List<Account> accountList;
	private Subscriber subscriber;
	private Ticket ticket1, ticket2;
	private List<Ticket> ticketList;
	private List<Ticket.TicketStatus> ticketStatusList;
	private TicketQueue ticketQueue1;
	private List<TicketQueue> ticketQueueList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		subscriber = new Subscriber("Firstname", "Lastname", "PhoneNumber",
				"username", "password", "email@address.com");

		ticket1 = new Ticket("Subject of Ticket", "The body of the ticket", 1,
				"1/15/2015-8:00am", "1/15/2015-9:00am", account1, accountList,
				TicketStatus.OPEN);

		ticket2 = new Ticket("Subject of Ticket 2", "The body of this ticket",
				1, "1/15/2015-8:30am", "1/15/2015-9:30am", account1,
				accountList, TicketStatus.NEW);

		ticketList = new ArrayList<Ticket>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);

		ticketStatusList = new ArrayList<Ticket.TicketStatus>();
		ticketStatusList.add(ticket1.getStatus());
		ticketStatusList.add(ticket2.getStatus());

		ticketQueue1 = new TicketQueue("Newly Created", ticketList,
				ticketStatusList);

		account1 = new Account(true, subscriber, ticket1, ticketQueue1,
				ticketList, ticketQueueList);
		account2 = new Account(true, subscriber, ticket1, ticketQueue1,
				ticketList, ticketQueueList);
	}

	/**
	 * Test method for {@link com.helpdesk.model.domain.Account#validate()}.
	 * Tests with a valid account passed in
	 */
	@Test
	public final void testValidateAccount() {
		System.out.println("starting testValidateAccount()");
		// account1.validate should assert to True since all variables
		// being passed to create a new Account are all valid.
		assertTrue("account validates", account1.validate());
		System.out.println("testValidate PASSED");
	}

	/**
	 * Tests with an invalid account passed in
	 */
	@Test
	public final void testNotValidateAccount() {
		account = new Account();
		System.out.println("starting testNotValidateAccount()");
		// account1.validate should assert to False since all variables
		// being passed to create a new Account are not present.
		assertFalse("account does not validates", account.validate());
		System.out.println("testNotValidate PASSED");
	}

	/**
	 * Test method for
	 * {@link com.helpdesk.model.domain.Account#equals(com.helpdesk.model.domain.Account)}
	 * . Tests if two accounts are equal
	 */
	@SuppressWarnings("javadoc")
	@Test
	public final void testEqualsAccount() {
		System.out.println("starting testEqualsAccount()");
		// this should assert to true since the contents of
		// account1 and account2 class variables are identical.
		assertTrue("account1 equals account2", account1.equals(account2));
		System.out.println("testEqualsAccount PASSED");

	}

	/**
	 * Tests if two accounts are not equal
	 */
	@Test
	public void testNotEqualsAccount() {
		System.out.println("starting testNotEqualsAccount()");
		account = new Account(false, subscriber, ticket1, ticketQueue1,
				ticketList, ticketQueueList);
		// this should assert to false since the contents of
		// account1 and account2 class variables are NOT identical.
		assertFalse("account does NOT equal account1", account.equals(account1));
		System.out.println("testNotEqualsAccount PASSED");
	}

}
