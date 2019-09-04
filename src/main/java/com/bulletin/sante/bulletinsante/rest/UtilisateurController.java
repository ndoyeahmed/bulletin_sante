package com.bulletin.sante.bulletinsante.rest;

import com.bulletin.sante.bulletinsante.models.Utilisateur;
import com.bulletin.sante.bulletinsante.services.UtilisateurService;
import com.bulletin.sante.bulletinsante.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@RequestMapping("/api")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/all-user")
    public ResponseEntity allUser() {
        try {
            return ResponseEntity.ok(utilisateurService.allUser());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all-profile")
    public ResponseEntity allProfile() {
        try {
            return ResponseEntity.ok(utilisateurService.allProfile());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap(Utils.ERROR_CODE, null));
        }
    }

    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody Utilisateur utilisateur) {
        try {
            if (utilisateurService.addUser(utilisateur)) {
                return ResponseEntity.ok(Collections.singletonMap(Utils.SUCCESS_CODE, true));
            } else return ResponseEntity.badRequest().body(Collections.singletonMap(Utils.ERROR_CODE, false));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(Utils.ERROR_CODE, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-user")
    public ResponseEntity updateUser(@RequestBody Utilisateur utilisateur) {
        if (utilisateurService.updateUser(utilisateur)) {
            return ResponseEntity.ok(Collections.singletonMap(Utils.SUCCESS_CODE, true));
        } else return ResponseEntity.badRequest().body(Collections.singletonMap(Utils.ERROR_CODE, false));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginModel userLoginModel) {
        try {
            Utilisateur utilisateur = utilisateurService.login(userLoginModel.getEmail(), userLoginModel.getPassword());
            if (utilisateur != null)
                return ResponseEntity.ok(Collections.singletonMap(Utils.SUCCESS_CODE, utilisateur));
            else
                return ResponseEntity.badRequest().body(Collections.singletonMap(Utils.ERROR_CODE, HttpStatus.FORBIDDEN));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Collections.singletonMap(Utils.ERROR_CODE, HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/get-user-by-id/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long id) {
        Utilisateur utilisateur = utilisateurService.getUserById(id);
        if (utilisateur != null) {
            return ResponseEntity.ok(Collections.singletonMap(Utils.SUCCESS_CODE, utilisateur));
        } else return ResponseEntity.badRequest().body(Collections.singletonMap(Utils.ERROR_CODE, null));
    }

    private static class UserLoginModel {
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
