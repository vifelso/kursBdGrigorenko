package com.dao;

import com.model.Employers;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface EmployersDAO {
    List<Employers> findAllEmployers();
    void addEmployer(Employers n);
    void deleteEmployerById(int id);
    void editEmployer(Employers employer);
    Employers getById(int id);
}
