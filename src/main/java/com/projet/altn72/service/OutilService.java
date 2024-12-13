package com.projet.altn72.service;

import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.modele.OutilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutilService {

    private final OutilRepository outilRepository;

    public OutilService(OutilRepository outilRepository) {
        this.outilRepository = outilRepository;
    }

    public List<OutilEntite> getAllOutils() {
        return outilRepository.findAll();
    }

    public OutilEntite getOutilByTitre(String titre) {
        return outilRepository.findById(titre).orElse(null);
    }

    public List<OutilEntite> getOutilsByDomaine(String domaine) {
        return outilRepository.findByDomaine(domaine);
    }

    public OutilEntite saveOutil(OutilEntite outil) {
        return outilRepository.save(outil);
    }

    public void deleteOutil(String titre) {
        outilRepository.deleteById(titre);
    }
}
