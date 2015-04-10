package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.domaine.bo.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Integer> {

    @Query("SELECT m.voitures FROM Membre m WHERE m.ID = :membreId")
    List<Voiture> findByConducteur(@Param("membreId") int membreId);
}