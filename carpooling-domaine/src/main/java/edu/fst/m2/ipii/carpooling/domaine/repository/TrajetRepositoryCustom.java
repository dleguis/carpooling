package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Trajet;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;

import java.util.List;

/**
 * Created by Dimitri on 05/04/15.
 */
public interface TrajetRepositoryCustom {

    List<Trajet> findByCriteria(TrajetCriteria trajetCriteria);
}
