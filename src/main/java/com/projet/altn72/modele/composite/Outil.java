package com.projet.altn72.modele.composite;

import java.io.Serializable;
import java.util.Objects;

public class Outil implements Serializable {
    private String titre;

    public Outil(){}
    public Outil(String titre){
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        else{
            Outil that = (Outil) o;
            return Objects.equals(titre, that.titre);
        } 
    }

    @Override
    public int hashCode(){
        return Objects.hash(titre);
    }
}
