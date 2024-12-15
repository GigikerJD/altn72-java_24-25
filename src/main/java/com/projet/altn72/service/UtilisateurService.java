package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.UtilisateurRepository;
import com.projet.altn72.modele.composite.Utilisateur;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private Utilisateur user = null;

    public List<UtilisateurEntite> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public UtilisateurEntite getUtilisateurParEmail(String email){
        user = new Utilisateur(email);
        return utilisateurRepository.findById(user).get();
    }

    public void creerNouvelUtilisateur(UtilisateurEntite newUser) {
        user = new Utilisateur(newUser.getEmail());
        boolean isAlreadyEnlisted = utilisateurRepository.findById(user).isPresent();
        if(isAlreadyEnlisted){
            System.err.println("Utilisateur déjà enregistré !");
        }else{
            utilisateurRepository.save(newUser);
            System.out.println("Vous êtes enregistré !");
        }
    }  

    public void supprimerUtilisateur(UtilisateurEntite user){
        utilisateurRepository.delete(user);
    }

    public void Login(Model model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Login'");
    }
    
}
