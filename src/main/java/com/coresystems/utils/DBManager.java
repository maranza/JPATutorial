package com.coresystems.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {
	private EntityManagerFactory emFactory;

	public DBManager() {
		emFactory = Persistence.createEntityManagerFactory("jpatutorial");
	}
	/**
	 * This function will return an Entity Manager
	 * @return EntityManager
	 */
	public EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}
}
