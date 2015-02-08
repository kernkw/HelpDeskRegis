package com.helpdesk.model.services.loginservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import junit.framework.TestCase;

import com.helpdesk.model.business.exception.ServiceLoadException;
import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.services.exception.LoginException;
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

		serviceFactory = ServiceFactory.getInstance();

		subscriber = new Subscriber ("Firstname", "Lastname", "PhoneNumber", 
				"username", "password","email@address.com");
		
	}
	/**
	 * Test method for {@link com.helpdesk.model.services.loginservice.LoginServiceImpl#registerSubscriber(Subscriber)}.
	 * @throws LoginException 
	 */
	public final void testRegisterSubscriber() throws LoginException {
		ILoginService loginService;
		try {
			loginService = (ILoginService) serviceFactory.getService(ILoginService.NAME);
			loginService.registerSubscriber(subscriber);      
			System.out.println("testRegisterSubscriber PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}

	}

	/**
	 * Test method for {@link com.helpdesk.model.services.loginservice.LoginServiceImpl#authenticateSubscriber(com.helpdesk.model.domain.Account)}.
	 * @throws LoginException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public final void testAuthenticateSubscriber() throws LoginException, FileNotFoundException, IOException, ClassNotFoundException {
		ILoginService loginService;
		Account storedAccount;
		try {
			loginService = (ILoginService) serviceFactory.getService(ILoginService.NAME);
			storedAccount = loginService.registerSubscriber(subscriber);  
			loginService.authenticateSubscriber(storedAccount);

			System.out.println("testStoreAccount PASSED");
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}

	}

}
