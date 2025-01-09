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
@RequestMapping("/teacher")
public class TeacherControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired 
    private OutilService outilService;

    @GetMapping("/{pseudo}")
    public String afficherPageEnseignant(@PathVariable String pseudo, Model model){
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        List<OutilEntite> outils = outilService.getOutils();
        model.addAttribute("utilisateur", e);
        model.addAttribute("outils", outils);
        return "enseignant";
    }

}
