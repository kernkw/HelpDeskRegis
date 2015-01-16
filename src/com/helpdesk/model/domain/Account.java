package com.helpdesk.model.domain;

import java.util.List;

public class Account{
	private Integer id;
	private boolean admin;
	private String customerUsername;
	private String customerEmail;
	private Customer customer;
	private Ticket ticket;
	private TicketQueue ticketQueue;
	private List<Ticket> ticketList;
	private List<TicketQueue> ticketQueueList;

	public Account() {
		super();
	}

	public Account(Integer id, boolean admin, String customerUsername,
			String customerEmail, Customer customer, Ticket ticket,
			TicketQueue ticketQueue, List<Ticket> ticketList,
			List<TicketQueue> ticketQueueList) {
		super();
		this.id = id;
		this.admin = admin;
		this.customerUsername = customerUsername;
		this.customerEmail = customerEmail;
		this.customer = customer;
		this.ticket = ticket;
		this.ticketQueue = ticketQueue;
		this.ticketList = ticketList;
		this.ticketQueueList = ticketQueueList;
	}

	public Account(Integer id, boolean admin, Customer customer, 
			Ticket ticket, List<Ticket> ticketList) {
		super();
		this.id = id;
		this.admin = admin;
		this.customer = customer;
		this.ticket = ticket;
		this.ticketList = ticketList;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(Customer customer) {
		this.customerEmail = customer.getEmail();
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public void setCustomerUsername(Customer customer) {
		this.customerUsername = customer.getUsername();
	}

	public String getCustomerUsername() {
		return customerUsername;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public boolean validate () {		
		 if (id == null) return false;
		 if (customer == null) return false;
		 
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
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result
				+ ((customerEmail == null) ? 0 : customerEmail.hashCode());
		result = prime
				* result
				+ ((customerUsername == null) ? 0 : customerUsername.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (customerEmail == null) {
			if (other.customerEmail != null)
				return false;
		} else if (!customerEmail.equals(other.customerEmail))
			return false;
		if (customerUsername == null) {
			if (other.customerUsername != null)
				return false;
		} else if (!customerUsername.equals(other.customerUsername))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Account [id=" + id + ", admin=" + admin + ", customerUsername="
				+ customerUsername + ", customerEmail=" + customerEmail
				+ ", customer=" + customer + ", ticket=" + ticket
				+ ", ticketQueue=" + ticketQueue + ", ticketList=" + ticketList
				+ ", ticketQueueList=" + ticketQueueList + "]";
	}


}
