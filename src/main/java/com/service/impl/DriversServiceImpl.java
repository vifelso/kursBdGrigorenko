package com.service.impl;

import com.dao.DriverDAO;
import com.model.Drivers;
import com.service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Service
@Transactional
public class DriversServiceImpl implements DriversService{
    @Autowired
    private DriverDAO driverDAO;
    @Override
    public List<Drivers> findAllDrivers() {
      return   driverDAO.findAllDrivers();
    }

    @Override
    public void delete(int id) {
        driverDAO.deleteDriverById(id);
    }

    @Override
    public void addDriver(Drivers driver) {
        driverDAO.addDriver(driver);
    }

    @Override
    public void edit(Drivers driver) {
        driverDAO.editDriver(driver);
    }

    @Override
    public Drivers getById(int id) {
        return driverDAO.getById(id);
    }
}
