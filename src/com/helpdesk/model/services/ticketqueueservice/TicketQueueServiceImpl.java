package com.helpdesk.model.services.ticketqueueservice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.helpdesk.model.domain.Ticket;
import com.helpdesk.model.domain.TicketQueue;
import com.helpdesk.model.services.exception.TicketQueueException;

/**
 * @author Kyle Kern
 *
 */
public class TicketQueueServiceImpl implements ITicketQueueService {
	private Integer ticketQueueNumber;
	private Hashtable<Integer, TicketQueue> h = new Hashtable<Integer, TicketQueue>();
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private Boolean containsKey = false;
	private final String fileName = "ticketQueueHashtable.ser";
	private List<Ticket> ticketList = new ArrayList<Ticket>();;

	public void storeTicketQueue(TicketQueue ticketQueue) {		 
		ticketQueueNumber = ticketQueue.getTicketQueueNumber();

		h.put(ticketQueueNumber,ticketQueue);

		try {
			output = new ObjectOutputStream(new FileOutputStream(fileName));
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
	public boolean updateTicketQueue(TicketQueue ticketQueue) throws TicketQueueException {
		ticketQueueNumber = ticketQueue.getTicketQueueNumber();

		try{
			input = new ObjectInputStream (new FileInputStream(fileName));

			// Returns hash table from the file
			h = (Hashtable<Integer, TicketQueue>)input.readObject();
			input.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File containing registered users not found!");
			throw new TicketQueueException ("File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			System.out.println ("IOException while accessing file containing registered users!");
			throw new TicketQueueException ("IOException while accessing file containing registered users!", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException while reading file containing registered users!");
			throw new TicketQueueException ("ClassNotFoundException while reading file containing registered users!", cnfe);
		}
		finally{
			// Checks if hash table contains accountNumber
			if (h != null) {
				containsKey = h.containsKey(ticketQueueNumber);
				if (containsKey) {
					h.put(ticketQueueNumber, ticketQueue);

					try {
						output = new ObjectOutputStream(new FileOutputStream(fileName));
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
	public boolean addToTicketQueue(TicketQueue ticketQueue, Ticket ticket) throws TicketQueueException {

		try{
			input = new ObjectInputStream (new FileInputStream(fileName));

			// Returns hash table from the file
			h = (Hashtable<Integer, TicketQueue>)input.readObject();
			input.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println ("File containing registered users not found!");
			throw new TicketQueueException ("File containing registered users not found!", fnfe);
		} catch (IOException ioe) {
			System.out.println ("IOException while accessing file containing registered users!");
			throw new TicketQueueException ("IOException while accessing file containing registered users!", ioe);
		} catch (ClassNotFoundException cnfe) {
			System.out.println ("ClassNotFoundException while reading file containing registered users!");
			throw new TicketQueueException ("ClassNotFoundException while reading file containing registered users!", cnfe);
		}
		finally{
			// Checks if hash table contains accountNumber
			if (h != null) {
				ticketQueueNumber = ticketQueue.getTicketQueueNumber();
				containsKey = h.containsKey(ticketQueueNumber);
				if (containsKey) {
					try {
						ticketList.add(ticket);
						ticketQueue.setTicketList(ticketList);
						h.put(ticketQueueNumber,ticketQueue);
						output = new ObjectOutputStream(new FileOutputStream(fileName));
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
	public TicketQueue getTicketQueue(int ticketQueueNumber) {
		TicketQueue returnedTicketQueue = null;

		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Returns hash table from the file
			h = (Hashtable<Integer, TicketQueue>)in.readObject();
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
				containsKey = h.containsKey(ticketQueueNumber);
				if (containsKey) {
					returnedTicketQueue = h.get(ticketQueueNumber);

					try {
						output = new ObjectOutputStream(new FileOutputStream(fileName));
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

		return returnedTicketQueue;
	}

	@SuppressWarnings("unchecked")
	public boolean removeTicketQueue(int ticketQueueNumber) {
		try{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			// Returns hash table from the file
			h = (Hashtable<Integer, TicketQueue>)in.readObject();
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
				containsKey = h.containsKey(ticketQueueNumber);
				if (containsKey) {
					h.remove(ticketQueueNumber);
					try {
						output = new ObjectOutputStream(new FileOutputStream(fileName));
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
