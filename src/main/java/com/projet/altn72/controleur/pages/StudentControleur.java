package com.projet.altn72.controleur.pages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.OutilService;
import com.projet.altn72.service.UtilisateurService;



@Controller
@RequestMapping("/student")
public class StudentControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired 
    private OutilService outilService;

    @GetMapping("/{pseudo}")
    public String afficherPageEtudiant(@PathVariable String pseudo ,Model model){
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        List<OutilEntite> outils = outilService.getOutils();
        model.addAttribute("outils", outils);
        model.addAttribute("utilisateur", e);
        return "etudiant";
    }

    @GetMapping("/{pseudo}/outil/{titre}")
    public String afficherDetailsOutil(@PathVariable String pseudo, @PathVariable String titre, Model model){
        UtilisateurEntite utilisateur = utilisateurService.getUtilisateurParPseudo(pseudo);
        OutilEntite outil = outilService.getOutilParTitre(titre);
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("outil", outil);
        return "outil";
    }
}
