package com.projet.altn72.controleur.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.UtilisateurService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class UtilisateurControlleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs")
    public List<UtilisateurEntite> getTouslesUtilisateurs() {
        List<UtilisateurEntite> users = utilisateurService.getUtilisateurs();
        return users; 
    }
    
}
