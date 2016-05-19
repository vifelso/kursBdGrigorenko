package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.DriverDAO;
import com.model.Drivers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Repository
public class DriverDAOImpl extends AbstractDAO<Integer,Drivers> implements DriverDAO{

    @Override
    @SuppressWarnings("unchecked")
    public List<Drivers> findAllDrivers() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public void addDriver(Drivers n) {
        persist(n);
    }

    @Override
    public void deleteDriverById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Drivers drivers = (Drivers)criteria.uniqueResult();
        delete(drivers);
    }

    @Override
    public void editDriver(Drivers driver) {
        getSession().merge(driver);
    }

    @Override
    public Drivers getById(int id) {
        return getByKey(id);
    }
}
