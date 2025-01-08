package com.projet.altn72.entite;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projet.altn72.modele.composite.Utilisateur;

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
@IdClass(Utilisateur.class)
@Table(name= "Utilisateur")
public class UtilisateurEntite implements Serializable {

    @Id
    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Id
    @Column(name = "pseudo", length = 100, nullable = false)
    private String pseudo;

    @Column(name = "motDePasse", length = 100)
    private String motDePasse;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "DOB")
    @JsonProperty("DOB")
    private LocalDate DOB;

    @Column(name = "statut", length = 50)
    private String statut;

    @Column(name = "genre", length = 10)
    private String genre;
}
