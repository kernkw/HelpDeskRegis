package com.helpdesk.model.services.exception;

/**
 * @author Kyle Kern
 *
 */
public class TicketException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param inMessage
	 */
	public TicketException(final String inMessage)
	{
		super(inMessage);
	}


	/**
	 * @param inMessage
	 * @param inNestedException
	 */
	public TicketException(final String inMessage, final Throwable inNestedException)
	{
		super(inMessage, inNestedException);
	}

}
