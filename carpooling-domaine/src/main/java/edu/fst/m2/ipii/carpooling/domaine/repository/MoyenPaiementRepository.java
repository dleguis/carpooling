package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.domaine.bo.MoyenPaiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoyenPaiementRepository extends JpaRepository<MoyenPaiement, Integer> {

}