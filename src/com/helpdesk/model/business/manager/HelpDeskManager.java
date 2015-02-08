package com.helpdesk.model.business.manager;

import java.io.IOException;

import com.helpdesk.model.business.exception.ServiceLoadException;
import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.services.exception.LoginException;
import com.helpdesk.model.services.exception.TicketException;
import com.helpdesk.model.services.factory.ServiceFactory;
import com.helpdesk.model.services.loginservice.ILoginService;
import com.helpdesk.model.services.ticketservice.ITicketService;

/**
 * @author Kyle Kern
 * 
 */
public class HelpDeskManager extends ManagerSuperType {
	private static HelpDeskManager _instance;

	private HelpDeskManager() {

	}

	/**
	 * Singleton entry point
	 * 
	 * @return instance
	 */
	public static synchronized HelpDeskManager getInstance() {
		if (_instance == null) {
			_instance = new HelpDeskManager();
		}
		return _instance;
	}

	/**
	 * Generic method that all clients of this class can call to perform certain
	 * actions.
	 * 
	 * @param commandString
	 *            Holds the service name to be invoked
	 * @param account
	 *            * Holds application specific domain state
	 * @param ticket
	 * @return false if action failed true if action is successful
	 */
	@Override
	public boolean performAction(String commandString, Subscriber subscriber,
			Account account, Ticket ticket) {
		boolean action = false;

		if (commandString.equals("RegisterSubscriber")) {
			try {
				account = registerSubscriber(ILoginService.NAME, subscriber);
				action = account != null ? true : false;
			} catch (LoginException e) {
				e.printStackTrace();
			}
		} else if (commandString.equals("LoginSubscriber")) {
			action = loginSubscriber(ILoginService.NAME, account);
		} else if (commandString.equals("CreateNewTicket")) {
			try {
				action = createNewTicket(ITicketService.NAME, ticket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (commandString.equals("UpdateTicket")) {
			try {
				action = updateTicket(ITicketService.NAME, ticket);
			} catch (TicketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return action;
	}

	/**
	 * Method delegates to the ServiceFactory to execute a service. Good part of
	 * this approach is that the Manager knows the service by a string name -
	 * thus achieving the decoupling effect that we so desire in the MVC
	 * approach.
	 * 
	 * @param commandString
	 *            contains the service that needs to be performed
	 * @param subscriber
	 *            contains the customer registration info needed
	 * @return account
	 * @throws LoginException
	 * 
	 */
	public Account registerSubscriber(String commandString,
			Subscriber subscriber) throws LoginException {
		Account registeredAccount = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ILoginService iLoginService;

		try {
			iLoginService = (ILoginService) serviceFactory
					.getService(commandString);
			registeredAccount = iLoginService.registerSubscriber(subscriber);
		} catch (ServiceLoadException e1) {
			System.out.println("HelpDeskManager::registerSubscriber failed");
		}

		return registeredAccount;

	}

	/**
	 * Invokes appropriate service to login the customer
	 * 
	 * @param commandString
	 *            contains the service that needs to be performed
	 * @param account
	 *            contains the customer login information
	 * @return true if login information passed is valid false if login
	 *         information passed is invalid
	 */
	public boolean loginSubscriber(String commandString, Account account) {
		boolean isAuthenticated = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ILoginService iLoginService;

		try {
			iLoginService = (ILoginService) serviceFactory
					.getService(commandString);
			isAuthenticated = iLoginService.authenticateSubscriber(account);
		} catch (ServiceLoadException e1) {
			System.out.println("HelpDeskManager::login failed");
		} catch (LoginException e) {
			System.out.println("HelpDeskManager::login failed");
		}

		return isAuthenticated;
	}

	/**
	 * @param commandString
	 * @param ticket
	 * @return isCreated
	 * @throws IOException
	 */
	public boolean createNewTicket(String commandString, Ticket ticket)
			throws IOException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ITicketService iTicketService;
		boolean isCreated = false;

		try {
			iTicketService = (ITicketService) serviceFactory
					.getService(commandString);
			isCreated = iTicketService.storeTicket(ticket);
		} catch (ServiceLoadException e1) {
			System.out.println("HelpDeskManager::createNewTicket failed");
		}

		return isCreated;

	};

	/**
	 * @param commandString
	 * @param ticket
	 * @return isCreated
	 * @throws TicketException
	 */
	public boolean updateTicket(String commandString, Ticket ticket)
			throws TicketException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ITicketService iTicketService;
		boolean isCreated = false;

		try {
			iTicketService = (ITicketService) serviceFactory
					.getService(commandString);
			isCreated = iTicketService.updateTicket(ticket);
		} catch (ServiceLoadException e1) {
			System.out.println("HelpDeskManager::updateTicket failed");
		}

		return isCreated;

	};

}
