package com.projet.altn72.entite;

import java.io.Serializable;

import com.projet.altn72.modele.composite.Outil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(Outil.class)
@Table(name = "Outil")
public class OutilEntite implements Serializable {

    @Id
    @Column(name = "titre", length = 150)
    private String titre;

    @Column(name = "domaine", length = 100)
    private String domaine;

    @Column(name = "simpleDesc", length = 500)
    private String simpleDesc;

    @Column(name = "detailledDesc", length = 1000)
    private String detailledDesc;

    @Column(name = "lienURL", length = 1000)
    private String lienURL;

    @Column(name = "acces", length = 350)
    private String acces;
}
