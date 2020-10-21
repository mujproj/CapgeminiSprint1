package com.cg.mts.dao;

import com.cg.mts.entities.Cab;
import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.repository.ICabRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.EntityManager;
import java.util.List;

public class CabDao implements ICabRepository {

    private final EntityManager entityManager;

    public CabDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Cab insertCab(Cab cab) {
        entityManager.persist(cab);
        return cab;
    }

    @Override
    public Cab updateCab(Cab cab) throws CabNotFoundException {

        Boolean success = checkExists(cab.getCabId());

        if (!success) {
            throw new CabNotFoundException("No cab found");
        }

        cab = entityManager.merge(cab);

        return cab;
    }


    @Override
    public Cab deleteCab(Cab cab) throws CabNotFoundException {

        boolean success = checkExists(cab.getCabId());
        if (!success) {
            throw new CabNotFoundException("No cab found");
        }

        entityManager.remove(cab);

        return cab;
    }

    @Override
    public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {

        List<Cab> listOfCabs = entityManager.createNamedQuery("Find cabs from cars", Cab.class).setParameter("cartype", carType).getResultList();

        if (listOfCabs.size() == 0) {
            throw new CabNotFoundException("No Cabs Found For Matching type");
        }

        return listOfCabs;
    }

    @Override
    public int countCabsOfType(String carType) throws CabNotFoundException {
        long count = (Long) entityManager.createNamedQuery("find cabs from cartype").setParameter("cartype", carType).getSingleResult();
        int cnt = (int) count;
        if (count == 0) {
            throw new CabNotFoundException("Cab of the type " + carType + " not found");
        }
        return cnt;
    }


    private Boolean checkExists(int cabId) {
        Cab cab = entityManager.find(Cab.class, cabId);
        boolean result = cab != null;
        return result;
    }
}