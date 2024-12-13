package com.projet.altn72.modele.composite;

import java.io.Serializable;
import java.util.Objects;

public class Feedback implements Serializable{

    private String idFeedback;

    public Feedback(){}
    public Feedback(String idFeedback){
        this.idFeedback = idFeedback;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback that = (Feedback) o;
        return Objects.equals(idFeedback, that.idFeedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFeedback);
    }
}
