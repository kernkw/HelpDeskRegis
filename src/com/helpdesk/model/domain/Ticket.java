package com.helpdesk.model.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author Kyle Kern
 *
 */
public class Ticket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5070556440314088350L;
	private String subject;
	private String textResponse;
	private Integer textResponseNumber;
	private String createdAt;
	private String updatedAt;
	private Account account;
	private List<Account> accountList;
	private TicketStatus status;
	
	/**
	 * @author Kyle Kern
	 *
	 */
	public enum TicketStatus {
		/** Initial status of newly created ticket */
		NEW, 
		/** Once Agent responded set to open */
		OPEN, 
		/** When Agent is waiting for customer to reply */
		PENDING, 
		/** Ticket has been marked complete, can be reopened */
		SOLVED, 
		/** Ticket has been marked complete, can't be reopened */
		CLOSED
	}
	
	/**
	 * 
	 */
	public Ticket() {
	}
	
	/**
	 * @param subject
	 * @param textResponse
	 * @param textResponseNumber
	 * @param createdAt
	 * @param updatedAt
	 * @param account
	 * @param accountList
	 * @param status
	 */
	public Ticket(String subject, String textResponse,
			Integer textResponseNumber, String createdAt, String updatedAt,
			Account account, List<Account> accountList, TicketStatus status) {
		super();
		this.subject = subject;
		this.textResponse = textResponse;
		this.textResponseNumber = textResponseNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.account = account;
		this.accountList = accountList;
		this.status = status;
	}

	/**
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the accountList
	 */
	public List<Account> getAccountList() {
		return accountList;
	}


	/**
	 * @param accountList the accountList to set
	 */
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	/**
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the textResponse
	 */
	public String getTextResponse() {
		return textResponse;
	}

	/**
	 * @param textResponse the textResponse to set
	 */
	public void setTextResponse(String textResponse) {
		this.textResponse = textResponse;
	}

	/**
	 * @return the textResponseNumber
	 */
	public Integer getTextResponseNumber() {
		return textResponseNumber;
	}

	/**
	 * @param textResponseNumber the textResponseNumber to set
	 */
	public void setTextResponseNumber(Integer textResponseNumber) {
		this.textResponseNumber = textResponseNumber;
	}

	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public String getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return status
	 */
	public TicketStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	/**
	 * @return true
	 */
	public boolean validate () {
		 if (account == null) return false;
		 if (subject == null) return false;
		 if (textResponse == null) return false;
		 if (textResponseNumber == null) return false;
		 if (createdAt == null) return false;
		 if (updatedAt == null) return false;
		 if (status == null) return false;
		 
		 return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result
				+ ((accountList == null) ? 0 : accountList.hashCode());
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((textResponse == null) ? 0 : textResponse.hashCode());
		result = prime
				* result
				+ ((textResponseNumber == null) ? 0 : textResponseNumber
						.hashCode());
		result = prime * result
				+ ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		Ticket other = (Ticket) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (accountList == null) {
			if (other.accountList != null)
				return false;
		} else if (!accountList.equals(other.accountList))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (status != other.status)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (textResponse == null) {
			if (other.textResponse != null)
				return false;
		} else if (!textResponse.equals(other.textResponse))
			return false;
		if (textResponseNumber == null) {
			if (other.textResponseNumber != null)
				return false;
		} else if (!textResponseNumber.equals(other.textResponseNumber))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [subject=" + subject + ", textResponse=" + textResponse
				+ ", textResponseNumber=" + textResponseNumber + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", account="
				+ account + ", accountList=" + accountList + ", status="
				+ status + "]";
	}

}
