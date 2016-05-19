package com.dao;

import com.model.Transport;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface TransportDAO {
    List<Transport> findAllTransports();
    void addTransport(Transport n);
    void deleteTransportById(int id);
    void editTransport(Transport transport);
    Transport getById(int id);
}
