package com.projet.altn72.controleur.pages;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/{pseudo}/outil/{titre}")
    public String afficherDetailsOutil(@PathVariable String pseudo, @PathVariable String titre, Model model){
        UtilisateurEntite utilisateur = utilisateurService.getUtilisateurParPseudo(pseudo);
        OutilEntite outil = outilService.getOutilParTitre(titre);
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("outil", outil);
        return "outil";
    }

    @GetMapping("/{pseudo}/settings")
    public String getMethodName(@PathVariable String pseudo, Model model) {
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        model.addAttribute("utilisateur", e);
        model.addAttribute("utilisateurAModifie", new UtilisateurEntite());
        return "settings";
    }

    @PutMapping("{pseudo}/settings")
    public String modifierInfosUtilisateur(@PathVariable String pseudo, @ModelAttribute UtilisateurEntite utilisateurAModifie) {
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        BeanUtils.copyProperties(e, utilisateurAModifie);
        return "redirect:/" + utilisateurAModifie.getStatut().toLowerCase() + "/" + utilisateurAModifie.getPseudo();
    }

    @DeleteMapping("{pseudo}/settings")
    public String supprimerCompte(@PathVariable String pseudo){
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        utilisateurService.supprimerUtilisateur(e.getEmail());
        return "redirect:/";
    }

}
