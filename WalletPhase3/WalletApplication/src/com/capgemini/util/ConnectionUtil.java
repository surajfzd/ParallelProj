package com.capgemini.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionUtil 
{
	public static EntityManager getConnection()
	{
		try
		{
			EntityManagerFactory emfactory= Persistence.createEntityManagerFactory("CustomerTable");
			EntityManager entitymanager=emfactory.createEntityManager();
			return entitymanager;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

}
