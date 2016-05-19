package com.service;

import com.model.Transport;

import java.util.List;

/**
 * Created by Andrei on 13.05.2016.
 */
public interface TransportService {
    List<Transport> findAllTransport();
    void delete(int id);
    void add(Transport transport);
    void edit(Transport transport);
    Transport getById(int id);
}
