package com.dao.impl;

import com.dao.AdvancedQueryDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andrei on 16.05.2016.
 */
@Repository
public class AdvancedQueryDAOImpl implements AdvancedQueryDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List between(){

        return sessionFactory.getCurrentSession().createQuery("SELECT t  FROM TouristVauchers t WHERE t.cost BETWEEN 500 AND 600").list();
    }

    @Override
    public List like() {
        return sessionFactory.getCurrentSession().createQuery("SELECT d  FROM Drivers d WHERE d.fullName LIKE '[A]%'").list();
    }

    @Override
    public List selectOrderBy() {
       return   sessionFactory.getCurrentSession().createQuery("SELECT employer,client  " +
                "FROM TouristVauchers  touristVoucher, Employers  employer, Clients client " +
                "WHERE employer.id=touristVoucher.idEmployer and touristVoucher.idClient=client.id  ORDER BY client.name  DESC").list();

    }

    @Override
    public List groupBy() {
        return  sessionFactory.getCurrentSession().createQuery("SELECT d.fullName, Count(c.id) FROM Drivers d, Clients c , TouristVauchers  t WHERE d.id=t.idDriver and c.id=t.idClient GROUP BY d.fullName").list();
    }

    @Override
    public List storedProcedure() {
        return  sessionFactory.getCurrentSession().getNamedQuery("simpleProcedure").list();
    }

    @Override
    public List subWhere() {
        return sessionFactory.getCurrentSession().createQuery("SELECT t  FROM TouristVauchers t  WHERE t.cost=(SELECT MAX(t1.cost) FROM TouristVauchers t1)").list();
    }

    @Override
    public List innerJoin() {
        return sessionFactory.getCurrentSession().createQuery("SELECT c.name,SUM(t.cost) FROM  TouristVauchers t JOIN Clients c ON c.id=t.idClient GROUP BY c.name ORDER BY c.name").list();
    }

    @Override
    public List storedProcedureWithParameters() {
        return sessionFactory.getCurrentSession().getNamedQuery("withParameters").setParameter("Summa1", 50).setParameter("Summa2", 60).list();

    }


}
