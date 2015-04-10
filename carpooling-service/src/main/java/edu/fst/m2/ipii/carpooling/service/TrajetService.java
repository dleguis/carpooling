package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.domaine.bo.Reservation;
import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.NouvelleReservationDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.ReservationDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.TrajetDto;

import java.util.List;
import java.util.Set;

/**
 * Created by Dimitri on 05/04/15.
 */
public interface TrajetService {

    List<TrajetDto> rechercher();

    Set<TrajetDto> rechercher(TrajetCriteria trajetCriteria) throws Exception;

    TrajetDto getTrajet(int id);

    int creer(TrajetDto trajetDto) throws Exception;

    void reserver(NouvelleReservationDto nouvelleReservation) throws Exception;

    void annuler(int trajetId, String username);

    List<TrajetDto> rechercherParMembreId(int membreId);

    List<TrajetDto> rechercherParPassagerId(int membreId);

    List<ReservationDto> rechercherReservationsEnAttente(int trajetId);

}
