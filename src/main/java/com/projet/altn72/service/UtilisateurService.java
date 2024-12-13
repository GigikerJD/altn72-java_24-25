package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<UtilisateurEntite> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public UtilisateurEntite getUtilisateurParEmail(String email){
        return utilisateurRepository.findById(email).get();
    }

    public void creerUtilisateur(UtilisateurEntite utilisateurEntite) {
        UtilisateurEntite copy = utilisateurEntite;
    }

    public UtilisateurEntite getUtilisateurParPseudo(String pseudo) {
        return utilisateurRepository.findById(pseudo).get();
    }

    
}
