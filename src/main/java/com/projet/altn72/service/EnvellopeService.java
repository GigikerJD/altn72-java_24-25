package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.EnveloppeEntite;
import com.projet.altn72.modele.EnveloppeRepository;

@Service
public class EnvellopeService {

    @Autowired
    private EnveloppeRepository enveloppeRepository;

    public List<EnveloppeEntite> getTousLesFeedbacksParOutil(String titre){
        return enveloppeRepository
            .findAll()
            .stream()
            .filter(env -> env.getTitre().equals(titre))
            .toList();
    }
}
