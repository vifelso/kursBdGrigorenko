package com.service.impl;

import com.dao.HotelsDAO;
import com.model.Hotels;
import com.service.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Service
@Transactional
public class HotelsServiceImpl implements HotelsService{
    @Autowired
    private HotelsDAO hotelsDAO;

    @Override
    public List<Hotels> findAllHotels() {
        return hotelsDAO.findAllHotels();
    }

    @Override
    public void delete(int id) {
        hotelsDAO.deleteHotelsById(id);
    }

    @Override
    public void add(Hotels hotel) {
        hotelsDAO.addHotels(hotel);
    }

    @Override
    public void edit(Hotels hotel) {
        hotelsDAO.editHotels(hotel);
    }

    @Override
    public Hotels getById(int id) {
        return hotelsDAO.getById(id);
    }
}
