package edu.fst.m2.ipii.carpooling.transverse.exception;


import edu.fst.m2.ipii.carpooling.transverse.exception.code.CarpoolingFonctionnelleExceptionCode;

/**
 * Created by Dimitri on 16/11/14.
 */
public class CarpoolingFonctionnelleException extends RuntimeException {

    /**
     * The exception cause.
     */
    CarpoolingFonctionnelleExceptionCode exceptionCause;

    /**
     * Instantiates a new bookstore fonctionnelle exception.
     *
     * @param cause the cause
     */
    public CarpoolingFonctionnelleException(CarpoolingFonctionnelleExceptionCode cause) {
        super(cause.getMessage());
        this.exceptionCause = cause;
    }

    /**
     * Gets the exception cause.
     *
     * @return the exception cause
     */
    public CarpoolingFonctionnelleExceptionCode getExceptionCause() {
	    return exceptionCause;
    }
}
