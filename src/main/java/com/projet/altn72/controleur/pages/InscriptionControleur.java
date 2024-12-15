package com.projet.altn72.controleur.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.UtilisateurService;

@Controller
@RequestMapping("/account")
public class InscriptionControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/signup")
    public String afficherFormulaire(Model model) {
        model.addAttribute("utilisateur", new UtilisateurEntite());
        return "signup"; 
    }

    @PostMapping("/new_user")
    public ResponseEntity<Void> createNouvelUtilisateur(@RequestBody UtilisateurEntite utilisateur) {
        utilisateurService.creerNouvelUtilisateur(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).build();
}

}
