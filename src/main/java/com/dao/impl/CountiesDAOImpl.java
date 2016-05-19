package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.CountriesDAO;
import com.model.Countries;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andrei on 12.05.2016.
 */
@Repository
public class CountiesDAOImpl extends AbstractDAO<Integer,Countries>implements CountriesDAO{
    @Override
    @SuppressWarnings("unchecked")
    public List<Countries> findAllCountries() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
    @Override
    public void addCountry(Countries n) {
        persist(n);
    }
    @Override
    public void deleteCountryById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Countries countries = (Countries)criteria.uniqueResult();
        delete(countries);
    }
    @Override
    public void editCountry(Countries countries) {
        getSession().merge(countries);
    }

    @Override
    public Countries getById(int id) {
        return getByKey(id);
    }
}
