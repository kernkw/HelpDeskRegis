package com.helpdesk.model.services.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.helpdesk.model.services.accountservice.AccountServiceImpl;
import com.helpdesk.model.services.accountservice.IAccountService;
import com.helpdesk.model.services.factory.ServiceFactory;
import com.helpdesk.model.services.loginservice.ILoginService;
import com.helpdesk.model.services.loginservice.LoginServiceImpl;
import com.helpdesk.model.services.ticketservice.ITicketService;
import com.helpdesk.model.services.ticketservice.TicketServiceImpl;

/**
 * @author Kyle Kern
 *
 */
public class ServiceFactoryTest {

	ServiceFactory serviceFactory;
	
	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		serviceFactory = new ServiceFactory();
	}


    /**
     * Test Factory to return the loginservice and assert it by 
     * checking it is an instance of LoginServiceImpl
     * 
     * This should be true since LoginServiceImpl implements ILoginService
     */
	@Test	
	public void testGetLoginService() {
 		ILoginService loginService = (ILoginService)serviceFactory.getLoginService();
  	    assertTrue(loginService instanceof LoginServiceImpl);
  	    System.out.println("testGetLoginService PASSED");
	}
	
	/**
	 * 
	 */
	@Test	
	public void testGetAccountService() {
 		IAccountService accountService = (IAccountService)serviceFactory.getAccountService();
  	    assertTrue(accountService instanceof AccountServiceImpl);
  	  System.out.println("testGetAccountService PASSED");
	}
	
	/**
	 * 
	 */
	@Test	
	public void testGetTicketService() {
 		ITicketService ticketService = (ITicketService)serviceFactory.getTicketService();
  	    assertTrue(ticketService instanceof TicketServiceImpl);
  	    System.out.println("testGetTicketService PASSED");
	}

}
