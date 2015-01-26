package com.helpdesk.model.services.loginservice;

import junit.framework.TestCase;

import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.services.factory.ServiceFactory;

/**
 * @author Kyle Kern
 *
 */
public class LoginServiceImplTest extends TestCase {

	private ServiceFactory serviceFactory;
	private Subscriber subscriber;

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();

		serviceFactory = new ServiceFactory();

		subscriber = new Subscriber ("Firstname", "Lastname", "PhoneNumber", 
				  "username", "password","email@address.com");

	}
	
	/**
	 * Test method for {@link com.helpdesk.model.services.loginservice.LoginServiceImpl#authenticateSubscriber(com.helpdesk.model.domain.Subscriber)}.
	 */
	public final void testAuthenticateSubscriber() {
		ILoginService loginService = (ILoginService)serviceFactory.getLoginService();
		assertTrue(loginService.authenticateSubscriber(subscriber));
        System.out.println("testAuthenticateSubscriber PASSED");
        
	}
	
}
