package com.aojedacs.triage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Status {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String status;
}
