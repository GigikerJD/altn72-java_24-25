package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.EnveloppeEntite;
import com.projet.altn72.entite.FeedbackEntite;
import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.modele.EnveloppeRepository;

@Service
public class EnvellopeService {

    @Autowired
    private EnveloppeRepository enveloppeRepository;

    public EnveloppeEntite getFeedbackParID(String id){
        return enveloppeRepository
            .findAll()
            .stream()
            .filter(env -> env.getIdFeedback().equals(id))
            .findFirst()
            .orElse(null);
    }

    public List<EnveloppeEntite> getFeedbackParOutil(String titre){
        return enveloppeRepository
            .findAll()
            .stream()
            .filter(env -> env.getTitre().equals(titre))
            .toList();
    }

    public void ajouterNouveauFeedbackPourOutil(OutilEntite outil, FeedbackEntite feedbackEntite){
        EnveloppeEntite enveloppeEntite = new EnveloppeEntite(feedbackEntite.getIdFeedback(), outil.getTitre(), feedbackEntite, outil);
        enveloppeRepository.save(enveloppeEntite);
    }
}
