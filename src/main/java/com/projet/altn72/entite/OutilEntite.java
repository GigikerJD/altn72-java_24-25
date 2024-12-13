package com.projet.altn72.entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Outil")
public class OutilEntite{

    @Id
    @Column(name = "titre", length = 150, nullable = false)
    private String titre;

    @Column(name = "domaine", length = 100)
    private String domaine;

    @Column(name = "simpleDesc", length = 500)
    private String simpleDesc;

    @Column(name = "detailledDesc", length = 5000)
    private String detailledDesc;

    @Column(name = "lienURL", length = 1000)
    private String lienURL;

    @Column(name = "acces", length = 350)
    private String acces;
}
