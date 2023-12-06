package com.aojedacs.triage.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aojedacs.triage.model.Patient;
import com.aojedacs.triage.repository.PatientRepository;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public Iterable<Patient> findAllPatients(){
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable(value="id") long id){

        Optional<Patient> patient = patientRepository.findById(id);

        if(patient.isPresent()){
            return ResponseEntity.ok().body(patient.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }    

    @PostMapping
    public Patient savePatient(@Validated @RequestBody Patient patient){
        return patientRepository.save(patient);
    }
}
