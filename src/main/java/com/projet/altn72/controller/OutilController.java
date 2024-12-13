package com.projet.altn72.controller;
import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.service.OutilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/outils")
public class OutilController {

    private final OutilService outilService;

    public OutilController(OutilService outilService) {
        this.outilService = outilService;
    }

    @GetMapping
    public String listOutils(Model model) {
        List<OutilEntite> outils = outilService.getAllOutils();
        model.addAttribute("outils", outils);
        return "outils/list";
    }

    @GetMapping("/{titre}")
    public String getOutil(@PathVariable String titre, Model model) {
        OutilEntite outil = outilService.getOutilByTitre(titre);
        model.addAttribute("outil", outil);
        return "outils/detail";
    }

    @GetMapping("/domaine/{domaine}")
    public String getOutilsByDomaine(@PathVariable String domaine, Model model) {
        List<OutilEntite> outils = outilService.getOutilsByDomaine(domaine);
        model.addAttribute("outils", outils);
        return "outils/list";
    }

    @PostMapping
    public String saveOutil(@ModelAttribute OutilEntite outil) {
        outilService.saveOutil(outil);
        return "redirect:/outils";
    }

    @DeleteMapping("/{titre}")
    public String deleteOutil(@PathVariable String titre) {
        outilService.deleteOutil(titre);
        return "redirect:/outils";
    }
}
