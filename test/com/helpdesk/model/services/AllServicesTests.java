package com.helpdesk.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.helpdesk.model.services.factory.ServiceFactoryTest;
import com.helpdesk.model.services.accountservice.AccountServiceImplTest;
import com.helpdesk.model.services.loginservice.LoginServiceImplTest;
import com.helpdesk.model.services.ticketservice.TicketServiceImplTest;
import com.helpdesk.model.services.ticketqueueservice.TicketQueueServiceImplTest;

/**
 * @author Kyle Kern
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ ServiceFactoryTest.class, AccountServiceImplTest.class,
		LoginServiceImplTest.class, TicketServiceImplTest.class,
		TicketQueueServiceImplTest.class })
public class AllServicesTests {

}
