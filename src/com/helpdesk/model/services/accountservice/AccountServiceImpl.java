package com.helpdesk.model.services.accountservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import com.helpdesk.model.domain.Account;
import com.helpdesk.model.services.exception.AccountException;


/**
 * @author Kyle Kern
 *
 */

public class AccountServiceImpl implements IAccountService {
	private Integer accountNumber;
	private Hashtable<Integer, Account> h = new Hashtable<Integer, Account>();
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Boolean containsKey = false;

	public void storeAccount(Account account) throws IOException {		
		accountNumber = account.getAccountNumber();

		h.put(accountNumber,account);

		try {
			output = new ObjectOutputStream(new FileOutputStream("accountHashtable.ser"));
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

	}

	@SuppressWarnings("unchecked")
	public boolean updateAccount(Account account) throws AccountException {
		accountNumber = account.getAccountNumber();

		try{
			input = new ObjectInputStream (new FileInputStream("accountHashtable.ser"));

			// Returns hash table from the file
			h = (Hashtable<Integer, Account>)input.readObject();
			input.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File containing registered users not found!");
			throw new AccountException ("File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			System.out.println ("IOException while accessing file containing registered users!");
			throw new AccountException ("IOException while accessing file containing registered users!", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException while reading file containing registered users!");
			throw new AccountException ("ClassNotFoundException while reading file containing registered users!", cnfe);
		}
		finally{
			// Checks if hash table contains accountNumber
			if (h != null) {
				containsKey = h.containsKey(accountNumber);
				if (containsKey) {
					h.put(accountNumber, account);

					try {
						output = new ObjectOutputStream(new FileOutputStream("accountHashtable.ser"));
						output.writeObject(h);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						} 
					}
				}
			}
		}
		return containsKey;
	}

	@SuppressWarnings("unchecked")
	public Account getAccount(int accountNumber) {
		Account returnedAccount = null;

		try{
			FileInputStream fileIn = new FileInputStream("accountHashtable.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);

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
				containsKey = h.containsKey(accountNumber);
				if (containsKey) {
					returnedAccount = h.get(accountNumber);

					try {
						output = new ObjectOutputStream(new FileOutputStream("accountHashtable.ser"));
						output.writeObject(h);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						} 
					}
				}
			}
		}

		return returnedAccount;
	}


	/**
	 * @param accountNumber
	 * @return Boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean removeAccount(int accountNumber) {
		try{
			FileInputStream fileIn = new FileInputStream("accountHashtable.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);

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
				containsKey = h.containsKey(accountNumber);
				if (containsKey) {
					h.remove(accountNumber);
					try {
						output = new ObjectOutputStream(new FileOutputStream("accountHashtable.ser"));
						output.writeObject(h);
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							output.close();
						} catch (IOException e) {
							e.printStackTrace();
						} 
					}
				}
			}
		}
		return containsKey;
	}

}
