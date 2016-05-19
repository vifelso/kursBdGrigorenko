package com.dao.impl;

import com.dao.AbstractDAO;
import com.dao.ClientsDAO;
import com.model.Clients;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ClientsDAOImpl extends AbstractDAO<Integer,Clients> implements ClientsDAO {
    @Override
    @SuppressWarnings("unchecked")
    public List<Clients> findAllClients() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }
    @Override
    public void addClient(Clients n) {
        persist(n);
    }
    @Override
    public void deleteClientById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Clients clients = (Clients)criteria.uniqueResult();
        delete(clients);
    }
    @Override
    public void editClient(Clients client) {
        getSession().merge(client);
    }

    @Override
    public Clients getClientByKey(int id) {
        return getByKey(id) ;
    }

}
