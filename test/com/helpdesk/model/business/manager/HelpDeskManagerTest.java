package com.helpdesk.model.business.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;
import com.helpdesk.model.domain.Ticket.TicketStatus;
import com.helpdesk.model.services.exception.LoginException;
import com.helpdesk.model.services.exception.TicketException;
import com.helpdesk.model.services.loginservice.ILoginService;
import com.helpdesk.model.services.ticketservice.ITicketService;

/**
 * @author Kyle Kern
 * 
 */
public class HelpDeskManagerTest extends TestCase {

	private HelpDeskManager helpDeskManager;
	private Account account;
	private Subscriber subscriber;
	private List<Account> accountList;
	private Ticket ticket1, ticket2;
	private List<Ticket> ticketList;
	private List<Ticket.TicketStatus> ticketStatusList;
	private TicketQueue ticketQueue1;
	private List<TicketQueue> ticketQueueList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();

		helpDeskManager = HelpDeskManager.getInstance();

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

		account = new Account(true, subscriber, ticket1, ticketQueue1,
				ticketList, ticketQueueList);

	}

	/**
	 * Test performAction method for RegisterSubscriber
	 */
	public final void testPerformActionOnRegisterSubscriber() {
		boolean validAction = helpDeskManager.performAction(
				"RegisterSubscriber", subscriber, null, null);
		assertTrue(validAction);
		System.out.println("testPerformActionOnRegisterSubscriber valid PASSED");

//		Subscriber subscriberIsNull = null;
//		boolean invalidAction = helpDeskManager.performAction(
//				"RegisterSubscriber", subscriberIsNull, null, null);
//		System.out.println("testPerformActionOnRegisterSubscriber PASSED");
//		assertFalse(invalidAction);
//		System.out.println("testPerformActionOnRegisterSubscriber invalid PASSED");

	}

	/**
	 * Test performAction method for LoginSubscriber
	 * @throws LoginException 
	 */
	public final void testPerformActionOnLoginSubscriber() throws LoginException {
		Account registeredAccount = helpDeskManager.registerSubscriber(
				ILoginService.NAME, subscriber);
		
		boolean validAction = helpDeskManager.performAction("LoginSubscriber",
				null, registeredAccount, null);
		
		assertTrue(validAction);
		System.out.println("testPerformActionOnLoginSubscriber valid PASSED");

//		Account accountIsNull = null;
//		boolean invalidAction = helpDeskManager.performAction(
//				"LoginSubscriber", null, accountIsNull, null);
//		assertFalse(invalidAction);
//		System.out.println("testPerformActionOnLoginSubscriber invalid PASSED");
	}

	/**
	 * Test performAction method for CreateNewTicket
	 */
	public final void testPerformActionOnCreateNewTicket() {
		boolean validAction = helpDeskManager.performAction("CreateNewTicket",
				null, null, ticket1);
		assertTrue(validAction);
		System.out.println("testPerformActionOnCreateNewTicket valid PASSED");

//		Ticket ticketIsNull = null;
//		boolean invalidAction = helpDeskManager.performAction(
//				"CreateNewTicket", null, null, ticketIsNull);
//		assertFalse(invalidAction);
//		System.out.println("testPerformActionOnCreateNewTicket invalid PASSED");
	}

	/**
	 * Test performAction method for UpdateTicket
	 */
	public final void testPerformActionOnUpdateTicket() {
		boolean validAction = helpDeskManager.performAction("UpdateTicket", subscriber, account, ticket1);
		assertTrue(validAction);
		System.out.println("testPerformActionOnUpdateTicket valid PASSED");

//		Ticket ticketIsNull = null;
//		boolean invalidAction = helpDeskManager.performAction("UpdateTicket",
//				null, account, ticketIsNull);
//		assertFalse(invalidAction);
//		System.out.println("testPerformActionOnUpdateTicket invalid PASSED");
	}

	/**
	 * Test register subscriber
	 * 
	 * @throws LoginException
	 * 
	 */
	public final void testRegisterSubscriber() throws LoginException {
		Account isRegistered = helpDeskManager.registerSubscriber(
				ILoginService.NAME, subscriber);
		assertTrue(isRegistered != null);
		System.out.println("testRegisterSubscriber valid PASSED");

//		Subscriber invalidSubscriber = null;
//		boolean isNotRegistered = helpDeskManager.registerSubscriber(
//				ILoginService.NAME, invalidSubscriber);
//		assertFalse(isNotRegistered);
//		System.out.println("testRegisterSubscriber invalid PASSED");
	}

	/**
	 * Test login subscriber
	 * @throws LoginException 
	 */
	public final void testLoginSubscriber() throws LoginException {
		Account registeredAccount = helpDeskManager.registerSubscriber(
				ILoginService.NAME, subscriber);
		boolean isLoggedIn = helpDeskManager.loginSubscriber(
				ILoginService.NAME, registeredAccount);
		assertTrue(isLoggedIn);
		System.out.println("testLoginSubscriber valid PASSED");

//		Account invalidAccount = null;
//		boolean isNotLoggedIn = helpDeskManager.loginSubscriber(
//				ILoginService.NAME, invalidAccount);
//		assertFalse(isNotLoggedIn);
//		System.out.println("testLoginSubscriber invalid PASSED");
	}
	
	/**
	 * Test login subscriber
	 */
	public final void testCreateNewTicket() {
		boolean isCreated = false;
		try {
			isCreated  = helpDeskManager.createNewTicket(
					ITicketService.NAME, ticket1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(isCreated);
		System.out.println("createNewTicket valid PASSED");

//		try {
//			isCreated  = helpDeskManager.createNewTicket(
//					ITicketService.NAME, null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertFalse(isCreated);
//		System.out.println("createNewTicket invalid PASSED");
	}
	
	/**
	 * Test login subscriber
	 */
	public final void testUpdateTicket() {
		boolean isUpdated = false;
		try {
			isUpdated  = helpDeskManager.updateTicket(
					ITicketService.NAME, ticket1);
		} catch (TicketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertTrue(isUpdated);
		System.out.println("updateTicket valid PASSED");

//		try {
//			isUpdated = helpDeskManager.createNewTicket(
//					ITicketService.NAME, null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertFalse(isUpdated);
//		System.out.println("updateTicket invalid PASSED");
	}
}
