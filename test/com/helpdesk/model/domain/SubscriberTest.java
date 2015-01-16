package com.helpdesk.model.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Kyle Kern
 *
 */
public class SubscriberTest {
	
	private Subscriber subscriber1, subscriber2, subscriber;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

		subscriber1 = new Subscriber ("Firstname", "Lastname", "PhoneNumber", 
									  "username", "password","email@address.com");
		
		subscriber2 = new Subscriber ("Firstname", "Lastname", "PhoneNumber", 
									  "username", "password","email@address.com");
	}

	/**
	 * Test method for {@link com.helpdesk.model.domain.Subscriber#validate()}.
	 * Tests with a valid subscriber passed in
	 */
	@Test
	public final void testValidateSubscriber() {
		System.out.println("starting testValidateSubscriber()");
		// subscriber1.validate should assert to True since all variables 
		// being passed to create a new Subscriber are all valid.
		assertTrue ("subscriber validates", subscriber1.validate());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	 * Tests with an invalid subscriber passed in
	 */
	@Test
	public final void testNotValidateSubscriber() {
		subscriber = new Subscriber ();
		System.out.println("starting testNotValidateSubscriber()");
		// subscriber1.validate should assert to False since all variables 
		// being passed to create a new Subscriber are not present.
		assertFalse ("subscriber does not validates", subscriber.validate());
	       System.out.println("testNotValidate PASSED");
	}

	/**
	 * Test method for {@link com.helpdesk.model.domain.Subscriber#equals(com.helpdesk.model.domain.Subscriber)}.
	 * Tests if two subscribers are equal
	 */
	@SuppressWarnings("javadoc")
	@Test
	public final void testEqualsSubscriber() {
		System.out.println("starting testEqualsSubscriber()");
		// this should assert to true since the contents of 
		// subscriber1 and subscriber2 class variables are identical.
		assertTrue ("subscriber1 equals subscriber2", subscriber1.equals(subscriber2));
	    System.out.println("testEqualsSubscriber PASSED");		

	}
	/**
	 * Tests if two subscribers are not equal
	 */
	@Test
	public void testNotEqualsSubscriber() {
		System.out.println("starting testNotEqualsSubscriber()");
		subscriber = new Subscriber ("foo", "bar", "PhoneNumber", "username", "password","email@address.com");
		// this should assert to false since the contents of 
		// subscriber1 and subscriber2 class variables are NOT identical.
		assertFalse ("subscriber does NOT equal subscriber1", subscriber.equals(subscriber1));
	       System.out.println("testNotEqualsSubscriber PASSED");		
	}
}
