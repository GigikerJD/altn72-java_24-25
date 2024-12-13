package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.modele.OutilRepository;
import com.projet.altn72.modele.composite.Outil;

@Service
public class OutilService {

    @Autowired
    private OutilRepository outilRepository;

    public List<OutilEntite> getOutils(){
        return outilRepository.findAll();
    }

    public OutilEntite getOutilParTitre(String titre){
        Outil outil = new Outil();
        return outilRepository.findById(outil).get();
    }
}
