package com.projet.altn72.modele;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.composite.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntite, Utilisateur> {

}
