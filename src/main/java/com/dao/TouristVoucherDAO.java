package com.dao;

import com.model.TouristVauchers;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface TouristVoucherDAO {
    List<TouristVauchers> findAllTouristVauchers();
    void addTouristVauchers(TouristVauchers n);
    void deleteTouristVauchersById(int id);
    void editTouristVauchers(TouristVauchers touristVauchers);
    TouristVauchers getById(int id);

}
