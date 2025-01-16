package com.projet.altn72.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.projet.altn72.entite.FeedbackEntite;
import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.FeedbackRepository;
import com.projet.altn72.modele.UtilisateurRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private EnvellopeService envellopeService;

    @Autowired
    private OutilService outilService;

    public List<FeedbackEntite> getFeedbacks(){
        return feedbackRepository.findAll();
    }

    public FeedbackEntite getFeedbackParId(String idFeedback){
        return feedbackRepository.findById(idFeedback).orElse(null);
    }

    public List<FeedbackEntite> getFeedbacksParDate(LocalDate date){
        return feedbackRepository
            .findAll()
            .stream()
            .filter(feed -> feed.getDateFeedback().equals(date))
            .toList();
    }

    public List<FeedbackEntite> getFeedbacksParUtilisateur(UtilisateurEntite user){
        return feedbackRepository
            .findAll()
            .stream()
            .filter(feed -> feed.getPseudoUser().equals(user.getPseudo()))
            .toList();
    }

    public void ajouterNouveauFeedback(String pseudo, FeedbackEntite feedback){
        feedback.setIdFeedback(UUID.randomUUID().toString());
        feedback.setDateFeedback(LocalDate.now());
        feedback.setPseudoUser(pseudo);
        feedbackRepository.save(feedback);
    }

    public boolean estFeedbackExistant(String idFeedback){
        return feedbackRepository.existsById(idFeedback);
    }

    public String creerNouveauFeedback(String pseudo, FeedbackEntite feedbackUtilisateur, String outilRevue, Model model) {
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        model.addAttribute("erreurAjout", "Vous avez atteint la limite");
        if(e.getNombreFeedbacks() == 0){
            switch (e.getStatut()) {
                case "STUDENT":
                    return "redirect:/student/" + e.getPseudo() + "/feedbacks";
                case "ADMIN":
                    return "redirect:/admin/" + e.getPseudo() + "/feedbacks";
                case "TEACHER": 
                    return "redirect:/teacher/" + e.getPseudo() + "/feedbacks";
                default:
                    break;
            }
        }
        ajouterNouveauFeedback(pseudo, feedbackUtilisateur);
        OutilEntite outil = outilService.getOutilParTitre(outilRevue);
        envellopeService.ajouterNouveauFeedbackPourOutil(outil, feedbackUtilisateur);
        UtilisateurEntite copy = e;
        copy.setNombreFeedbacks(e.getNombreFeedbacks()-1);
        BeanUtils.copyProperties(e, copy);
        utilisateurRepository.save(copy);
        String nextPage = "";
        switch(e.getStatut()){
            case "STUDENT":
                nextPage = "redirect:/student/" + e.getPseudo() + "/feedbacks";
                break;
            case "TEACHER":
                nextPage = "redirect:/teacher/" + e.getPseudo() + "/feedbacks";
                break;
            case "ADMIN":
                nextPage = "redirect:/admin/" + e.getPseudo() + "/feedbacks";
                break;
        }
        return nextPage;
    }

    public String modifierFeedback(String pseudo, String idFeedback, FeedbackEntite alteredFeedback) {
        String nextPage = "";
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        switch(e.getStatut()){
            case "STUDENT":
                nextPage = "redirect:/student/" + e.getPseudo() + "/feedbacks";
                break;
            case "TEACHER":
                nextPage = "redirect:/teacher/" + e.getPseudo() + "/feedbacks";
                break;
            case "ADMIN":
                nextPage = "redirect:/admin/" + e.getPseudo() + "/feedbacks";
                break;
        }
        return nextPage;
    }

}
