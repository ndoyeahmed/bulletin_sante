package com.bulletin.sante.bulletinsante.rest;

import com.bulletin.sante.bulletinsante.models.Utilisateur;
import com.bulletin.sante.bulletinsante.services.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@RequestMapping("/api")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }


    @GetMapping("/all-user")
    public ResponseEntity allUser() {
        try {
            return ResponseEntity.ok(utilisateurService.allUser());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody Utilisateur utilisateur) {
        try {
            return new ResponseEntity<>(Collections.singletonMap("success", utilisateurService.addUser(utilisateur)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginModel userLoginModel) {
        try {
            Utilisateur utilisateur = utilisateurService.login(userLoginModel.getEmail(), userLoginModel.getPassword());
            if (utilisateur != null)
                return new ResponseEntity<>(utilisateur, HttpStatus.OK);
            else
                return new ResponseEntity<>("error", HttpStatus.FORBIDDEN);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    private class UserLoginModel {
        private String email;
        private String password;

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
    }
}
