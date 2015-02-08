package com.helpdesk.model.services.loginservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import com.helpdesk.model.services.exception.LoginException;
import com.helpdesk.model.domain.Account;
import com.helpdesk.model.domain.Subscriber;

/**
 *  Validates if the subscriber is has a registered account.
 *  
 * @author Kyle Kern
 *
 */
public class LoginServiceImpl implements ILoginService{
	private Hashtable<Integer, Account> h = new Hashtable<Integer, Account>();
	private ObjectOutputStream output;

	/**
	 * @param subscriber 
	 * @return new Account
	 */

	public Account registerSubscriber(Subscriber subscriber) {
		Account newAccount = new Account();

		try {
			newAccount.setSubscriber(subscriber);
			Integer accountNumber = newAccount.getAccountNumber();
			h.put(accountNumber,newAccount);
			output = new ObjectOutputStream(new FileOutputStream("registeredHashtable.ser"));
			output.writeObject(h);

		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally{
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					//do something clever with the exception
				}
			}
		}
		return newAccount;
	}

	@SuppressWarnings("unchecked")
	public boolean authenticateSubscriber(Account account) throws LoginException {
		boolean isAuthenticated = false;
		Integer accountNumber;

		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("registeredHashtable.ser"));

			// Returns hash table from the file
			h = (Hashtable<Integer, Account>)in.readObject();
			in.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			// Checks if hash table contains accountNumber
			if (h != null) {
				accountNumber = account.getAccountNumber();
				Account savedAccount = h.get(accountNumber);

				if (savedAccount.getAccountNumber().equals(accountNumber)){
					isAuthenticated = true;
				}
				else {
					isAuthenticated = false;
				}


			}
		}

		return isAuthenticated;
	}
}
