package com.service.impl;

import com.dao.AdvancedQueryDAO;
import com.service.AdvancedQueryService;
import javafx.collections.ObservableList;
import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrei on 16.05.2016.
 */
@Service
@Transactional
public class AdvancedQueryServiceImpl implements AdvancedQueryService {
    @Autowired
    private AdvancedQueryDAO advancedQueryDAO;
    @Override
    public List between() {
        return advancedQueryDAO.between();
    }

    @Override
    public List like() {
        return advancedQueryDAO.like();
    }

    @Override
    public List selectOrderBy() {
        return advancedQueryDAO.selectOrderBy();
    }

    @Override
    public List grouBy() {
        return  advancedQueryDAO.groupBy();
    }


    @Override
    public List storedProcedure() {
        return advancedQueryDAO.storedProcedure();
    }

    @Override
    public List subWhere() {
        return advancedQueryDAO.subWhere();
    }

    @Override
    public List innerJoin() {
        return advancedQueryDAO.innerJoin();
    }

    @Override
    public List storedProcedureWithParameters() {
        return advancedQueryDAO.storedProcedureWithParameters();
    }


}
