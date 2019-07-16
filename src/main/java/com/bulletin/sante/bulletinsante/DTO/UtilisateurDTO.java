package com.bulletin.sante.bulletinsante.DTO;

import com.bulletin.sante.bulletinsante.models.Personne;
import com.bulletin.sante.bulletinsante.models.Profile;

import java.io.Serializable;

public class UtilisateurDTO extends Personne implements Serializable {
    private Long id;
    private String email;
    private String password;
    private boolean connected;
    private Profile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
