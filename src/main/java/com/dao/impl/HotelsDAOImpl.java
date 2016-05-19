package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.HotelsDAO;
import com.model.Hotels;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Repository
public class HotelsDAOImpl extends AbstractDAO<Integer,Hotels> implements HotelsDAO{
    @Override
    @SuppressWarnings("unchecked")
    public List<Hotels> findAllHotels() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public void addHotels(Hotels n) {
        persist(n);
    }

    @Override
    public void deleteHotelsById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Hotels hotel = (Hotels)criteria.uniqueResult();
        delete(hotel);
    }

    @Override
    public void editHotels(Hotels hotel) {
        getSession().merge(hotel);
    }

    @Override
    public Hotels getById(int id) {
        return getByKey(id);
    }
}
