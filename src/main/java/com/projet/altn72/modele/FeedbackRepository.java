package com.projet.altn72.modele;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.altn72.entite.FeedbackEntite;

public interface FeedbackRepository extends JpaRepository<FeedbackEntite, String> {

}
