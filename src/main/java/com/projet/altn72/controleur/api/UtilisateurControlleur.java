package com.projet.altn72.controleur.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.UtilisateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/users")
public class UtilisateurControlleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("")
    public List<UtilisateurEntite> getTouslesUtilisateurs() {
        List<UtilisateurEntite> users = utilisateurService.getUtilisateurs();
        return users; 
    }

    @PostMapping("/{email}")
    public ResponseEntity<UtilisateurEntite> getUtilisateurParEmail(@PathVariable String email) {
        return ResponseEntity.ok(utilisateurService.getUtilisateurParEmail(email));
    }
    
    
}
