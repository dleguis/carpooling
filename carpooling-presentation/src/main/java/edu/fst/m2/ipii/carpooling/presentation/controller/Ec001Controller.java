package edu.fst.m2.ipii.carpooling.presentation.controller;

import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.TrajetRechercheModel;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
import edu.fst.m2.ipii.carpooling.transverse.dto.TrajetDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.binding.BindingResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Dimitri on 06/04/2015.
 */
@Controller
public class Ec001Controller extends AbstractController {

    @RequestMapping(value = "/recherche-trajet.html", method = RequestMethod.GET)
    public String rechercherTrajet(Model model,
                                   @ModelAttribute("trajetRechercheModel") @Validated TrajetRechercheModel trajetRechercheModel,
                                   BindingResult bindingResult) throws Exception {

        // Validation sur le POJO TrajetRechercheModel
        if (!bindingResult.hasErrors()) {

            // Parsing de la date
            Date dateTrajet;

            if ("".equals(trajetRechercheModel.getDateDepart())) {
                dateTrajet = null;
            }
            else {
                try {
                    dateTrajet = DateTime.parse(trajetRechercheModel.getDateDepart(), DateTimeFormat.forPattern("YYYY-MM-dd")).toDate();
                }
                catch (Exception exception) {
                    dateTrajet = DateTime.parse(trajetRechercheModel.getDateDepart(), DateTimeFormat.forPattern("dd/MM/YYYY")).toDate();
                }

            }

            TrajetCriteria trajetCriteria = TrajetCriteria.builder().villeDepart(trajetRechercheModel.getVilleDepart())
                                                                    .villeArrivee(trajetRechercheModel.getVilleArrivee())
                                                                    .dateDepart(dateTrajet)
                                                                    .build();

            // Recherche de trajets selon les critères remplus
            Set<TrajetDto> trajets = trajetService.rechercher(trajetCriteria);

            model.addAttribute("trajets", trajets);

        }
        else {
            // Création du rapport d'erreur
            String errors = BindingResultUtils.getBindingMessages(bindingResult);

            if (StringUtils.isNotEmpty(errors)) {
                model.addAttribute("errors", errors);
            }
        }

        return "index";
    }
}
