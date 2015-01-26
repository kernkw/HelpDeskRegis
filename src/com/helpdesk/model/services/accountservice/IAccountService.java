
package com.helpdesk.model.services.accountservice;

import com.helpdesk.model.domain.Account;

/**
 *  Performs actions need for account management
 *  
 * @author Kyle Kern
 *
 */
public interface IAccountService {
	
	/**
	 * Adds a new account in database
	 * 
	 * @param account
	 */
	public void storeAccount(Account account);
	
	/**
	 * Edits an existing account in database
	 * 
	 * @param account
	 * @return true
	 */
	public boolean updateAccount(Account account);
	
	/**
	 * Retrieves an account object given the account number
	 * 
	 * @param accountNumber
	 * @return accountNumber
	 */
	public Account getAccount(int accountNumber);
	
	/**
	 * Deletes an account from the database
	 * 
	 * @param account
	 * @return true 
	 */
	public boolean removeAccount(Account account);
	
	
}
