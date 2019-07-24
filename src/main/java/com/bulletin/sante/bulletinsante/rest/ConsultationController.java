package com.bulletin.sante.bulletinsante.rest;

import com.bulletin.sante.bulletinsante.DTO.ConsultationDTO;
import com.bulletin.sante.bulletinsante.DTO.RendezVousDTO;
import com.bulletin.sante.bulletinsante.services.ConsultationService;
import com.bulletin.sante.bulletinsante.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

/**
 * @author Mouhamed Ndoye
 * @since 2019-07-16
 * <p>
 * this is a rest controller class providing end points
 * for Consultation and RendezVous class
 */
@RestController
@RequestMapping("/api")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private RendezVousService rendezVousService;

    /**
     * End point that provide a list of consultation
     * it can be access in GET request
     *
     * @return Return list of Consultation object or bad request response
     */
    @GetMapping("/all-consultation")
    public ResponseEntity allConsultation() {
        try {
            return ResponseEntity.ok(consultationService.allConsultation());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * End point that provide adding a consultation
     * It can be access in POST request
     *
     * @param consultationDTO Consultation DTO Object to add
     * @return Return a singleton map
     * success and true if all ok
     * error and false if there is problem in request
     */
    @PostMapping("/add-consultation")
    public ResponseEntity addConsultation(@RequestBody ConsultationDTO consultationDTO) {
        try {
            return ResponseEntity.ok(Collections.singletonMap("success", consultationService.addConsultation(consultationDTO)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Collections.singletonMap("success", false));
        }
    }

    /**
     * End point that provide to get a consultation object by id
     * it can be access in GET request
     *
     * @param id a path parameter to get a consultation
     * @return return consultation object if all ok or a bad request
     */
    @GetMapping("/get-consultation/{id}")
    public ResponseEntity getConsultationById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(consultationService.getConsultationById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * End point that provide a list of RendezVous
     * It can be access in GET request
     *
     * @return return a list of RendezVous object or bad request response
     */
    @GetMapping("/all-rendez-vous")
    public ResponseEntity allRendezVous() {
        try {
            return ResponseEntity.ok(rendezVousService.allRendezVous());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * End point that provide adding a RendezVous
     * It can be access in POST request
     *
     * @param rendezVousDTO RendezVous DTO to add
     * @return return a singleton map ({"success", true} or {"error", false})
     */
    @PostMapping("/add-rendez-vous")
    public ResponseEntity addRendezVous(@RequestBody RendezVousDTO rendezVousDTO) {
        try {
            return ResponseEntity.ok(Collections.singletonMap("success", rendezVousService.addRendezVous(rendezVousDTO)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", false));
        }
    }

    /**
     * End point that provide to get a RendezVous by id
     * It can be access in GET request
     *
     * @param id a path parameter to get a RendezVous
     * @return return RendezVous object if all ok or a bad request
     */
    @GetMapping("/get-rendez-vous/{id}")
    public ResponseEntity getRendezVousById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(consultationService.getConsultationById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
