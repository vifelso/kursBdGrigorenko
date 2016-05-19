package com.service;


import org.hibernate.Query;
import org.hibernate.procedure.ProcedureCall;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrei on 16.05.2016.
 */
public interface AdvancedQueryService {
    List between();
    List like();
    List selectOrderBy();
    List grouBy();
    List storedProcedure();
    List subWhere();
    List innerJoin();
    List storedProcedureWithParameters();

}
