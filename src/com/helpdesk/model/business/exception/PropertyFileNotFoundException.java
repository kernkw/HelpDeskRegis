package com.helpdesk.model.business.exception;

/**
 * @author Kyle Kern
 *
 */
public class PropertyFileNotFoundException extends Exception
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param inMessage
	 * @param inNestedException
	 */
	public PropertyFileNotFoundException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
	
} // end class PropertyFileNotFoundException
