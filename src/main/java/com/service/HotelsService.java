package com.service;

import com.model.Hotels;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface HotelsService {
    List<Hotels> findAllHotels();
    void delete(int id);
    void add (Hotels hotel);
    void edit(Hotels hotel);
    Hotels getById(int id);
}
