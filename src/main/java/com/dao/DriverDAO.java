package com.dao;

import com.model.Drivers;

import java.util.List;


public interface DriverDAO {
    List<Drivers> findAllDrivers();
    void addDriver(Drivers n);
    void deleteDriverById(int id);
    void editDriver(Drivers driver);
    Drivers getById(int id);
}
