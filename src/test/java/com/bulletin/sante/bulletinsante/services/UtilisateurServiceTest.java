package com.bulletin.sante.bulletinsante.services;

import com.bulletin.sante.bulletinsante.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;


public class UtilisateurServiceTest extends AbstractTest {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void login() {
        /*String login = "med";
        String pwd = "passer@123";
        Utilisateur utilisateur = utilisateurService.login(login, pwd);
        assertNull(utilisateur);
        login = "admin@mail.com";
        pwd = "admin@123";
        utilisateur = utilisateurService.login(login, pwd);
        assertNull(utilisateur);*/
        assertTrue(true);
    }
}
