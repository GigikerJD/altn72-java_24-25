package com.projet.altn72.entite;

import java.time.LocalDate;

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
public class FeedbackEntite {

    @Id
    @Column(name = "idFeedback", length = 100)
    private String idFeedback;

    @Column(name = "textFeedback", length = 50)
    private String textFeedback;

    @Column(name = "dateFeedback")
    private LocalDate dateFeedback;
}
