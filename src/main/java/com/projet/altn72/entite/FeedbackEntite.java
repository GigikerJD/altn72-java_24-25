package com.projet.altn72.entite;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "Feedback")
public class FeedbackEntite implements Serializable{

    @Id
    @Column(name = "idFeedback", length = 100)
    private String idFeedback;

    @Column(name = "textFeedback", length = 500)
    private String textFeedback;

    @Column(name = "dateFeedback")
    @JsonProperty("dateFeedback")
    private LocalDate dateFeedback;

    @Column(name = "pseudoUser", length = 100)
    private String pseudoUser;
}
