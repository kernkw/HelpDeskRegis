package com.helpdesk.model.services.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.helpdesk.model.business.exception.ServiceLoadException;
import com.helpdesk.model.services.accountservice.AccountServiceImpl;
import com.helpdesk.model.services.accountservice.IAccountService;
import com.helpdesk.model.services.factory.ServiceFactory;
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
public class ServiceFactoryTest {

	ServiceFactory serviceFactory;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();		
	}


	/**
	 * Test Factory to return the loginservice and assert it by 
	 * checking it is an instance of LoginServiceImpl
	 * 
	 * This should be true since LoginServiceImpl implements ILoginService
	 */
	@Test	
	public void testGetLoginService() {
		ILoginService loginService;
		try {
			loginService = (ILoginService)serviceFactory.getService(ILoginService.NAME);
			assertTrue(loginService instanceof LoginServiceImpl);
			System.out.println("testGetLoginService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	/**
	 * 
	 */
	@Test	
	public void testGetAccountService() {
		IAccountService accountService;
		try {
			accountService = (IAccountService)serviceFactory.getService(IAccountService.NAME);
			assertTrue(accountService instanceof AccountServiceImpl);
			System.out.println("testGetAccountService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	/**
	 * 
	 */
	@Test	
	public void testGetTicketService() {
		ITicketService ticketService;
		try {
			ticketService = (ITicketService)serviceFactory.getService(ITicketService.NAME);
			assertTrue(ticketService instanceof TicketServiceImpl);
			System.out.println("testGetTicketService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	/**
	 * 
	 */
	@Test	
	public void testGetTicketQueueService() {
		ITicketQueueService ticketQueueService;
		try {
			ticketQueueService = (ITicketQueueService)serviceFactory.getService(ITicketQueueService.NAME);
			assertTrue(ticketQueueService instanceof TicketQueueServiceImpl);
			System.out.println("testGetTicketQueueService PASSED");	  	    
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

}
