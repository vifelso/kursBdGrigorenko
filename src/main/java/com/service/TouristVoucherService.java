package com.service;

import com.model.TouristVauchers;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface TouristVoucherService {
    List<TouristVauchers> findAllTouristVauchers();
    void deleteTouristVoucher(int  id);
    void add(TouristVauchers touristVaucher);
    void edit(TouristVauchers touristVaucher);
    TouristVauchers getById(int id);
}
