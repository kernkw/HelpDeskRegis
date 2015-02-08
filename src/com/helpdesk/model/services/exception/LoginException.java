package com.helpdesk.model.services.exception;

/**
 * @author Kyle Kern
 *
 */
public class LoginException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param inMessage
	 */
	public LoginException(final String inMessage)
	{
		super(inMessage);
	}


	/**
	 * @param inMessage
	 * @param inNestedException
	 */
	public LoginException(final String inMessage, final Throwable inNestedException)
	{
		super(inMessage, inNestedException);
	}

}
