package com.projet.altn72.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.modele.ConsulteRepository;

@Service
public class ConsulteService {

    @Autowired
    private ConsulteRepository consulteRepository;
}
