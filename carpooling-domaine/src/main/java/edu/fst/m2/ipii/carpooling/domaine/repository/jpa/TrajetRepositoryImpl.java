package edu.fst.m2.ipii.carpooling.domaine.repository.jpa;

import edu.fst.m2.ipii.carpooling.domaine.bo.PointEmbarquement;
import edu.fst.m2.ipii.carpooling.domaine.bo.Trajet;
import edu.fst.m2.ipii.carpooling.domaine.repository.TrajetRepositoryCustom;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dimitri on 05/04/15.
 */
public class TrajetRepositoryImpl implements TrajetRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Trajet> findByCriteria(TrajetCriteria trajetCriteria) {



        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Trajet> query = cb.createQuery(Trajet.class);

        Root<Trajet> b = query.from(Trajet.class);

        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isBlank(trajetCriteria.getVilleDepart())) {
            predicates.add(cb.like(b.get("villeDepart"), "%" + trajetCriteria.getVilleDepart() + "%"));
        }
        if (!StringUtils.isBlank(trajetCriteria.getVilleArrivee())) {
            predicates.add(cb.like(b.get("villeArrivee"), "%" + trajetCriteria.getVilleArrivee() + "%"));
        }
        if (trajetCriteria.getDateDepart() != null) {
            predicates.add(cb.lessThanOrEqualTo(b.<Date> get("dateDepart"), trajetCriteria.getDateDepart()));

        }

        // Metamodel m = em.getMetamodel();
        // EntityType<PointEmbarquement> PointEmbarquement_ = m.entity(PointEmbarquement.class);

        // Join<Trajet, PointEmbarquement> p = b.join(PointEmbarquement_.latitude);

        // t.fetch(Team_.players);
        // c.select(t).where(cb.equal(p.get(Player_.age), age));

        query.select(b).where(predicates.toArray(new Predicate[] {}));

        return em.createQuery(query).getResultList();
    }
}
