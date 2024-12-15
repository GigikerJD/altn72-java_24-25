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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/users")
public class UtilisateurControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("")
    public ResponseEntity<List<UtilisateurEntite>> getTouslesUtilisateurs() {
        List<UtilisateurEntite> users = utilisateurService.getUtilisateurs();
        return users.size() == 0 ?
            ResponseEntity.status(404).body(null) :
            ResponseEntity.ok(users);  
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<UtilisateurEntite>  getUtilisateurParEmail(@PathVariable String email){
        UtilisateurEntite e = utilisateurService.getUtilisateurParEmail(email);
        return e == null ?
            ResponseEntity.status(404).body(null) :
            ResponseEntity.ok(e);
    }

    
    @PostMapping("/new_user")
    public void createNouvelUtilisateur(@RequestBody UtilisateurEntite user){
        utilisateurService.creerNouvelUtilisateur(user);
    }
    
}
