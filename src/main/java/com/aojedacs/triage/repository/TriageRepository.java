package com.aojedacs.triage.repository;

import org.springframework.data.repository.CrudRepository;

import com.aojedacs.triage.model.Triage;

public interface TriageRepository extends CrudRepository<Triage, Long>{
    
}
