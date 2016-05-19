package com.dao;



import javafx.collections.ObservableList;
import org.hibernate.SQLQuery;
import org.hibernate.procedure.ProcedureCall;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrei on 16.05.2016.
 */
public interface AdvancedQueryDAO {
    List between();
    List like();
    List selectOrderBy();
    List groupBy();
    List storedProcedure();
    List subWhere();
    List innerJoin();
    List storedProcedureWithParameters();
}
