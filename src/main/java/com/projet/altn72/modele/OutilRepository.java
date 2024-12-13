package com.projet.altn72.modele;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.altn72.entite.OutilEntite;

public interface OutilRepository extends JpaRepository<OutilEntite, String> {
    // Requête personnalisée pour récupérer des outils par domaine
    List<OutilEntite> findByDomaine(String domaine);
}
