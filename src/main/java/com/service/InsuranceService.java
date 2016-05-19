package com.service;

import com.model.Insurance;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface InsuranceService {
    List<Insurance> findAllInsurance();
    void delete(int id);
    void add(Insurance insurance);
    void edit(Insurance insurance);
    Insurance getById(int id);
}
