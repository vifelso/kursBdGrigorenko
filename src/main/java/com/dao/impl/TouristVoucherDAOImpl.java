package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.TouristVoucherDAO;
import com.model.TouristVauchers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TouristVoucherDAOImpl extends AbstractDAO<Integer,TouristVauchers> implements TouristVoucherDAO{

    @Override
    @SuppressWarnings("unchecked")
    public List<TouristVauchers> findAllTouristVauchers() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public void addTouristVauchers(TouristVauchers n) {
        persist(n);
    }

    @Override
    public void deleteTouristVauchersById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        TouristVauchers touristVauchers = (TouristVauchers)criteria.uniqueResult();
        delete(touristVauchers);
    }

    @Override
    public void editTouristVauchers(TouristVauchers touristVauchers) {
        getSession().merge(touristVauchers);

    }

    @Override
    public TouristVauchers getById(int id) {
        return getByKey(id);
    }
}
