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

import com.aojedacs.triage.model.Triage;
import com.aojedacs.triage.repository.TriageRepository;

@RestController
@RequestMapping("/api/triage")
public class TriageController {

    @Autowired
    private TriageRepository triageRepository;

    @GetMapping
    public Iterable<Triage> findAllTriage() {
        return triageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Triage> findTriageById(@PathVariable(value = "id") long id) {
        Optional<Triage> triage = triageRepository.findById(id);

        if (triage.isPresent()) {
            return ResponseEntity.ok().body(triage.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Triage saveTriage(@Validated @RequestBody Triage triage) {
        return triageRepository.save(triage);
    }
}
