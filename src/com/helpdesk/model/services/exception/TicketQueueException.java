package com.helpdesk.model.services.exception;

/**
 * @author Kyle Kern
 *
 */
public class TicketQueueException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param inMessage
	 */
	public TicketQueueException(final String inMessage)
	{
		super(inMessage);
	}


	/**
	 * @param inMessage
	 * @param inNestedException
	 */
	public TicketQueueException(final String inMessage, final Throwable inNestedException)
	{
		super(inMessage, inNestedException);
	}

}
