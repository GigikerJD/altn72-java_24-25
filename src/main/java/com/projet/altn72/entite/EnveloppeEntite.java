package com.projet.altn72.entite;

import java.io.Serializable;

import com.projet.altn72.modele.composite.Enveloppe;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Enveloppe")
@IdClass(Enveloppe.class)
public class EnveloppeEntite implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idFeedback", referencedColumnName = "idFeedback")
    private FeedbackEntite feedback;

    @Id
    @ManyToOne
    @JoinColumn(name = "titre", referencedColumnName = "titre")
    private OutilEntite outil;
}
