package com.service.impl;

import com.dao.InsuranceDAO;
import com.model.Insurance;
import com.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Service
@Transactional
public class InsuranceServiceImpl implements InsuranceService {
    @Autowired
    private InsuranceDAO insuranceDAO;

    @Override
    public List<Insurance> findAllInsurance() {
        return insuranceDAO.findAllInsurance();
    }

    @Override
    public void delete(int id) {
        insuranceDAO.deleteInsuranceById(id);
    }

    @Override
    public void add(Insurance insurance) {
        insuranceDAO.addInsurance(insurance);
    }

    @Override
    public void edit(Insurance insurance) {
        insuranceDAO.editInsurance(insurance);
    }

    @Override
    public Insurance getById(int id) {
        return insuranceDAO.getById(id);
    }
}
