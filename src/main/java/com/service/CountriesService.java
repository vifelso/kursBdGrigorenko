package com.service;

import com.model.Countries;

import java.util.List;

/**
 * Created by Andrei on 12.05.2016.
 */
public interface CountriesService {
    List<Countries> findAllCountries();
    void delete(int id);
    void add(Countries countries);
    void edit(Countries country);
    Countries getById(int id);
}
