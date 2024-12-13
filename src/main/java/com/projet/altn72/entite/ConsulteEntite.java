package com.projet.altn72.entite;

import java.io.Serializable;

import com.projet.altn72.modele.composite.Consulte;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Consulte")
@IdClass(Consulte.class)
public class ConsulteEntite implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "email", referencedColumnName = "email"),
        @JoinColumn(name = "pseudo", referencedColumnName = "pseudo")
    })
    private UtilisateurEntite utilisateur;

    @Id
    @ManyToOne
    @JoinColumn(name = "titre", referencedColumnName = "titre")
    private OutilEntite outil;
}
