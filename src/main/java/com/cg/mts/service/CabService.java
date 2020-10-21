//package com.cg.mts.service;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//
//import com.cg.mts.dao.Util;
//import com.cg.mts.entities.Cab;
//
//public class CabService implements ICabService {
//
//	private EntityManager em;
//	EntityTransaction et;
//
//	public CabService() {
//		Util util = Util.getInstance();
//		em = util.getEntityManager();
//		et = em.getTransaction();
//	}
//
//	public Cab insertCab(Cab cab) {
//		et.begin();
//		em.persist(cab);
//		et.commit();
//		return cab;
//	}
//
//	public Cab updateCab(Cab cab) {
//		et.begin();
//		Cab cb = em.merge(cab);
//		et.commit();
//		return cb;
//	}
//
//	public Cab deleteCab(Cab cab) {
//		et.begin();
//		em.remove(cab);
//		et.commit();
//		return cab;
//	}
//
//	public List<Cab> viewCabsOfType(String carType) {
//		et.begin();
//		List<Cab> listOfCabs = em.createQuery("select * from cab where cartype = 'cartype'", Cab.class).setParameter("cartype", carType).getResultList();
//		et.commit();
//		return listOfCabs;
//	}
//
//	public int countCabsOfType(String carType) {
//		et.begin();
//		int count = (Integer) em.createQuery("Select count(*) from cab where cartype = 'cartype'").setParameter("cartype", carType).getSingleResult();
//		et.commit();
//		return count;
//	}
//
//}

package com.cg.mts.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.mts.dao.CabDao;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.repository.ICabRepository;
import com.cg.mts.util.Util;
import com.cg.mts.entities.Cab;

public class CabService implements ICabService {

	private ICabRepository cabDao;

	private final EntityManager entityManager;

	public CabService() {
		Util util = Util.getInstance();
		entityManager = util.getEntityManager();
		cabDao = new CabDao(entityManager);
	}

	public Cab insertCab(Cab cab) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		cab = cabDao.insertCab(cab);
		entityTransaction.commit();
		return cab;
	}

	public Cab updateCab(Cab cab) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			cab = cabDao.updateCab(cab);
		} catch (CabNotFoundException e) {
			System.out.println(e.getMessage());
		}
		entityTransaction.commit();
		return cab;
	}

	public Cab deleteCab(Cab cab) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			cab = cabDao.deleteCab(cab);
		} catch (CabNotFoundException e) {
			System.out.println(e.getMessage());
		}
		entityTransaction.commit();
		return cab;
	}

	public List<Cab> viewCabsOfType(String carType) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		List<Cab> listOfCabs = null;
		try {
			listOfCabs = cabDao.viewCabsOfType(carType);
		} catch (CabNotFoundException e) {
			System.out.println(e.getMessage());
		}
		entityTransaction.commit();
		return listOfCabs;
	}

	public int countCabsOfType(String carType) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
//		int count = (Integer) entityManager.createQuery("Select count(*) from cab where cartype = 'cartype'").setParameter("cartype", carType).getSingleResult();
		int count=0;
		try {
			count = cabDao.countCabsOfType(carType);
		} catch (CabNotFoundException e) {
			System.out.println(e.getMessage());
		}
		entityTransaction.commit();
		return count;
	}

}