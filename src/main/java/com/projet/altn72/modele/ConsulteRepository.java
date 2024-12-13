package com.projet.altn72.modele;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.altn72.entite.ConsulteEntite;
import com.projet.altn72.modele.composite.Consulte;

public interface ConsulteRepository extends JpaRepository<ConsulteEntite, Consulte> {

}
