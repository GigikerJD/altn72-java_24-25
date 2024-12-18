package com.projet.altn72.controleur.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.UtilisateurService;

@Controller
@RequestMapping("/student")
public class StudentControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/{email}")
    public String StudentPage(@PathVariable String email ,Model model){
        UtilisateurEntite e = utilisateurService.getUtilisateurParEmail(email);
        model.addAttribute("utilisateur", e);
        return "etudiant";
    }
}
