package com.service;


import com.model.Clients;

import java.util.List;

/**
 * Created by Andrei on 23.04.2016.
 */
public interface ClientsService {
    List<Clients> findAllClients();
    void delete(int id);
    void add(Clients clients);
    Clients getClientById(int id);
    void edit(Clients client);
}
