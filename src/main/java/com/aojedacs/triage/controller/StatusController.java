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

import com.aojedacs.triage.model.Status;
import com.aojedacs.triage.repository.StatusRepository;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public Iterable<Status> findAllStatus(){
        return statusRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> findStatusById(@PathVariable(value="id") long id){

        Optional<Status> status = statusRepository.findById(id);

        if(status.isPresent()){
            return ResponseEntity.ok().body(status.get());
        }else{
            return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping
    public Status saveStatus(@Validated @RequestBody Status status){
        return statusRepository.save(status);
    }
    
}
