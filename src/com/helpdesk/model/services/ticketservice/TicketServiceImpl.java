package com.helpdesk.model.services.ticketservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.services.exception.TicketException;

/**
 * @author Kyle Kern
 *
 */
public class TicketServiceImpl implements ITicketService{
	private Integer ticketNumber;
	private Hashtable<Integer, Ticket> h = new Hashtable<Integer, Ticket>();
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Boolean containsKey = false;

	public boolean storeTicket(Ticket ticket) throws IOException{
		ticketNumber = ticket.getTicketNumber();
		boolean isCreated = false;
		h.put(ticketNumber,ticket);

		try {
			output = new ObjectOutputStream(new FileOutputStream("ticketHashtable.ser"));
			output.writeObject(h);
			isCreated = true;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally{
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return isCreated;
	}

	@SuppressWarnings("unchecked")
	public boolean updateTicket(Ticket ticket) throws TicketException {
		ticketNumber = ticket.getTicketNumber();

		try{
			input = new ObjectInputStream (new FileInputStream("ticketHashtable.ser"));

			// Returns hash table from the file
			h = (Hashtable<Integer, Ticket>)input.readObject();
			input.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File containing registered users not found!");
			throw new TicketException ("File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			System.out.println ("IOException while accessing file containing registered users!");
			throw new TicketException ("IOException while accessing file containing registered users!", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException while reading file containing registered users!");
			throw new TicketException ("ClassNotFoundException while reading file containing registered users!", cnfe);
		}
		finally{
			// Checks if hash table contains accountNumber
			if (h != null) {
				containsKey = h.containsKey(ticketNumber);
				if (containsKey) {
					h.put(ticketNumber, ticket);

					try {
						output = new ObjectOutputStream(new FileOutputStream("ticketHashtable.ser"));
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
	public Ticket getTicket(int ticketNumber) {
		Ticket returnedAccount = null;

		try{
			FileInputStream fileIn = new FileInputStream("ticketHashtable.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Returns hash table from the file
			h = (Hashtable<Integer, Ticket>)in.readObject();
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
				containsKey = h.containsKey(ticketNumber);
				if (containsKey) {
					returnedAccount = h.get(ticketNumber);

					try {
						output = new ObjectOutputStream(new FileOutputStream("ticketHashtable.ser"));
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
	@SuppressWarnings("unchecked")
	public boolean removeTicket(int ticketNumber) {
		try{
			FileInputStream fileIn = new FileInputStream("ticketHashtable.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Returns hash table from the file
			h = (Hashtable<Integer, Ticket>)in.readObject();
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
				containsKey = h.containsKey(ticketNumber);
				if (containsKey) {
					h.remove(ticketNumber);
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
