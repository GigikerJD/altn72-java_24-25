package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.UtilisateurRepository;
import com.projet.altn72.modele.composite.Utilisateur;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<UtilisateurEntite> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public UtilisateurEntite getUtilisateurParEmail(String email){
        Utilisateur user = new Utilisateur(email);
        return utilisateurRepository.findById(user).get();
    }

    
}
