package com.helpdesk.model.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author sendgrid1
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ AccountTest.class, SubscriberTest.class, TicketQueueTest.class,
		TicketTest.class })
public class AllDomainTests {

}
