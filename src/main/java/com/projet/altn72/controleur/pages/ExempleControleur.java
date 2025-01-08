package com.projet.altn72.controleur.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExempleControleur {

    @GetMapping("/exemple")
    public String afficherExemple(Model model) {
        model.addAttribute("maValeur", "Bonjour, utilisateur !");
        return "exemple";
    }
}
