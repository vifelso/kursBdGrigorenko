package com.service.impl;

import com.dao.TransportDAO;
import com.model.Transport;
import com.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
@Service
@Transactional
public class TransportServiceImpl implements TransportService {
    @Autowired
    private TransportDAO transportDAO;
    @Override
    public List<Transport> findAllTransport() {
        return transportDAO.findAllTransports();
    }

    @Override
    public void delete(int id) {
        transportDAO.deleteTransportById(id);
    }

    @Override
    public void add(Transport transport) {
        transportDAO.addTransport(transport);
    }

    @Override
    public void edit(Transport transport) {
        transportDAO.editTransport(transport);
    }

    @Override
    public Transport getById(int id) {
        return transportDAO.getById(id);
    }
}
