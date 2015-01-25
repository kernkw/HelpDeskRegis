/**
 * 
 */
package com.helpdesk.model.services.factory;

import com.helpdesk.model.services.accountservice.IAccountService;
import com.helpdesk.model.services.accountservice.IAccountServiceImpl;
import com.helpdesk.model.services.loginservice.ILoginService;
import com.helpdesk.model.services.loginservice.ILoginServiceImpl;
import com.helpdesk.model.services.ticketservice.ITicketService;
import com.helpdesk.model.services.ticketservice.ITicketServiceImpl;

/**
 * @author sendgrid1
 *
 */
public class ServiceFactory {
	

	/**
	 * @return new ILoginServiceImpl();
	 */
	public ILoginService getLoginService()
	   {
	      return new ILoginServiceImpl();
	   }
	
	/**
	 * @return new IAccountServiceImpl();
	 */
	public IAccountService getAccountService()
	   {
	      return new IAccountServiceImpl();
	   }
	
	/**
	 * @return new ITicketServiceImpl();
	 */
	public ITicketService getTicketService()
	   {
	      return new ITicketServiceImpl();
	   }
	
}
