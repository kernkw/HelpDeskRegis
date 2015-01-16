package com.helpdesk.model.domain;

/**
 * @author Kyle Kern
 *
 */
public class Subscriber{

	private String firstname;
	private String lastname;
	private String telephone;
	private String username;
	private String password;
	private String email;
	
		
	/**
	 * @author Kyle Kern
	 */
	public Subscriber() {
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param telephone
	 * @param username
	 * @param password
	 * @param email
	 */
	public Subscriber(String firstname, String lastname,
			String telephone, String username, String password, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param c_firstname
	 */
	public void setFirstname(String c_firstname) {
		this.firstname = c_firstname;
	}

	/**
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return true
	 */
	public boolean validate () {		
		 if (firstname == null) return false;
		 if (lastname == null) return false;
		 if (username == null) return false;
		 if (password == null) return false;
		 if (email == null) return false;
		 if (telephone == null) return false;
		
		 return true; 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		Subscriber other = (Subscriber) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [firstname=" + firstname + ", lastname=" + lastname
				+ ", telephone=" + telephone + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}

	
}