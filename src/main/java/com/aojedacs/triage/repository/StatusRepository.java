package com.aojedacs.triage.repository;

import org.springframework.data.repository.CrudRepository;

import com.aojedacs.triage.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long>{
    
}
