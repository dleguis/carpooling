package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreRepository  extends JpaRepository<Membre, Integer> {

    List<Membre> findByLogin(String login);
}