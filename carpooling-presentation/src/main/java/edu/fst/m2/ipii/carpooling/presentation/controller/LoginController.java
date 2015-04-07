package edu.fst.m2.ipii.carpooling.presentation.controller;


import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import edu.fst.m2.ipii.carpooling.presentation.model.UserInscriptionModel;
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
public class LoginController extends AbstractController {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

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

		// Si l'utilisateur est déjà connecté, pas besoin de lui remontrer la page de login
		if (null != getUserProfil()) {
			return "redirect:index.html";
		}

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

		if (!bindingResult.hasErrors()) {
			// Création du UserDto à envoyer
			/* UserDto user = new UserDto();
			user.setLogin(userInscriptionModel.getLogin());
			user.setPassword(userInscriptionModel.getPassword());
			user.setEmail(userInscriptionModel.getEmail());

			MailingAddressDto address = new MailingAddressDto();
			address.setLine1(userInscriptionModel.getLine1());
			address.setLine2(userInscriptionModel.getLine2());
			address.setLine3(userInscriptionModel.getLine3());
			address.setCity(userInscriptionModel.getCity());
			address.setZip(userInscriptionModel.getZip());

			user.setMailingAddress(address);

			// Enregistrement de l'utilisateur

			userService.creer(user);
			return "redirect:login.html";*/
		}

		String errors = BindingResultUtils.getBindingMessages(bindingResult);

		if (StringUtils.isNotEmpty(errors)) {
			model.addAttribute("errors", errors);
		}

		return "register";

    }
}
