package edu.fst.m2.ipii.carpooling.transverse.utils.binding;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.text.MessageFormat;

/**
 * Created by Dimitri on 29/11/14.
 */
public class BindingResultUtils {

    /**
     * Gets the binding messages.
     *
     * @param bindingResult the binding result
     * @return the binding messages
     */
    public static String getBindingMessages(BindingResult bindingResult) {
	String errors = "";
	for (ObjectError error : bindingResult.getAllErrors()) {
	    FieldError e;

	    try {
		    e = (FieldError) error;
	    } catch (ClassCastException exception) {
		    e = new FieldError("confirmation", "confirmation", "La confirmation ne correspond pas.");
	    }
	    errors += MessageFormat.format("{0} - {1} |", e.getField(), error.getDefaultMessage());
	}

	return errors;
    }
}
