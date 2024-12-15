package com.projet.altn72.controleur.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.projet.altn72.entite.OutilEntite;
import com.projet.altn72.service.OutilService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/outils")
public class OutilControleur {

    @Autowired
    private OutilService outilService;

    @GetMapping("")
    public ResponseEntity<List<OutilEntite>> getTouslesOutils(){
        return ResponseEntity.ok(outilService.getOutils());
    }

    @GetMapping("/{titre}/detailledDesc")
    public ResponseEntity<String> getDescriptionDetaille(@PathVariable String titre) {
        String result = outilService.getDetailledDescFrom(titre);
        if ("Description détaillée non présente...".equals(result)) {
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result); 
    }

    
    
    
}
