package edu.fst.m2.ipii.carpooling.presentation.rest;

import edu.fst.m2.ipii.carpooling.service.TrajetService;
import edu.fst.m2.ipii.carpooling.transverse.dto.TrajetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Dimitri on 06/04/15.
 */
@RestController
@RequestMapping("/rest")
public class TrajetRestController {

    @Autowired
    private TrajetService trajetService;

    @RequestMapping("/trajets")
    public List<TrajetDto> getTrajets() {
        return trajetService.rechercher();
    }

    @RequestMapping("/trajet/{id}")
    public TrajetDto getTrajet(@PathVariable("id") int id, HttpServletResponse response) {

        TrajetDto trajet = trajetService.getTrajet(id);

        if (null == trajet) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        return trajet;
    }
}
