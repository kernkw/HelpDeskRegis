package com.helpdesk.model.services.accountservice;

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
 * @author sendgrid1
 *
 */
public class AccountServiceImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private Account account;
	private int accountNumber;
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
	protected void setUp() throws Exception {
		super.setUp();

		serviceFactory = new ServiceFactory();

		subscriber = new Subscriber("Firstname", "Lastname", "PhoneNumber",
				"username", "password", "email@address.com");

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
		
		accountNumber = 1;

		account = new Account(accountNumber, true, subscriber, ticket1, ticketQueue1,
				ticketList, ticketQueueList);

	}
	
	/**
	 * 
	 */
	public final void testStoreAccount() {
		IAccountService accountService = (IAccountService)serviceFactory.getAccountService();
		accountService.storeAccount(account);
        System.out.println("testStoreAccount PASSED");
	}
	
	/**
	 * 
	 */
	public final void testUpdateAccount() {
		IAccountService accountService = (IAccountService)serviceFactory.getAccountService();
		assertTrue(accountService.updateAccount(account));
        System.out.println("testUpdateAccount PASSED");
	}
	
	/**
	 * 
	 */
	public final void testGetAccount() {
		IAccountService accountService = (IAccountService)serviceFactory.getAccountService();
		assertNotNull(accountService.getAccount(accountNumber));
        System.out.println("testGetAccount PASSED");
	}
	
	/**
	 * 
	 */
	public final void testRemoveAccount() {
		IAccountService accountService = (IAccountService)serviceFactory.getAccountService();
		assertTrue(accountService.removeAccount(account));
        System.out.println("testRemoveAccount PASSED");
	}
	
}
