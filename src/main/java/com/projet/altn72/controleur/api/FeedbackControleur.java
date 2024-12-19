package com.projet.altn72.controleur.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.altn72.entite.FeedbackEntite;
import com.projet.altn72.service.FeedbackService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackControleur {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/")
    public ResponseEntity<List<FeedbackEntite>> getTousLesFeedbacks(){
        List<FeedbackEntite> feedbacks = feedbackService.getFeedbacks();
        if(feedbacks.size() == 0)
            return ResponseEntity.status(404).body(null);
        else 
            return ResponseEntity.ok(feedbacks);
    }
    
}
