package com.projet.altn72.modele;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.altn72.entite.EnveloppeEntite;
import com.projet.altn72.modele.composite.Enveloppe;

public interface EnveloppeRepository extends JpaRepository<EnveloppeEntite, Enveloppe> {

}
