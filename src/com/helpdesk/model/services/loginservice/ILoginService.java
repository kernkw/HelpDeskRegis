
package com.helpdesk.model.services.loginservice;

import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;
import com.helpdesk.model.services.IService;
import com.helpdesk.model.services.exception.LoginException;

/**
 * Validates if the subscriber is has a registered account.
 * 
 * @author Kyle Kern
 *
 */
public interface ILoginService extends IService{
	/**
	 * 
	 */
	public final String NAME = "ILoginService";

	/**
	 * @param subscriber
	 * @return Subscriber
	 */
	public Account registerSubscriber(Subscriber subscriber);
	/**
	 * @param account 
	 * @return true
	 * @throws LoginException 
	 */
	public boolean authenticateSubscriber(Account account) throws LoginException;

}
