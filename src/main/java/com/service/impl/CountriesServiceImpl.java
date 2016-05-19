package com.service.impl;

import com.dao.CountriesDAO;
import com.model.Countries;
import com.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountriesServiceImpl implements CountriesService {
    @Autowired
    private CountriesDAO countriesDAO;

    @Override
    public List<Countries> findAllCountries() {
        return countriesDAO.findAllCountries();
    }

    @Override
    public void delete(int id) {
        countriesDAO.deleteCountryById(id);
    }

    @Override
    public void add(Countries countries) {
        countriesDAO.addCountry(countries);
    }

    @Override
    public void edit(Countries country) {
        countriesDAO.editCountry(country);
    }

    @Override
    public Countries getById(int id) {
        return countriesDAO.getById(id);
    }


}
