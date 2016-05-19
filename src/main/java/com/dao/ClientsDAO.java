package com.dao;

import com.model.Clients;


import java.util.List;

/**
 * Created by Andrei on 23.04.2016.
 */
public interface ClientsDAO {
    List<Clients> findAllClients();
    void addClient(Clients n);
    void deleteClientById(int id);
    void editClient(Clients client);
    Clients getClientByKey(int id);
}
