package com.helpdesk.model.business.manager;

import com.helpdesk.model.business.exception.PropertyFileNotFoundException;
import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.services.manager.PropertyManager;

/**
 * @author Kyle Kern
 * 
 */
public abstract class ManagerSuperType {

	static {
		try {
			ManagerSuperType.loadProperties();
		} catch (PropertyFileNotFoundException propertyFileNotFoundException) {
			System.out
					.println("Application Properties failed to be loaded - Application exiting...");
			System.exit(1);
		}
	}

	/**
	 * Generic method that all clients of this class can call to perform certain
	 * actions.
	 * 
	 * @param commandString
	 *            Holds the service name to be invoked
	 * @param subscriber
	 * @param account
	 * @param ticket
	 * @return false if action failed true if action is successful
	 */
	public abstract boolean performAction(String commandString,
			Subscriber subscriber, Account account, Ticket ticket);

	/**
	 * Loads the property file into memory so its available for use by all tiers
	 * (business and below)
	 * 
	 * @throws PropertyFileNotFoundException
	 *             Properties file could not be loaded.
	 */
	public static void loadProperties() throws PropertyFileNotFoundException {
		String propertyFileLocation = System.getProperty("prop_location");

		if (propertyFileLocation != null) {
			PropertyManager.loadProperties(propertyFileLocation);
		} else {
			System.out
					.println("Property file location not set. Passed in value is: "
							+ propertyFileLocation + ".");
			throw new PropertyFileNotFoundException(
					"Property file location not set", null);
		}

	}

}
