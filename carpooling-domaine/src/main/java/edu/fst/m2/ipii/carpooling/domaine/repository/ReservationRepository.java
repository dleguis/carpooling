package edu.fst.m2.ipii.carpooling.domaine.repository;

import edu.fst.m2.ipii.carpooling.domaine.bo.Reservation;
import edu.fst.m2.ipii.carpooling.domaine.bo.Trajet;
import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByTrajet_IDAndMembre_ID(int trajetId, int membreId);


    @Query("SELECT t FROM Reservation r, Trajet t WHERE r.membre.ID = :conducteurId AND r.trajet = t AND t.actif = true AND r.etat = :etat")
    List<Trajet> findByConducteur(@Param("conducteurId") int conducteurId, @Param("etat") EtatReservation etat);

    @Query("SELECT t FROM Reservation r, Trajet t WHERE r.membre.ID = :passagerId AND r.trajet = t AND t.actif = true AND (r.etat = 'EN_ATTENTE' OR r.etat = 'VALIDEE')")
    List<Trajet> findByPassager(@Param("passagerId") int passagerId);
}