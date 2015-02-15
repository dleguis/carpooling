package edu.fst.m2.ipii.carpooling.presentation.controller;


import edu.fst.m2.ipii.carpooling.presentation.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dimitri on 19/10/14.
 */
@Controller
public class HomeController extends AbstractController {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    /**
     * The user service.
     */
    // @Autowired
    // private UserService userService;

    /**
     * Index.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "/", "index.html" }, method = RequestMethod.GET)
    public String index(Model model) {
        // model.addAttribute("users", userService.rechercher());
        return "index";
    }

}
