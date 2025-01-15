package com.projet.altn72.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.modele.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    public List<UtilisateurEntite> getUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    public UtilisateurEntite getUtilisateurParEmail(String email){
        return utilisateurRepository.findAll()
        .stream()
        .filter(u -> u.getEmail().equals(email))
        .findFirst() 
        .orElse(null);

    }

    public UtilisateurEntite getUtilisateurParPseudo(String pseudo){
        return utilisateurRepository.findAll()
        .stream()
        .filter(u -> u.getPseudo().equals(pseudo))
        .findFirst() 
        .orElse(null);
    }

    public boolean changeEmail(String oldEmail, String newEmail){
        if(oldEmail.equals(newEmail)) return false;
        UtilisateurEntite oldU = getUtilisateurParEmail(oldEmail);
        UtilisateurEntite newU = getUtilisateurParEmail(newEmail);
        if(newU != null) return false;
        oldU.setEmail(newEmail);
        utilisateurRepository.save(oldU);
        return true;
    }

    public boolean changePseudo(String oldPseudo, String newPseudo){
        UtilisateurEntite utilisateur = getUtilisateurParPseudo(oldPseudo);
        if (utilisateur == null) return false; 
        UtilisateurEntite existingUserWithNewPseudo = getUtilisateurParPseudo(newPseudo);
        if (existingUserWithNewPseudo != null) return false; 
        UtilisateurEntite newUtilisateur = new UtilisateurEntite(
            utilisateur.getEmail(), 
            newPseudo, 
            utilisateur.getMotDePasse(), 
            utilisateur.getPrenom(), 
            utilisateur.getNom(), 
            utilisateur.getDOB(), 
            utilisateur.getStatut(),
            utilisateur.getGenre()
        );
        utilisateurRepository.delete(utilisateur);
        utilisateurRepository.save(newUtilisateur);
        return true;
    }

    public String creerNouvelUtilisateur(UtilisateurEntite newUser, Model model) {
        UtilisateurEntite e = getUtilisateurParEmail(newUser.getEmail());
        boolean isAlreadyEnlisted = (e != null);
        if(isAlreadyEnlisted){
            model.addAttribute("erreur", "Un profil avec cet email existe déjà");
            return "signup";
        }
        else{
            String hashPassword = passwordEncoder.encode(newUser.getMotDePasse());
            String firstnameToCapital = capitalize(newUser.getPrenom());
            String lastnameToUpper = newUser.getNom().toUpperCase();
            newUser.setMotDePasse(hashPassword);
            newUser.setPrenom(firstnameToCapital);
            newUser.setNom(lastnameToUpper);
            utilisateurRepository.save(newUser);
            return "redirect:/succes";
        }
    }
    
    public boolean creerNouvelUtilisateur(UtilisateurEntite user){
        UtilisateurEntite e = getUtilisateurParEmail(user.getEmail());
        if(e != null) return false;
        if(!List.of("STUDENT", "ADMIN", "TEACHER").contains(user.getStatut())) return false;
        String hashPassword = passwordEncoder.encode(user.getMotDePasse());
        String firstnameToCapital = capitalize(user.getPrenom());
        String lastnameToUpper = user.getNom().toUpperCase();
        user.setMotDePasse(hashPassword);
        user.setPrenom(firstnameToCapital);
        user.setNom(lastnameToUpper);
        utilisateurRepository.save(user);
        return true;
    }

    public void supprimerUtilisateur(String email){
        var e = getUtilisateurParEmail(email);
        utilisateurRepository.delete(e);
    }

    public String seConnecter(Model model, String pseudo, String password) {
        UtilisateurEntite utilisateur = getUtilisateurParPseudo(pseudo);
        String nextPage = "login";
        if(utilisateur == null){
            model.addAttribute("erreur", "Votre email est incorrecte !");
            return nextPage;
        }
        boolean isSamePass = passwordEncoder.matches(password, utilisateur.getMotDePasse());
        if(!isSamePass){
            model.addAttribute("erreur", "Votre mot de passe est incorrecte !");
            return nextPage;
        }
        switch(utilisateur.getStatut()){
            case "STUDENT":
                nextPage = "redirect:/student/" + utilisateur.getPseudo();
                break;
            case "TEACHER":
                nextPage = "redirect:/teacher/" + utilisateur.getPseudo();
                break;
            case "ADMIN":
                nextPage = "redirect:/admin/" + utilisateur.getPseudo();
                break; 
        }
        return nextPage;
    }
    public List<UtilisateurEntite> getEnseignants(){
        return utilisateurRepository
            .findAll()
            .stream()
            .filter(u -> u.getStatut().equals("TEACHER"))
            .toList();
    }
    public List<UtilisateurEntite> getEtudiants(){
        return utilisateurRepository
            .findAll()
            .stream()
            .filter(u -> u.getStatut().equals("STUDENT"))
            .toList();
    }
    
    public List<UtilisateurEntite> getAdmins(){
        return utilisateurRepository
            .findAll()
            .stream()
            .filter(u -> u.getStatut().equals("ADMIN"))
            .toList();
    }
    private String capitalize(String name){
        return name.toUpperCase().charAt(0) + name.toLowerCase().substring(1);
    }

    public String seDeconnecter() {
        return "redirect:/";
    }
}
