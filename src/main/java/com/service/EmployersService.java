package com.service;

import com.model.Employers;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface EmployersService {
    List<Employers> findAllEmployers();
    void delete(int id);
    void add(Employers employer);
    void edit(Employers employer);
    Employers getById(int id);
}
