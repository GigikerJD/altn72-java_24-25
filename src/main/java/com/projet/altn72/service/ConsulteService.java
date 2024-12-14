package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.ConsulteEntite;
import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.ConsulteRepository;

@Service
public class ConsulteService {

    @Autowired
    private ConsulteRepository consulteRepository;


    public List<ConsulteEntite> getConsults(){
        return consulteRepository.findAll();
    }

    public List<UtilisateurEntite> getUtilisateursParOutil(String titre){
        return consulteRepository
            .findAll()
            .stream()
            .filter(c -> c.getOutil().getTitre().equals(titre))
            .map(c -> c.getUtilisateur())
            .toList();
    }
}
