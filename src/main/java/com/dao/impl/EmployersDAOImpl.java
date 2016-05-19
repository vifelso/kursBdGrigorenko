package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.EmployersDAO;
import com.model.Employers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Repository
public class EmployersDAOImpl extends AbstractDAO<Integer,Employers> implements EmployersDAO{

    @Override
    @SuppressWarnings("unchecked")
    public List<Employers> findAllEmployers() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public void addEmployer(Employers n) {
        persist(n);
    }

    @Override
    public void deleteEmployerById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Employers employers = (Employers)criteria.uniqueResult();
        delete(employers);
    }

    @Override
    public void editEmployer(Employers employer) {
        getSession().merge(employer);
    }

    @Override
    public Employers getById(int id) {
        return getByKey(id);
    }
}
