package com.bulletin.sante.bulletinsante.rest;

import com.bulletin.sante.bulletinsante.AbstractTest;
import com.bulletin.sante.bulletinsante.models.Profile;
import com.bulletin.sante.bulletinsante.models.Utilisateur;
import com.bulletin.sante.bulletinsante.utils.Utilitaire;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UtilisateurControllerTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void allUserTest() throws Exception {
        String uri = "/api/all-user";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Utilisateur[] utilisateurs = super.mapFromJson(content, Utilisateur[].class);
        assertTrue(utilisateurs.length > 0);
    }

    @Test
    public void addUser() throws Exception {
        String uri = "/api/add-user";
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setConnected(true);
        utilisateur.setEmail("moumet1995@gmail.com");
        utilisateur.setPassword("passer@123");
        utilisateur.setNom("NDOYE");
        utilisateur.setPrenom("Mouhamed");
        utilisateur.setAdresse("Ouakam");
        utilisateur.setTelephone("774315331");
        Profile profile = new Profile();
        profile.setId(1L);
        utilisateur.setProfile(profile);
        String inputJson = super.mapToJson(utilisateur);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, super.mapToJson(Collections.singletonMap(Utilitaire.SUCCESS_CODE, true)));
    }

    @Test
    public void addBaddUser() throws Exception {
        String uri = "/api/add-user";
        Profile profile = new Profile();
        profile.setId(1L);
        profile.setLibelle("Ad");
        String inputJson = super.mapToJson(profile);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(Utilitaire.ERROR_CODE, content);
    }
}
