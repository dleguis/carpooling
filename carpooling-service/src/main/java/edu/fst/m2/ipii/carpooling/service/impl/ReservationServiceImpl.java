package edu.fst.m2.ipii.carpooling.service.impl;

import edu.fst.m2.ipii.carpooling.domaine.bo.Membre;
import edu.fst.m2.ipii.carpooling.domaine.bo.Reservation;
import edu.fst.m2.ipii.carpooling.service.ReservationService;
import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.exception.CarpoolingFonctionnelleException;
import edu.fst.m2.ipii.carpooling.transverse.exception.code.CarpoolingFonctionnelleExceptionCode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dimitri on 09/04/2015.
 */
@Service
public class ReservationServiceImpl extends AbstractServiceImpl implements ReservationService {

    @Override
    public EtatReservation getEtatReservation(int trajetId, int membreId) {
        List<Reservation> reservations = reservationRepository.findByTrajet_IDAndMembre_ID(trajetId, membreId);

        if (null != reservations) {
            for (Reservation reservation : reservations) {
                if (!EtatReservation.ANNULEE.equals(reservation.getEtat())) {
                    return reservation.getEtat();
                }
            }
        }

        return null;
    }

    @Override
    public void annulerReservation(int trajetId, int reservationId) {
        List<Reservation> reservations = reservationRepository.findByTrajet_IDAndMembre_ID(trajetId, reservationId);

        if (null != reservations) {
            for (Reservation reservation : reservations) {
                if (EtatReservation.EN_ATTENTE.equals(reservation.getEtat()) || EtatReservation.VALIDEE.equals(reservation.getEtat())) {
                    reservation.setEtat(EtatReservation.ANNULEE);

                    Membre conducteur = membreRepository.findByLogin(reservation.getTrajet().getConducteur());

                    emailService.envoyer("Dogecar<noreply@dogecar.com>",
                            conducteur.getEmail(),
                            "Annulation d'une réservation",
                            "Bonjour " + conducteur.getPrenomMembre() +
                                    ", \n\n L'utilisateur " + reservation.getMembre().getLogin() + " a annulé sa réservation pour le trajet "
                                    + reservation.getTrajet().getTitre() + ". \n\n Cordialement.");
                }
            }
        }

        reservationRepository.save(reservations);
    }

    @Override
    public void changerEtatReservation(int reservationId, EtatReservation etat) {
        Reservation reservation = reservationRepository.findOne(reservationId);

        if (reservation == null) {
            throw new CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode.ERR_RESA_001);
        }

        reservation.setEtat(etat);

        reservationRepository.save(reservation);

        Membre conducteur = membreRepository.findByLogin(reservation.getTrajet().getConducteur());

        emailService.envoyer("Dogecar<noreply@dogecar.com>",
                reservation.getMembre().getEmail(),
                "Annulation d'une réservation",
                "Bonjour " + reservation.getMembre().getPrenomMembre() +
                        ", \n\n L'utilisateur " + conducteur.getLogin() + " a changé votre réservation à l'état " + reservation.getEtat() + " pour le trajet "
                        + reservation.getTrajet().getTitre() + ". \n\n Cordialement.");
    }
}
