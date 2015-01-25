/**
 * 
 */
package com.helpdesk.model.services.accountservice;

import com.helpdesk.model.domain.Account;


/**
 * @author sendgrid1
 *
 */
public class IAccountServiceImpl implements IAccountService {

	public void storeAccount(Account account) {
		System.out.println ("Entering method IAccountServiceImpl::save");
	}

	public boolean update(Account account) {
		System.out.println ("Entering method IAccountServiceImpl::update");
		return true;
	}

	public Account getAccount(int accountNumber) {
		System.out.println ("Entering method IAccountServiceImpl::findByAccountNumber");
		return new Account();
	}

	public boolean remove(Account account) {
		System.out.println ("Entering method IAccountServiceImpl::remove");
		return true;
	}

}
