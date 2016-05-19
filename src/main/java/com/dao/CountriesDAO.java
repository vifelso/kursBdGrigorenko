package com.dao;


import com.model.Countries;

import java.util.List;

/**
 * Created by Andrei on 12.05.2016.
 */
public interface CountriesDAO {
    List<Countries> findAllCountries();
    void addCountry(Countries n);
    void deleteCountryById(int id);
    void editCountry(Countries countries);
    Countries getById(int id);


}
