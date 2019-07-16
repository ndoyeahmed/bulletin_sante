package com.bulletin.sante.bulletinsante.DTO;

import com.bulletin.sante.bulletinsante.models.Personne;

import java.io.Serializable;

public class PatientDTO extends Personne implements Serializable {
    private Long id;
    private char genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }
}
