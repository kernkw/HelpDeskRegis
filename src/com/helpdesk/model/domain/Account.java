package com.helpdesk.model.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author Kyle Kern
 *
 */
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2288627077430341557L;
	private Boolean admin;
	private Subscriber subscriber;
	private Ticket ticket;
	private TicketQueue ticketQueue;
	private List<Ticket> ticketList;
	private List<TicketQueue> ticketQueueList;
	
	/**
	 * 
	 */
	public Account() {
	}

	/**
	 * @param admin
	 * @param subscriber
	 * @param ticket
	 * @param ticketQueue
	 * @param ticketList
	 * @param ticketQueueList
	 */
	public Account(boolean admin, Subscriber subscriber, Ticket ticket,
			TicketQueue ticketQueue, List<Ticket> ticketList,
			List<TicketQueue> ticketQueueList) {
		super();
		this.admin = admin;
		this.subscriber = subscriber;
		this.ticket = ticket;
		this.ticketQueue = ticketQueue;
		this.ticketList = ticketList;
		this.ticketQueueList = ticketQueueList;
	}
	
	/**
	 * @return subscriber
	 */
	public Subscriber getSubscriber() {
		return subscriber;
	}
	
	/**
	 * @param subscriber
	 */
	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	/**
	 * @return the ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the ticketList
	 */
	public List<Ticket> getTicketList() {
		return ticketList;
	}

	/**
	 * @param ticketList the ticketList to set
	 */
	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	/**
	 * @return the ticketQueue
	 */
	public TicketQueue getTicketQueue() {
		return ticketQueue;
	}

	/**
	 * @param ticketQueue the ticketQueue to set
	 */
	public void setTicketQueue(TicketQueue ticketQueue) {
		this.ticketQueue = ticketQueue;
	}

	/**
	 * @return the ticketQueueList
	 */
	public List<TicketQueue> getTicketQueueList() {
		return ticketQueueList;
	}

	/**
	 * @param ticketQueueList the ticketQueueList to set
	 */
	public void setTicketQueueList(List<TicketQueue> ticketQueueList) {
		this.ticketQueueList = ticketQueueList;
	}

	/**
	 * @return admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	/**
	 * @return true
	 */
	public boolean validate () {
		if (admin == null) return false;
		 return true; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (admin ? 1231 : 1237);
		result = prime * result
				+ ((subscriber == null) ? 0 : subscriber.hashCode());
		result = prime * result + ((ticket == null) ? 0 : ticket.hashCode());
		result = prime * result
				+ ((ticketList == null) ? 0 : ticketList.hashCode());
		result = prime * result
				+ ((ticketQueue == null) ? 0 : ticketQueue.hashCode());
		result = prime * result
				+ ((ticketQueueList == null) ? 0 : ticketQueueList.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (admin != other.admin)
			return false;
		if (subscriber == null) {
			if (other.subscriber != null)
				return false;
		} else if (!subscriber.equals(other.subscriber))
			return false;
		if (ticket == null) {
			if (other.ticket != null)
				return false;
		} else if (!ticket.equals(other.ticket))
			return false;
		if (ticketList == null) {
			if (other.ticketList != null)
				return false;
		} else if (!ticketList.equals(other.ticketList))
			return false;
		if (ticketQueue == null) {
			if (other.ticketQueue != null)
				return false;
		} else if (!ticketQueue.equals(other.ticketQueue))
			return false;
		if (ticketQueueList == null) {
			if (other.ticketQueueList != null)
				return false;
		} else if (!ticketQueueList.equals(other.ticketQueueList))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [admin=" + admin + ", subscriber=" + subscriber
				+ ", ticket=" + ticket + ", ticketQueue=" + ticketQueue
				+ ", ticketList=" + ticketList + ", ticketQueueList="
				+ ticketQueueList + "]";
	}


}
