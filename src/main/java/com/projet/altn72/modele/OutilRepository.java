package com.projet.altn72.modele;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.modele.composite.Outil;

public interface OutilRepository extends JpaRepository<OutilEntite, Outil> {

}
