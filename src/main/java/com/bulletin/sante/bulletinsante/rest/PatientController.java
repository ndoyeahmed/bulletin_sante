package com.bulletin.sante.bulletinsante.rest;

import com.bulletin.sante.bulletinsante.models.Patient;
import com.bulletin.sante.bulletinsante.services.PatientService;
import com.bulletin.sante.bulletinsante.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

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
    public ResponseEntity addOrUpdatePatient(@RequestBody Patient patient) {
        try {
            if (patientService.addOrUpdatePatient(patient)) {
                return ResponseEntity.ok(Collections.singletonMap(Utility.SUCCESS_CODE, true));
            } else {
                return ResponseEntity.badRequest().body(Collections.singletonMap(Utility.ERROR_CODE, false));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update-patient")
    public ResponseEntity updatePatient(@RequestBody Patient patient) {
        try {
            if (patientService.addOrUpdatePatient(patient)) {
                return ResponseEntity.ok(Collections.singletonMap(Utility.SUCCESS_CODE, true));
            } else return ResponseEntity.badRequest().body(Collections.singletonMap(Utility.ERROR_CODE, false));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/get-patient/{id}")
    public ResponseEntity getPatientById(@PathVariable("id") Long id) {
        try {
            Patient patient = patientService.getPatientById(id);
            if (patient != null) {
                return ResponseEntity.ok(Collections.singletonMap(Utility.SUCCESS_CODE, patient));
            } else {
                return ResponseEntity.badRequest().body(Collections.singletonMap(Utility.ERROR_CODE, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get-patient/{id}")
    public ResponseEntity patientById(@PathVariable("id") Long id) {
        try {
            Patient patient = patientService.getPatientById(id);
            if (patient != null) {
                return ResponseEntity.ok(Collections.singletonMap(Utility.SUCCESS_CODE, patient));
            } else {
                return ResponseEntity.badRequest().body(Collections.singletonMap(Utility.ERROR_CODE, null));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
