package edu.fst.m2.ipii.carpooling.presentation.controller;

import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.TrajetRechercheModel;
import edu.fst.m2.ipii.carpooling.transverse.criteria.TrajetCriteria;
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

        model.addAttribute("trajet", trajet);

        return "detail-trajet";
    }
}
