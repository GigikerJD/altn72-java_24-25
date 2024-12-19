package com.projet.altn72.controleur.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/succes")
public class SuccesControleur {

    @GetMapping("")
    public String afficherPageSucces(){
        return "succes";
    }
}
