package com.service.impl;

import com.dao.TouristVoucherDAO;
import com.model.TouristVauchers;
import com.service.TouristVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TouristVoucherServiceImpl implements TouristVoucherService {
    @Autowired
    private TouristVoucherDAO touristVoucherDAO;
    @Override
    public List<TouristVauchers> findAllTouristVauchers() {
        return touristVoucherDAO.findAllTouristVauchers();
    }

    @Override
    public void deleteTouristVoucher(int id) {
        touristVoucherDAO.deleteTouristVauchersById(id);
    }

    @Override
    public void add(TouristVauchers touristVaucher) {
        touristVoucherDAO.addTouristVauchers(touristVaucher);
    }

    @Override
    public void edit(TouristVauchers touristVaucher) {
        touristVoucherDAO.editTouristVauchers(touristVaucher);
    }

    @Override
    public TouristVauchers getById(int id) {
        return touristVoucherDAO.getById(id);
    }
}
