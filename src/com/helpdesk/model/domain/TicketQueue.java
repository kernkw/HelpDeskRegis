package com.helpdesk.model.domain;

import java.util.List;

public class TicketQueue {
	private Integer id;
	private String name;
	private List<Ticket> ticketList;
	private List<Ticket> ticketStatusList;	
	
	public TicketQueue() {
		super();
	}
	public TicketQueue(Integer id, String name, List<Ticket> ticketList,
			List<Ticket> ticketStatusList) {
		super();
		this.id = id;
		this.name = name;
		this.ticketList = ticketList;
		this.ticketStatusList = ticketStatusList;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public List<Ticket> getTicketStatusList() {
		return ticketStatusList;
	}
	/**
	 * @param ticketStatusList the ticketStatusList to set
	 */
	public void setTicketStatusList(List<Ticket> ticketStatusList) {
		this.ticketStatusList = ticketStatusList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((ticketList == null) ? 0 : ticketList.hashCode());
		result = prime
				* result
				+ ((ticketStatusList == null) ? 0 : ticketStatusList.hashCode());
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
		TicketQueue other = (TicketQueue) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketQueue [id=" + id + ", name=" + name + ", ticketList="
				+ ticketList + ", ticketStatusList=" + ticketStatusList + "]";
	}
	

}
