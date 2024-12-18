package com.projet.altn72.controleur.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UtilisateurEntite>> getTouslesUtilisateurs() {
        List<UtilisateurEntite> users = utilisateurService.getUtilisateurs();
        return users.isEmpty() ?
            ResponseEntity.status(HttpStatusCode.valueOf(404)).build() :
            ResponseEntity.status(200).body(users);  
    }

    @GetMapping("email/{email}")
    public ResponseEntity<UtilisateurEntite>  getUtilisateurParEmail(@PathVariable String email){
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
    public ResponseEntity<String> modifyUtilisateurParPseudo(@PathVariable String oldPseudo, @RequestParam String newPseudo){
        if (oldPseudo.equals(newPseudo))
            return ResponseEntity.badRequest().body("Les pseudos sont identiques");
        
        boolean hasChangePseudo = utilisateurService.changePseudo(oldPseudo, newPseudo);
        return hasChangePseudo ?
            ResponseEntity.status(200).body(String.format("Votre profil au nom de %s a été modifié !", newPseudo)) :
            ResponseEntity.badRequest().body("Échec de la modification. Vérifiez vos informations !");
    }

    
    @PostMapping("/candidate")
    public ResponseEntity<String> createNouvelUtilisateur(@RequestBody UtilisateurEntite user){
        boolean isCreated = utilisateurService.creerNouvelUtilisateur(user);
        return isCreated ? 
            ResponseEntity.ok().body("Votre profil a été créé avec succès !") :
            ResponseEntity.badRequest().body("Ce mail ou pseudo est déjà utilisé !");
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<String> supprimerUtilisateur(@PathVariable String email){
        boolean hasBeenDeleted = utilisateurService.supprimerUtilisateur(email);
        return hasBeenDeleted ?
            ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Votre profil a été supprimée !") :
            ResponseEntity.status(HttpStatusCode.valueOf(404)).body("Le profil de cet email est inexistant !");
    }
    
}
