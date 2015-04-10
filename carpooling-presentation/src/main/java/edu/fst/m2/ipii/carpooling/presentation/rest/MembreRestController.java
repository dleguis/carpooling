package edu.fst.m2.ipii.carpooling.presentation.rest;

import edu.fst.m2.ipii.carpooling.presentation.model.UserLoginModel;
import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dimitri on 09/04/2015.
 */
@RestController
@RequestMapping("/rest")
public class MembreRestController {

    @Autowired
    private MembreService membreService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public MembreDto getMembre(UserLoginModel userLoginModel) {
        return membreService.rechercher(userLoginModel.getLogin(), userLoginModel.getPassword());
    }
}
