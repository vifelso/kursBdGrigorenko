package com.dao;

import com.model.Hotels;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface HotelsDAO {
    List<Hotels> findAllHotels();
    void addHotels(Hotels n);
    void deleteHotelsById(int id);
    void editHotels(Hotels hotels);
    Hotels getById(int id);
}
