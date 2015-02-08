package com.helpdesk.model.business.factory;

import junit.framework.TestCase;

import com.helpdesk.model.business.exception.ServiceLoadException;
import com.helpdesk.model.services.factory.ServiceFactory;
import com.helpdesk.model.services.loginservice.ILoginService;
import com.helpdesk.model.services.loginservice.LoginServiceImpl;
import com.helpdesk.model.services.ticketservice.ITicketService;

/**
 * @author Kyle Kern
 * 
 */
public class ServiceFactoryTest extends TestCase {

	ServiceFactory serviceFactory;

	public void setUp() throws Exception {
	}

	/**
	 * 
	 */
	public void testGetInstance() {
		assertNotNull(serviceFactory);
	}

	/**
	 * Test Factory to return the loginservice and assert it by checking it is
	 * an instance of LoginServiceImpl
	 * 
	 * This should be true since LoginServiceImpl implements ILoginService
	 */
	public void testGetLoginService() {
		ILoginService loginService;
		try {
			loginService = (ILoginService) serviceFactory
					.getService(ILoginService.NAME);
			assertTrue(loginService instanceof LoginServiceImpl);
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

	/**
	 * Test Factory to return the ticketservice and assert it by checking it is
	 * an instance of TicketServiceImpl
	 * 
	 * This should be true since TicketServiceImpl implements ITicketService
	 */
	public void testGetTicketService() {
		ITicketService ticketService;
		try {
			ticketService = (ITicketService) serviceFactory
					.getService(ITicketService.NAME);
			assertTrue(ticketService instanceof LoginServiceImpl);
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

}
