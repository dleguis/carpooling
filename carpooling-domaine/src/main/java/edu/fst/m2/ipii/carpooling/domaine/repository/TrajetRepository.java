package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Reservation;
import edu.fst.m2.ipii.carpooling.domaine.bo.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface TrajetRepository extends JpaRepository<Trajet, Integer>, TrajetRepositoryCustom {

    @Query("SELECT t FROM Trajet t WHERE t.actif = true")
    List<Trajet> findAllActif();

    @Query("SELECT r FROM Trajet t, Reservation r WHERE t.ID = :trajetId AND r.trajet = t AND r.etat = 'EN_ATTENTE'")
    List<Reservation> findAllReservationsEnAttente(@Param("trajetId") int trajetId);

    /* @Query("SELECT t " +
            "FROM Trajet t, IN(t.reservations) r " +
            "LEFT JOIN FETCH t.reservations " +
            "WHERE t.arrivee.latitude = :latArrivee AND t.arrivee.longitude = :lngArrivee " +
            "AND t.dateDepart BETWEEN :dateDepartDebut AND :dateDepartFin " +
            "AND r.initiale = true " +
            "AND r.pointEmbarquement.latitude = :latDepart " +
            "AND r.pointEmbarquement.longitude = :lngDepart")*/
    @Query(value = "SELECT t.*,\n" +
            "  COALESCE(( 6371 * acos( cos( radians(:latArrivee) )\n" +
            "                 * cos( radians( tp.Latitude ) )\n" +
            "                 * cos( radians( tp.Longitude ) - radians(:lngArrivee) )\n" +
            "                 + sin( radians(:latArrivee) ) * sin( radians( tp.Latitude ) ) ) ), 0) AS distance1,\n" +
            "  COALESCE(( 6371 * acos( cos( radians(:latDepart) )\n" +
            "                 * cos( radians( rp.Latitude ) )\n" +
            "                 * cos( radians( rp.Longitude ) - radians(:lngDepart) )\n" +
            "                 + sin( radians(:latDepart) ) * sin( radians( rp.Latitude ) ) ) ), 0) AS distance2\n" +
            "FROM trajet t, pointembarquement tp, pointembarquement rp, reservation r\n" +
            "WHERE t.PointEmbarquementID = tp.ID\n" +
            "      AND rp.ReservationID = r.ID\n" +
            "      AND t.actif = 1\n" +
            "      AND t.DateDepart BETWEEN :dateDepartDebut AND :dateDepartFin \n" +
            "HAVING distance1 < 25 AND distance2 < 25 ORDER BY distance1, distance2 LIMIT 0 , 20", nativeQuery = true)
    Set<Trajet> findTrajetByCriteria(
                                      @Param("latDepart") double latDepart,
                                      @Param("lngDepart") double lngDepart,
                                      @Param("latArrivee") double latArrivee,
                                      @Param("lngArrivee") double lngArrivee,
                                      @Param("dateDepartDebut") Date dateDepartDebut,
                                      @Param("dateDepartFin") Date dateDepartFin
                                      );


    @Query(value = "SELECT t.*,\n" +
            "  COALESCE(( 6371 * acos( cos( radians(:latArrivee) )\n" +
            "                 * cos( radians( tp.Latitude ) )\n" +
            "                 * cos( radians( tp.Longitude ) - radians(:lngArrivee) )\n" +
            "                 + sin( radians(:latArrivee) ) * sin( radians( tp.Latitude ) ) ) ), 0) AS distance1,\n" +
            "  COALESCE(( 6371 * acos( cos( radians(:latDepart) )\n" +
            "                 * cos( radians( rp.Latitude ) )\n" +
            "                 * cos( radians( rp.Longitude ) - radians(:lngDepart) )\n" +
            "                 + sin( radians(:latDepart) ) * sin( radians( rp.Latitude ) ) ) ), 0) AS distance2\n" +
            "FROM trajet t, pointembarquement tp, pointembarquement rp, reservation r\n" +
            "WHERE t.PointEmbarquementID = tp.ID\n" +
            "      AND rp.ReservationID = r.ID\n" +
            "      AND t.actif = 1\n" +
            "HAVING distance1 < 25 AND distance2 < 25 ORDER BY distance1, distance2 LIMIT 0 , 20", nativeQuery = true)
    Set<Trajet> findTrajetByCriteriaAlt(
            @Param("latDepart") double latDepart,
            @Param("lngDepart") double lngDepart,
            @Param("latArrivee") double latArrivee,
            @Param("lngArrivee") double lngArrivee
    );

    @Query("SELECT t FROM Trajet t " +
            "LEFT JOIN FETCH t.reservations " +
            "LEFT JOIN FETCH t.commentaires " +
            "WHERE t.ID = :id AND t.actif = true")
    Trajet findOneFetch(@Param("id") int id);
}