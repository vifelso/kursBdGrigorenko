package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.InsuranceDAO;
import com.model.Insurance;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InsuranceDAOImpl  extends AbstractDAO<Integer,Insurance> implements InsuranceDAO{
    @Override
    @SuppressWarnings("unchecked")
    public List<Insurance> findAllInsurance() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public void addInsurance(Insurance n) {
        persist(n);
    }

    @Override
    public void deleteInsuranceById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Insurance insurance = (Insurance)criteria.uniqueResult();
        delete(insurance);
    }

    @Override
    public void editInsurance(Insurance insurance) {
        getSession().merge(insurance);
    }

    @Override
    public Insurance getById(int id) {
        return getByKey(id);
    }
}
