/**
 * 
 */
package com.helpdesk.model.services.loginservice;

import com.helpdesk.model.domain.Subscriber;

/**
 * @author sendgrid1
 *
 */
public class LoginServiceImpl implements ILoginService{

	public boolean authenticateSubscriber(Subscriber subscriber) {
		System.out.println ("Entering method LoginServiceImpl::authenticateSubscriber");
		return true;
	}
}
