package com.projet.altn72.modele.composite;

import java.io.Serializable;
import java.util.Objects;

public class Consulte implements Serializable {
    private String email;
    private String pseudo;
    private String titre;

    public Consulte() {}

    public Consulte(String email, String pseudo, String titre) {
        this.email = email;
        this.pseudo = pseudo;
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulte that = (Consulte) o;
        return Objects.equals(email, that.email) && 
               Objects.equals(pseudo, that.pseudo) && 
               Objects.equals(titre, that.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, pseudo, titre);
    }
}
