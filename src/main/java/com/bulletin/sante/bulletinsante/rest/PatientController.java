package com.bulletin.sante.bulletinsante.rest;

import com.bulletin.sante.bulletinsante.DTO.PatientDTO;
import com.bulletin.sante.bulletinsante.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all-patient")
    public ResponseEntity allPatient() {
        try {
            return ResponseEntity.ok(patientService.allPatient());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add-patient")
    public ResponseEntity addOrUpdatePatient(@RequestBody PatientDTO patientDTO) {
        try {
            return ResponseEntity.ok(Collections.singletonMap("success", patientService.addOrUpdatePatient(patientDTO)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get-patient/{id}")
    public ResponseEntity getPatientById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(patientService.getPatientById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
