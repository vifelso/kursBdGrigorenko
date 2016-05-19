package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.TransportDAO;
import com.model.Transport;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransportDAOImpl  extends AbstractDAO<Integer,Transport> implements TransportDAO{
    @Override
    @SuppressWarnings("unchecked")
    public List<Transport> findAllTransports() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @Override
    public void addTransport(Transport n) {
        persist(n);
    }

    @Override
    public void deleteTransportById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Transport transport = (Transport)criteria.uniqueResult();
        delete(transport);
    }

    @Override
    public void editTransport(Transport transport) {
        getSession().merge(transport);
    }

    @Override
    public Transport getById(int id) {
        return getByKey(id);
    }
}
