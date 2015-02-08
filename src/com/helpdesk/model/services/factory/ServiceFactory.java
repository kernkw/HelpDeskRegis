package com.helpdesk.model.services.factory;

import com.helpdesk.model.services.*;
import com.helpdesk.model.business.exception.ServiceLoadException;


/**
 * @author Kyle Kern
 *
 */
public class ServiceFactory {

	private ServiceFactory() {}
	private static ServiceFactory serviceFactory = new ServiceFactory();
	/**
	 * @return serviceFactory
	 */
	public static ServiceFactory getInstance() {return serviceFactory;}

	/**
	 * @param serviceName
	 * @return IService
	 * @throws ServiceLoadException
	 */
	public IService getService(String serviceName) throws ServiceLoadException
	{
		try 
		{
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService)c.newInstance();
		} catch (Exception excp) 
		{
			serviceName = serviceName + " not loaded";
			throw new ServiceLoadException(serviceName, excp);
		}
	}


	private String getImplName (String serviceName) throws Exception
	{

		java.util.Properties props = new java.util.Properties();

		String propertyFileLocation = System.getProperty("prop_location");

		System.out.println ("Property File Location passed : " + propertyFileLocation);
		java.io.FileInputStream inputStream = new java.io.FileInputStream(propertyFileLocation);

		props.load(inputStream);
		inputStream.close();
		return props.getProperty(serviceName);	    
	}
}
