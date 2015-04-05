package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.PointEmbarquement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointEmbarquementRepository extends JpaRepository<PointEmbarquement, Integer> {

}