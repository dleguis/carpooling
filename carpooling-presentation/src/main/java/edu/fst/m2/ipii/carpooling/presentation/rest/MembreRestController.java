package edu.fst.m2.ipii.carpooling.presentation.rest;

import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.UserLoginForm;
import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.TrajetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Dimitri on 09/04/2015.
 */
@RestController
@RequestMapping("/rest")
public class MembreRestController {

    @Autowired
    private MembreService membreService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public MembreDto getMembre(UserLoginForm userLoginForm) {
        return membreService.rechercher(userLoginForm.getLogin(), userLoginForm.getPassword());
    }
}
