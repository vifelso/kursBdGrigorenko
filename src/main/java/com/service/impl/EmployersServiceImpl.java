package com.service.impl;

import com.dao.EmployersDAO;
import com.model.Employers;
import com.service.EmployersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Service
@Transactional
public class EmployersServiceImpl implements EmployersService {
    @Autowired
    private EmployersDAO employersDAO;
    @Override
    public List<Employers> findAllEmployers() {
        return employersDAO.findAllEmployers();
    }

    @Override
    public void delete(int id) {
        employersDAO.deleteEmployerById(id);
    }

    @Override
    public void add(Employers employer) {
        employersDAO.addEmployer(employer);

    }

    @Override
    public void edit(Employers employer) {
        employersDAO.editEmployer(employer);
    }

    @Override
    public Employers getById(int id) {
        return employersDAO.getById(id);
    }
}
