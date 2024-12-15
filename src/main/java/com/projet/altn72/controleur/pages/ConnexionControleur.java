package com.projet.altn72.controleur.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.projet.altn72.entite.UtilisateurEntite;
import com.projet.altn72.service.UtilisateurService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/account")
public class ConnexionControleur {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @PostMapping("/login")
    public String LoginProcess(Model model){
        StringBuilder nextPage = new StringBuilder();
        model.addAttribute("utilisateur", new UtilisateurEntite());
        UtilisateurEntite isEnlisted = utilisateurService.getUtilisateurParEmail(
            model.getAttribute("email").toString()
        );
        if(isEnlisted != null){
            String typedPassword = model.getAttribute("password").toString();
            if(isEnlisted.getMotDePasse().equals(typedPassword)){
                switch(isEnlisted.getStatut()){
                    case "STUDENT":
                        nextPage.append("espace-etudiant");
                        break;
                    case "TEACHER":
                        nextPage.append("espace-enseignant");
                        break;
                    case "ADMIN":
                        nextPage.append("espace-admin");
                        break;
                }
            }
            
        }else{
            return "login";
        }
        return nextPage.toString();
    }
    
}
