package com.service;

import com.model.Drivers;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface DriversService {
    List<Drivers> findAllDrivers();
    void delete(int id);
    void addDriver(Drivers driver);
    void edit(Drivers driver);
    Drivers getById(int id);
}
