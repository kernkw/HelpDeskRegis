/**
 * 
 */
package com.helpdesk.model.services.accountservice;

import com.helpdesk.model.domain.Account;

/**
 * @author sendgrid1
 *
 */
public interface IAccountService {
	
	/**
	 * @param account
	 */
	public void storeAccount(Account account);
	
	/**
	 * @param account
	 * @return true
	 */
	public boolean updateAccount(Account account);
	
	/**
	 * @param accountNumber
	 * @return accountNumber
	 */
	public Account getAccount(int accountNumber);
	
	/**
	 * @param account
	 * @return true 
	 */
	public boolean removeAccount(Account account);
	
	
}
