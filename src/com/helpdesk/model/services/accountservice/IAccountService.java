
package com.helpdesk.model.services.accountservice;

import java.io.IOException;

import com.helpdesk.model.domain.Account;
import com.helpdesk.model.services.IService;
import com.helpdesk.model.services.exception.AccountException;

/**
 *  Performs actions need for account management
 *  
 * @author Kyle Kern
 *
 */
public interface IAccountService extends IService{

	/**
	 * 
	 */
	public final String NAME = "IAccountService";

	/**
	 * Adds a new account in database
	 * 
	 * @param account
	 * @throws IOException 
	 */
	public void storeAccount(Account account) throws IOException;

	/**
	 * Edits an existing account in database
	 * 
	 * @param account
	 * @return true
	 * @throws AccountException 
	 */
	public boolean updateAccount(Account account) throws AccountException;

	/**
	 * Retrieves an account object given the account number
	 * 
	 * @param accountNumber
	 * @return accountNumber
	 */
	public Account getAccount(int accountNumber);

	/**
	 * Deletes an account from the database
	 * @param accountNumber 
	 * 
	 * @return true 
	 */
	public boolean removeAccount(int accountNumber);


}
