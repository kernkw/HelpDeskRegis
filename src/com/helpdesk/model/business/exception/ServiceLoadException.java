package com.helpdesk.model.business.exception;

/**
 * @author Kyle Kern
 *
 */
@SuppressWarnings("serial")
public class ServiceLoadException extends Exception
{
	/**
	 * @param inMessage
	 * @param inNestedException
	 */
	public ServiceLoadException(final String inMessage, final Throwable inNestedException)
	{
		super(inMessage, inNestedException);
	}

}
