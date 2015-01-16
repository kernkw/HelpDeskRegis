package com.helpdesk.model.domain;

import java.util.List;

/**
 * @author Kyle Kern
 *
 */
public class TicketQueue {
	private String name;
	private List<Ticket> ticketList;
	private List<Ticket.TicketStatus> ticketStatusList;	
	
	/**
	 * 
	 */
	public TicketQueue() {
	}
	
	/**
	 * @param name
	 * @param ticketList
	 * @param ticketStatusList
	 */
	public TicketQueue(String name, List<Ticket> ticketList,
			List<Ticket.TicketStatus> ticketStatusList) {
		super();
		this.name = name;
		this.ticketList = ticketList;
		this.ticketStatusList = ticketStatusList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the ticketStatusList
	 */
	public List<Ticket.TicketStatus> getTicketStatusList() {
		return ticketStatusList;
	}
	/**
	 * @param ticketStatusList the ticketStatusList to set
	 */
	public void setTicketStatusList(List<Ticket.TicketStatus> ticketStatusList) {
		this.ticketStatusList = ticketStatusList;
	}
	
	/**
	 * @return true
	 */
	public boolean validate () {
		 if (name == null) return false;
		 if (ticketList == null) return false;
		 if (ticketStatusList == null) return false;

		 return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((ticketList == null) ? 0 : ticketList.hashCode());
		result = prime
				* result
				+ ((ticketStatusList == null) ? 0 : ticketStatusList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketQueue other = (TicketQueue) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ticketList == null) {
			if (other.ticketList != null)
				return false;
		} else if (!ticketList.equals(other.ticketList))
			return false;
		if (ticketStatusList == null) {
			if (other.ticketStatusList != null)
				return false;
		} else if (!ticketStatusList.equals(other.ticketStatusList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TicketQueue [name=" + name + ", ticketList=" + ticketList
				+ ", ticketStatusList=" + ticketStatusList + "]";
	}
	

}
