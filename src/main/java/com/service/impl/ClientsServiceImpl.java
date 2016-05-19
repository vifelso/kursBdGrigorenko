package com.service.impl;


import com.dao.ClientsDAO;
import com.model.Clients;
import com.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei on 23.04.2016.
 */
@Service
@Transactional
public class ClientsServiceImpl implements ClientsService {
    @Autowired
    private ClientsDAO clientsDAO;
    @Override
    public List<Clients> findAllClients() {
        return clientsDAO.findAllClients();
    }

    @Override
    public void delete(int id) {
        clientsDAO.deleteClientById(id);
    }

    @Override
    public void add(Clients clients) {
        clientsDAO.addClient(clients);
    }

    @Override
    public Clients getClientById(int id) {
        return clientsDAO.getClientByKey(id);
    }

    @Override
    public void edit(Clients client) {
        clientsDAO.editClient(client);
    }

}
