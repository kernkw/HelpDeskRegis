package com.helpdesk.model.domain;

import java.util.List;

public class Ticket{
	private Integer id;
	private String requester_username;
	private String requester_email;
	private String subject;
	private String text_response;
	private Integer text_response_number;
	private String created_at;
	private String updated_at;
	private Account account;
	private List<Account> accountList;
	private TicketStatus status;
	
	private enum TicketStatus {
		NEW, OPEN, PENDING, SOLVED, CLOSED
	}
	

	public Ticket() {
		super();
	}
	
	
	public Ticket(Integer id, String subject, String text_response,
			Integer text_response_number, String created_at, String updated_at,
			Account account, List<Account> accountList, TicketStatus status) {
		super();
		this.id = id;
		this.subject = subject;
		this.text_response = text_response;
		this.text_response_number = text_response_number;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.account = account;
		this.accountList = accountList;
		this.status = status;
		this.requester_username = account.getCustomerUsername();
		this.requester_email = account.getCustomerEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

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


	public String getRequester_username() {
		return requester_username;
	}

	public void setRequester_username(Account account) {
		this.requester_username = account.getCustomerUsername();
	}

	public String getRequester_email() {
		return requester_email;
	}

	public void setRequester_email(Account account) {
		this.requester_email = account.getCustomerEmail();
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText_response() {
		return text_response;
	}

	public void setText_response(String text_response) {
		this.text_response = text_response;
	}

	public Integer getText_response_number() {
		return text_response_number;
	}

	public void setText_response_number(Integer text_response_number) {
		this.text_response_number = text_response_number;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	
	public boolean validate () {
		 if (id == null) return false;
		 if (account == null) return false;
		 if (requester_username == null) return false;
		 if (requester_email == null) return false;
		 if (subject == null) return false;
		 if (text_response == null) return false;
		 if (text_response_number == null) return false;
		 if (created_at == null) return false;
		 if (updated_at == null) return false;
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
				+ ((created_at == null) ? 0 : created_at.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((requester_email == null) ? 0 : requester_email.hashCode());
		result = prime
				* result
				+ ((requester_username == null) ? 0 : requester_username
						.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result
				+ ((text_response == null) ? 0 : text_response.hashCode());
		result = prime
				* result
				+ ((text_response_number == null) ? 0 : text_response_number
						.hashCode());
		result = prime * result
				+ ((updated_at == null) ? 0 : updated_at.hashCode());
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
		if (created_at == null) {
			if (other.created_at != null)
				return false;
		} else if (!created_at.equals(other.created_at))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (requester_email == null) {
			if (other.requester_email != null)
				return false;
		} else if (!requester_email.equals(other.requester_email))
			return false;
		if (requester_username == null) {
			if (other.requester_username != null)
				return false;
		} else if (!requester_username.equals(other.requester_username))
			return false;
		if (status != other.status)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (text_response == null) {
			if (other.text_response != null)
				return false;
		} else if (!text_response.equals(other.text_response))
			return false;
		if (text_response_number == null) {
			if (other.text_response_number != null)
				return false;
		} else if (!text_response_number.equals(other.text_response_number))
			return false;
		if (updated_at == null) {
			if (other.updated_at != null)
				return false;
		} else if (!updated_at.equals(other.updated_at))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", requester_username="
				+ requester_username + ", requester_email=" + requester_email
				+ ", subject=" + subject + ", text_response=" + text_response
				+ ", text_response_number=" + text_response_number
				+ ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", account=" + account + ", accountList=" + accountList
				+ ", status=" + status + "]";
	}

}
