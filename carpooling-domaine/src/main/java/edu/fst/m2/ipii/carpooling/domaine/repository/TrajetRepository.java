package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public interface TrajetRepository extends JpaRepository<Trajet, Integer>, TrajetRepositoryCustom {

    @Query("SELECT t " +
            "FROM Trajet t, IN(t.reservations) r " +
            "LEFT JOIN FETCH t.reservations " +
            "WHERE t.arrivee.latitude = :latArrivee AND t.arrivee.longitude = :lngArrivee " +
            "AND t.dateDepart BETWEEN :dateDepartDebut AND :dateDepartFin " +
            "AND r.initiale = true " +
            "AND r.pointEmbarquement.latitude = :latDepart " +
            "AND r.pointEmbarquement.longitude = :lngDepart")
    List<Trajet> findTrajetByCriteria(@Param("latDepart") double latDepart,
                                      @Param("lngDepart") double lngDepart,
                                      @Param("latArrivee") double latArrivee,
                                      @Param("lngArrivee") double lngArrivee,
                                      @Param("dateDepartDebut") Date dateDepartDebut,
                                      @Param("dateDepartFin") Date dateDepartFin);

    @Query("SELECT t FROM Trajet t " +
            "LEFT JOIN FETCH t.reservations " +
            "LEFT JOIN FETCH t.commentaires " +
            "WHERE t.ID = :id")
    Trajet findOneFetch(@Param("id") int id);
}