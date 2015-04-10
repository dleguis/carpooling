package edu.fst.m2.ipii.carpooling.presentation.controller;


import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.UserInscriptionModel;
import edu.fst.m2.ipii.carpooling.service.MembreService;
import edu.fst.m2.ipii.carpooling.transverse.dto.AdresseDto;
import edu.fst.m2.ipii.carpooling.transverse.dto.MembreDto;
import edu.fst.m2.ipii.carpooling.transverse.utils.binding.BindingResultUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Dimitri on 19/10/14.
 */
@Controller
public class LoginController {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	protected MembreService membreService;

    /**
     * The user service.
     */
    // @Autowired
    // private UserService userService;

    /**
     * Gets the login.
     *
     * @return the login
     */
    @RequestMapping(value = "/login-register.html", method = RequestMethod.GET)
    public String getLogin(Model model) {


		model.addAttribute("userModel", new UserInscriptionModel());
		model.addAttribute("errors", "");

		return "index";
    }


    /**
     * Post inscription.
     *
     * @param model
     *            the model
     * @param userInscriptionModel
     *            the user inscription model
     * @param bindingResult
     *            the binding result
     * @return the string
     */
    @RequestMapping(value = "/register.html", method = RequestMethod.POST)
	public String postInscription(Model model, @ModelAttribute("userModel") @Validated UserInscriptionModel userInscriptionModel,
								  BindingResult bindingResult) {


		// Création du UserDto à envoyer hghg
		MembreDto user = new MembreDto();
		user.setLogin(userInscriptionModel.getLogin());
		user.setPassword(userInscriptionModel.getPassword());
		user.setEmail(userInscriptionModel.getEmail());
		user.setNomMembre(userInscriptionModel.getLastName());
		user.setPrenomMembre(userInscriptionModel.getFirstName());

		membreService.nouveau(user);
		return "redirect:/mon-compte.html?success";


	}
}
