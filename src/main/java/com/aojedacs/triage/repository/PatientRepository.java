package com.aojedacs.triage.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.aojedacs.triage.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{
    
}
