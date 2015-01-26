package com.helpdesk.model.services.loginservice;

import com.helpdesk.model.domain.Subscriber;

/**
 *  Validates if the subscriber is has a registered account.
 *  
 * @author Kyle Kern
 *
 */
public class LoginServiceImpl implements ILoginService{
	/**
	 * @param subscriber contains registered username and password.
	 * @return true
	 */
	public boolean authenticateSubscriber(Subscriber subscriber) {
		System.out.println ("Entering method LoginServiceImpl::authenticateSubscriber");
		return true;
	}
}
