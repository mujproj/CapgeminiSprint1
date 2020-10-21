package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.mts.dao.DriverDao;
import com.cg.mts.dao.Util;
import com.cg.mts.entities.Driver;
import com.cg.mts.exception.DriverNotFoundException;
import com.cg.mts.repository.IDriverRepository;

public class DriverService implements IDriverService {


	private EntityManager em;
	EntityTransaction et;
	private IDriverRepository driverDao;

	public DriverService() {
		Util util = Util.getInstance();
		em = util.getEntityManager();
		et = em.getTransaction();
		driverDao = new DriverDao(em);
	}

	public Driver insertDriver(Driver driver) {
		et.begin();
		driver = driverDao.insertDriver(driver);
		et.commit();
		return driver;
	}

	public Driver updateDriver(Driver driver) {
		et.begin();
		try {
			driver = driverDao.updateDriver(driver);
		} catch (DriverNotFoundException e) {
			e.getMessage();
		}
		et.commit();
		return driver;
	}

	public Driver deleteDriver(int driverId) {
		et.begin();
		Driver driver = null;
		try {
			driver = driverDao.deleteDriver(driverId);
		} catch (DriverNotFoundException e) {
			e.getMessage();
		}
		et.commit();
		return driver;
	}

	public List<Driver> viewBestDrivers() {
		et.begin();
		List<Driver> bestDrivers = null;
		try {
			bestDrivers = driverDao.viewBestDrivers();
		} catch (DriverNotFoundException e) {
			e.getMessage();
		}
		et.commit();
		return bestDrivers;
	}

	public Driver viewDriver(int driverId) {
		et.begin();
		Driver driver = null;
		try {
			driver = driverDao.viewDriver(driverId);
		} catch (DriverNotFoundException e) {
			e.printStackTrace();
		}
		et.commit();
		return driver;
	}

}