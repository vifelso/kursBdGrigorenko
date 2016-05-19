package com.dao;

import com.model.Insurance;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface InsuranceDAO {
    List<Insurance> findAllInsurance();
    void addInsurance(Insurance n);
    void deleteInsuranceById(int id);
    void editInsurance(Insurance insurance);
    Insurance getById(int id);
}
