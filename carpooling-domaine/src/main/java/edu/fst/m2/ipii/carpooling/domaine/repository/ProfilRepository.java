package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.PointEmbarquement;
import edu.fst.m2.ipii.carpooling.domaine.bo.Profil;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dimitri on 10/04/2015.
 */
public interface ProfilRepository extends JpaRepository<Profil, Integer> {
}
