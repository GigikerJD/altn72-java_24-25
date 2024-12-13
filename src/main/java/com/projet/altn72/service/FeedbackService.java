package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.altn72.entite.FeedbackEntite;
import com.projet.altn72.modele.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<FeedbackEntite> getFeedbacks(){
        return feedbackRepository.findAll();
    }

}
