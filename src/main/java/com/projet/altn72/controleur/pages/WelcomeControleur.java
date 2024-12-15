package com.projet.altn72.controleur.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeControleur {

    @GetMapping("")
    public String PageDeBienvenue(){
        return "accueil"; //Page d'accueil 'accueil.html'
    }
}
