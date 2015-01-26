package com.helpdesk.model.services.factory;

import com.helpdesk.model.services.accountservice.AccountServiceImpl;
import com.helpdesk.model.services.accountservice.IAccountService;
import com.helpdesk.model.services.loginservice.ILoginService;
import com.helpdesk.model.services.loginservice.LoginServiceImpl;
import com.helpdesk.model.services.ticketqueueservice.ITicketQueueService;
import com.helpdesk.model.services.ticketqueueservice.TicketQueueServiceImpl;
import com.helpdesk.model.services.ticketservice.ITicketService;
import com.helpdesk.model.services.ticketservice.TicketServiceImpl;

/**
 * @author Kyle Kern
 *
 */
public class ServiceFactory {
	

	/**
	 * @return new ILoginServiceImpl();
	 */
	public ILoginService getLoginService()
	   {
	      return new LoginServiceImpl();
	   }
	
	/**
	 * @return new IAccountServiceImpl();
	 */
	public IAccountService getAccountService()
	   {
	      return new AccountServiceImpl();
	   }
	
	/**
	 * @return new ITicketServiceImpl();
	 */
	public ITicketService getTicketService()
	   {
	      return new TicketServiceImpl();
	   }
	
	/**
	 * @return new ITicketQueueServiceImpl();
	 */
	public ITicketQueueService getTicketQueueService()
	   {
	      return new TicketQueueServiceImpl();
	   }
	
}
