package com.projet.altn72.modele.composite;

import java.io.Serializable;
import java.util.Objects;

public class Enveloppe implements Serializable {

    private String idFeedback;
    private String titre;

    public Enveloppe() {}

    public Enveloppe(String idFeedback, String titre) {
        this.idFeedback = idFeedback;
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enveloppe that = (Enveloppe) o;
        return Objects.equals(idFeedback, that.idFeedback) && 
               Objects.equals(titre, that.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFeedback, titre);
    }
}
