package com.projet.altn72.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.FeedbackEntite;
import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

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
            .filter(feed -> feed.getIdFeedback().contains(user.getPseudo()))
            .toList();
    }

    public void ajouterNouveauFeedback(FeedbackEntite feedback){
        feedbackRepository.save(feedback);
    }

    public boolean estFeedbackExistant(String idFeedback){
        return feedbackRepository.existsById(idFeedback);
    }

}
