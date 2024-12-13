package com.projet.altn72.modele.composite;

import java.io.Serializable;
import java.util.Objects;

public class Utilisateur implements Serializable {
    private String email;
    private String pseudo;

    public Utilisateur() {}

    public Utilisateur(String email){
        this.email = email;
    }

    public Utilisateur(String email, String pseudo) {
        this.email = email;
        this.pseudo = pseudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(email, that.email) &&
               Objects.equals(pseudo, that.pseudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, pseudo);
    }
}
