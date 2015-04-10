package edu.fst.m2.ipii.carpooling.presentation.controller;

import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.TrajetRechercheModel;
import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.NouvelleReservationDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.TrajetDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.binding.BindingResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

/**
 * Created by Dimitri on 06/04/2015.
 */
@Controller
public class Ec002Controller extends AbstractController {

    @RequestMapping(value = "/detail-trajet/{id}", method = RequestMethod.GET)
    public String rechercherTrajet(Model model, @PathVariable("id") int id) throws Exception {

        TrajetDto trajet = trajetService.getTrajet(id);

        NouvelleReservationDto nouvelleReservation = new NouvelleReservationDto();
        nouvelleReservation.setTrajetId(trajet.getID());
        nouvelleReservation.setMembreId(getUserProfil().getMembreId());

        model.addAttribute("etatReservation", reservationService.getEtatReservation(trajet.getID(), getUserProfil().getMembreId()));

        model.addAttribute("reservationForm", nouvelleReservation);

        if (getUserProfil().getUsername().equals(trajet.getConducteur())) {
            model.addAttribute("reservations", trajetService.rechercherReservationsEnAttente(id));
        }

        model.addAttribute("moyensPaiement", moyenPaiementService.lister());

        model.addAttribute("pointDepart", trajet.getDepart());
        model.addAttribute("pointArrivee", trajet.getArrivee());
        model.addAttribute("etapes", trajet.getEtapes());

        model.addAttribute("trajet", trajet);

        return "detail-trajet";
    }

    @RequestMapping(value = "/reserver", method = RequestMethod.POST)
    public String reserverTrajet(@ModelAttribute("reservationForm") @Validated NouvelleReservationDto nouvelleReservation, BindingResult result) throws Exception {

        if (!result.hasErrors()) {

            // On évite les modification par des petits malins...
            nouvelleReservation.setMembreId(getUserProfil().getMembreId());

            trajetService.reserver(nouvelleReservation);
        }

        return "redirect:/detail-trajet/" + nouvelleReservation.getTrajetId() + "?reservation=success";
    }

    @RequestMapping(value = "/annuler-reservation.html", method = RequestMethod.GET)
    public String annulerReservation(@ModelAttribute("trajetId") int trajetId) throws Exception {

        reservationService.annulerReservation(trajetId, getUserProfil().getMembreId());

        return "redirect:/detail-trajet/" + trajetId + "?annulation-reservation=success";
    }

    @RequestMapping(value = "/annuler-trajet.html", method = RequestMethod.GET)
    public String annulerTrajet(@ModelAttribute("trajetId") int trajetId) throws Exception {

        trajetService.annuler(trajetId, getUserProfil().getUsername());

        return "redirect:/detail-trajet/" + trajetId + "?annulation-reservation=success";
    }

    @RequestMapping(value = "/valider-reservation.html", method = RequestMethod.GET)
    public String validerReservation(@ModelAttribute("reservationId") int reservationId, @ModelAttribute("trajetId") int trajetId) throws Exception {

        reservationService.changerEtatReservation(reservationId, EtatReservation.VALIDEE);

        return "redirect:/detail-trajet/" + trajetId + "?validation-reservation=success";
    }

    @RequestMapping(value = "/rejeter-reservation.html", method = RequestMethod.GET)
    public String rejeterReservation(@ModelAttribute("reservationId") int reservationId, @ModelAttribute("trajetId") int trajetId) throws Exception {

        reservationService.changerEtatReservation(reservationId, EtatReservation.REJETEE);

        return "redirect:/detail-trajet/" + trajetId + "?rejet-reservation=success";
    }

}
