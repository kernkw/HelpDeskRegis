/**
 * 
 */
package com.helpdesk.model.services.loginservice;

import com.helpdesk.model.domain.Subscriber;

/**
 * @author sendgrid1
 *
 */
public interface ILoginService {
	/**
	 * @param subscriber
	 * @return true
	 */
	public boolean authenticateSubscriber(Subscriber subscriber);

}
