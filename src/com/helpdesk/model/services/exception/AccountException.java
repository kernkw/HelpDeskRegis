package com.helpdesk.model.services.exception;

/**
 * @author Kyle Kern
 *
 */
public class AccountException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param inMessage
	 */
	public AccountException(final String inMessage)
	{
		super(inMessage);
	}


	/**
	 * @param inMessage
	 * @param inNestedException
	 */
	public AccountException(final String inMessage, final Throwable inNestedException)
	{
		super(inMessage, inNestedException);
	}

}
