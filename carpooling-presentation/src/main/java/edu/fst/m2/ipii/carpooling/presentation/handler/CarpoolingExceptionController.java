package edu.fst.m2.ipii.carpooling.presentation.handler;

import edu.fst.m2.ipii.carpooling.transverse.exception.CarpoolingFonctionnelleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Dimitri on 07/12/2014.
 */
@ControllerAdvice
public class CarpoolingExceptionController {

    /**
     * Erreur fonctionnelle.
     *
     * @param exception the exception
     * @return the model and view
     */
    @ExceptionHandler(CarpoolingFonctionnelleException.class)
    public ModelAndView erreurFonctionnelle(final CarpoolingFonctionnelleException exception, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorCode", exception.getExceptionCause().name());
        modelAndView.addObject("errorMessage", exception.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return modelAndView;
    }
}
