package com.projet.altn72.controleur.pages;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projet.altn72.entite.FeedbackEntite;
import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.EnvellopeService;
import com.projet.altn72.service.FeedbackService;
import com.projet.altn72.service.OutilService;
import com.projet.altn72.service.UtilisateurService;



@Controller
@RequestMapping("/student")
public class StudentControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired 
    private OutilService outilService;

    @Autowired 
    private FeedbackService feedbackService;

    @Autowired
    private EnvellopeService envellopeService;

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

    @GetMapping("/{pseudo}/feedbacks")
    public String afficherFeedbacks(@PathVariable String pseudo, Model model){
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        List<FeedbackEntite> feedbacks = feedbackService.getFeedbacksParUtilisateur(e);
        List<OutilEntite> outils = outilService.getOutils();
        
        model.addAttribute("enveloppeService", envellopeService);
        model.addAttribute("outils", outils);
        model.addAttribute("utilisateur", e);
        model.addAttribute("feedbacksUtilisateur", feedbacks);
        model.addAttribute("newFeedback", new FeedbackEntite());
        return "feedbacks";
    }

    @PostMapping("/{pseudo}/createFeedback")
    public String creerNouveauFeedback(@PathVariable String pseudo, @ModelAttribute FeedbackEntite feedbackUtilisateur, @RequestParam String outilRevue, Model model){
        return feedbackService.creerNouveauFeedback(pseudo, feedbackUtilisateur, outilRevue, model);
    }

    @PutMapping("/{pseudo}/modifyFeedback/{idFeedback}")
    public String modifierFeedback(@PathVariable String pseudo, @PathVariable String idFeedback, @ModelAttribute FeedbackEntite alteredFeedback){
        return feedbackService.modifierFeedback(pseudo, idFeedback, alteredFeedback);
    }
}
