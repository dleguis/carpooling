package edu.fst.m2.ipii.carpooling.presentation.controller;

import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.TrajetCreationForm;
import edu.fst.m2.ipii.carpooling.presentation.model.UserInscriptionModel;
import edu.fst.m2.ipii.carpooling.transverse.constants.EtatReservation;
import edu.fst.m2.ipii.carpooling.transverse.dto.*;
import edu.fst.m2.ipii.carpooling.transverse.utils.binding.BindingResultUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by Dimitri on 10/04/2015.
 */
@Controller
public class Ec003Controller extends AbstractController {

    @RequestMapping(value = "/mon-compte.html", method = RequestMethod.GET)
    public String monCompte(Model model) {

        model.addAttribute("membre", membreService.rechercher(getUserProfil().getMembreId()));
        model.addAttribute("userModel", new UserInscriptionModel());

        return "mon-compte";
    }

    @RequestMapping(value = "/mon-compte.html", method = RequestMethod.POST)
     public String postInscription(Model model, @ModelAttribute("userModel") @Validated UserInscriptionModel userInscriptionModel,
                                   BindingResult bindingResult) {


        // Création du UserDto à envoyer hghg
        MembreDto user = new MembreDto();
        user.setPassword(userInscriptionModel.getPassword());
        user.setEmail(userInscriptionModel.getEmail());
        user.setNomMembre(userInscriptionModel.getLastName());
        user.setPrenomMembre(userInscriptionModel.getFirstName());

        membreService.save(user);
        return "redirect:/mon-compte.html?success";


    }

    @RequestMapping(value = "/mes-trajets.html", method = RequestMethod.GET)
    public String getMesTrajets(Model model) {

        model.addAttribute("trajets", trajetService.rechercherParMembreId(getUserProfil().getMembreId()));

        return "mes-trajets";
    }

    @RequestMapping(value = "/mes-reservations.html", method = RequestMethod.GET)
    public String getMesReservations(Model model) {

        model.addAttribute("trajets", trajetService.rechercherParPassagerId(getUserProfil().getMembreId()));

        return "mes-trajets";
    }

    @RequestMapping(value = "/creer-trajet.html", method = RequestMethod.GET)
    public String getPageCreationTrajet(Model model) {

        if (CollectionUtils.isEmpty(membreService.rechercher(getUserProfil().getMembreId()).getVoitures())) {
            return "enregistrer-voiture";
        }

        model.addAttribute("trajetForm", new TrajetCreationForm());
        model.addAttribute("voitures", membreService.rechercherVoitures(getUserProfil().getMembreId()));

        return "creer-trajet";
    }

    @RequestMapping(value = "/creer-trajet.html", method = RequestMethod.POST)
    public String creerTrajet(Model model, @ModelAttribute("trajetForm") @Validated TrajetCreationForm trajetCreationForm,
                              BindingResult bindingResult) throws Exception {

        if (!bindingResult.hasErrors()) {

            Date dateExecution = DateTime.parse(trajetCreationForm.getDateDepart(), DateTimeFormat.forPattern("YYYY-MM-dd")).toDate();

            // Paiement
            PaiementDto paiement = new PaiementDto();
            paiement.setSomme(0);
            paiement.setMoyenPaiement(moyenPaiementService.rechercher(1));

            // Facture
            FactureDto facture = new FactureDto();
            facture.setPaiement(paiement);
            facture.setDateFacture(dateExecution);

            // Points embarquement
            PointEmbarquementDto depart = new PointEmbarquementDto();
            depart.setLibelle(trajetCreationForm.getAdresseDepart());
            depart.setLatitude(0d);
            depart.setLongitude(0d);

            PointEmbarquementDto arrivee = new PointEmbarquementDto();
            arrivee.setLibelle(trajetCreationForm.getAdresseArrivee());
            arrivee.setLatitude(0d);
            arrivee.setLongitude(0d);

            // Membre
            MembreDto membre = membreService.rechercher(getUserProfil().getMembreId());

            // Reservation
            ReservationDto reservation = new ReservationDto();
            reservation.setDateReservation(dateExecution);
            reservation.setFacture(facture);
            reservation.setInitiale(true);
            reservation.setMembre(membre);
            reservation.setNombrePassagers(trajetCreationForm.getNbUtilisateursInitiaux());
            reservation.setTarif(new Float(trajetCreationForm.getPrix()));
            reservation.setPointEmbarquement(depart);
            reservation.setEtat(EtatReservation.INITIALE);

            // Trajet
            TrajetDto trajet = new TrajetDto();
            trajet.setDateDepart(dateExecution);
            trajet.setArrivee(arrivee);
            trajet.setTitre(trajetCreationForm.getTitre());
            trajet.setVoiture(membre.getVoitureWithId(trajetCreationForm.getVoitureId()));
            trajet.getReservations().add(reservation);

            int idTrajetCree = trajetService.creer(trajet);

            return "redirect:/detail-trajet/" + idTrajetCree;
        }

        String errors = BindingResultUtils.getBindingMessages(bindingResult);

        if (StringUtils.isNotEmpty(errors)) {
            model.addAttribute("errors", errors);
        }

        if (CollectionUtils.isEmpty(membreService.rechercher(getUserProfil().getMembreId()).getVoitures())) {
            return "enregistrer-voiture";
        }

        model.addAttribute("trajetForm", new TrajetCreationForm());
        model.addAttribute("voitures", membreService.rechercherVoitures(getUserProfil().getMembreId()));

        return "creer-trajet";
    }

}
