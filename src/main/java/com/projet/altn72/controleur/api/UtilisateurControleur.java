package com.projet.altn72.controleur.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestController;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.UtilisateurService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/users")
public class UtilisateurControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("")
    public ResponseEntity<?> getTousLesUtilisateurs() {
        List<UtilisateurEntite> users = utilisateurService.getUtilisateurs();
        return users.isEmpty() ?
            ResponseEntity.status(204).body("Votre liste d'utilisateurs est vide") :
            ResponseEntity.status(200).body(users);  
    }

    @GetMapping("user/{email}")
    public ResponseEntity<?>  getUtilisateurParEmail(@PathVariable String email){
        UtilisateurEntite e = utilisateurService.getUtilisateurParEmail(email);
        return e == null ?
            ResponseEntity.notFound().build() :
            ResponseEntity.ok(e);
    }

    @GetMapping("pseudo/{pseudo}")
    public ResponseEntity<UtilisateurEntite> getUtilisateurParPseudo(@PathVariable String pseudo){
        UtilisateurEntite e = utilisateurService.getUtilisateurParPseudo(pseudo);
        return e == null ?
            ResponseEntity.notFound().build() : 
            ResponseEntity.ok(e);
    }

    @PutMapping("/settings/{oldPseudo}")
    public ResponseEntity<?> modifyUtilisateurParPseudo(@PathVariable String oldPseudo, @RequestParam String newPseudo){
        if (oldPseudo.equals(newPseudo))
            return ResponseEntity.badRequest().body("Les pseudos sont identiques");
        
        boolean hasChangePseudo = utilisateurService.changePseudo(oldPseudo, newPseudo);
        return hasChangePseudo ?
            ResponseEntity.ok(String.format("Votre profil au nom de %s a été modifié !", newPseudo)) :
            ResponseEntity.badRequest().body("Échec de la modification. Vérifiez vos informations !");
    }

    
    @PostMapping("/candidate")
    public ResponseEntity<?> createNouvelUtilisateur(@RequestBody UtilisateurEntite user){
        var isAlreadyEnrolledWithEmail = utilisateurService.getUtilisateurParEmail(user.getEmail());
        if(isAlreadyEnrolledWithEmail != null) return ResponseEntity.badRequest().body("Un utilisateur avec cet email existe déjà !");
        var isAlreadyEnrolledWithPseudo = utilisateurService.getUtilisateurParPseudo(user.getPseudo());
        if(isAlreadyEnrolledWithPseudo != null) return ResponseEntity.badRequest().body("Un utilisateur avec ce pseudo existe déjà !");
        utilisateurService.creerNouvelUtilisateur(user);        
        return ResponseEntity.ok("Votre profil a été créé avec succès !");
    }
    

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUtilisateur(@RequestParam @Nullable String email){
        var user = utilisateurService.getUtilisateurParEmail(email);
        if (user != null) {
            utilisateurService.supprimerUtilisateur(email);
            return ResponseEntity.ok("Votre profil a été supprimé !");
        } else 
            return ResponseEntity.badRequest().body("Cet utilisateur n'existait pas !");
    }
    
}
