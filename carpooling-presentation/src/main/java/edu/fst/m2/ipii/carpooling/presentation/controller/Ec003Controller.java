package edu.fst.m2.ipii.carpooling.presentation.controller;

import edu.fst.m2.ipii.carpooling.domaine.bo.Voiture;
import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.TrajetCreationForm;
import edu.fst.m2.ipii.carpooling.presentation.model.UserModificationModel;
import edu.fst.m2.ipii.carpooling.presentation.model.VoitureForm;
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

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Date;

/**
 * Created by Dimitri on 10/04/2015.
 */
@Controller
public class Ec003Controller extends AbstractController {

    @RequestMapping(value = "/mon-compte.html", method = RequestMethod.GET)
    public String monCompte(Model model) {

        model.addAttribute("membre", membreService.rechercher(getUserProfil().getMembreId()));
        model.addAttribute("userModel", new UserModificationModel());

        return "mon-compte";
    }

    @RequestMapping(value = "/mon-compte.html", method = RequestMethod.POST)
     public String postInscription(Model model, @ModelAttribute("userModel") @Validated UserModificationModel userModificationModel,
                                   BindingResult bindingResult) {

        MembreDto membreDto = membreService.rechercher(getUserProfil().getMembreId());

        if (!bindingResult.hasErrors() && membreDto.getPassword().equals(userModificationModel.getPassword())) {

            // Création du UserDto à envoyer hghg
            MembreDto user = new MembreDto();
            user.setID(getUserProfil().getMembreId());
            user.setLogin(getUserProfil().getUsername());

            if (StringUtils.isNotBlank(userModificationModel.getNewPassword())) {
                user.setPassword(userModificationModel.getNewPassword());
            }
            else {
                user.setPassword(userModificationModel.getPassword());
            }

            user.setEmail(userModificationModel.getEmail());
            user.setNomMembre(userModificationModel.getLastName());
            user.setPrenomMembre(userModificationModel.getFirstName());

            membreService.save(user);
            return "redirect:/mon-compte.html?success";

        }
        else {
            model.addAttribute("errors", BindingResultUtils.getBindingMessages(bindingResult));
            return monCompte(model);
        }

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

    @RequestMapping(value = "/mes-voitures.html", method = RequestMethod.GET)
    public String getMesVoitures(Model model) {

        model.addAttribute("voitures", voitureService.rechercherParMembre(getUserProfil().getMembreId()));

        return "mes-voitures";
    }

    @RequestMapping(value = "/supprimer-voiture.html", method = RequestMethod.GET)
    public String supprimerVoiture(@ModelAttribute("voitureId") int voitureId) throws Exception {

        voitureService.supprimerVoiture(voitureId, getUserProfil().getMembreId());

        return "redirect:/mes-voitures.html";
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


    @RequestMapping(value = "/creer-voiture.html", method = RequestMethod.GET)
    public String getPageCreationVoiture(Model model) {


        model.addAttribute("voitureForm", new VoitureForm());

        return "creer-voiture";
    }

    @RequestMapping(value = "/creer-voiture.html", method = RequestMethod.POST)
    public String creerVoiture(Model model, @ModelAttribute("voitureForm") @Validated VoitureForm voitureForm,
                               BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {

            VoitureDto voiture = new VoitureDto();

            voiture.setMarque(voitureForm.getMarque());
            voiture.setModele(voitureForm.getModele());
            voiture.setNbPlaces(voitureForm.getNbPlaces());
            voiture.setCarburant(voitureForm.getCarburant());
            voiture.setCategorie(voitureForm.getCategorie());
            voiture.setPuissance(voitureForm.getPuissance());

            voitureService.creer(voiture, getUserProfil().getMembreId());

            return "redirect:/mes-voitures.html";

        }
        else {
            model.addAttribute("errors", BindingResultUtils.getBindingMessages(bindingResult));
            return getPageCreationVoiture(model);
        }
    }

    @RequestMapping(value = "/creer-trajet.html", method = RequestMethod.POST)
    public String creerTrajet(Model model, @ModelAttribute("trajetForm") @Validated TrajetCreationForm trajetCreationForm,
                              BindingResult bindingResult) throws Exception {

        if (!bindingResult.hasErrors()) {

            Date dateExecution;

            if ("".equals(trajetCreationForm.getDateDepart())) {
                dateExecution = null;
            }
            else {
                try {
                    dateExecution  = DateTime.parse(trajetCreationForm.getDateDepart(), DateTimeFormat.forPattern("YYYY-MM-dd")).toDate();
                }
                catch (Exception exception) {
                    dateExecution  = DateTime.parse(trajetCreationForm.getDateDepart(), DateTimeFormat.forPattern("dd/MM/YYYY")).toDate();
                }

            }

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
