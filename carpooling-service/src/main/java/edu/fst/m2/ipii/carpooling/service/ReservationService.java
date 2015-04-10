package edu.fst.m2.ipii.carpooling.service;

import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.dto.MoyenPaiementDto;

import java.util.List;

/**
 * Created by Dimitri on 05/04/15.
 */
public interface ReservationService {

    EtatReservation getEtatReservation(int trajetId, int membreId);

    void annulerReservation(int trajetId, int reservationId);

    void changerEtatReservation(int reservationId, EtatReservation etat);
}
