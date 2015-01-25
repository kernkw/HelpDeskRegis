/**
 * 
 */
package com.helpdesk.model.services.accountservice;

import com.helpdesk.model.domain.Account;


/**
 * @author sendgrid1
 *
 */
public class AccountServiceImpl implements IAccountService {

	public void storeAccount(Account account) {
		System.out.println ("Entering method IAccountServiceImpl::storeAccount");
	}

	public boolean updateAccount(Account account) {
		System.out.println ("Entering method IAccountServiceImpl::updateAccount");
		return true;
	}

	public Account getAccount(int accountNumber) {
		System.out.println ("Entering method IAccountServiceImpl::getAccount");
		return new Account();
	}

	public boolean removeAccount(Account account) {
		System.out.println ("Entering method IAccountServiceImpl::removeAccount");
		return true;
	}

}
